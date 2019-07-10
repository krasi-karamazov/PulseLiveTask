package kpk.dev.model.resource

import io.reactivex.Observable
import io.reactivex.exceptions.Exceptions
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

abstract class NetworkBoundResourse<ResultType, RequestType>(val isNetworkAvailable: Boolean) {

    private val result: Observable<Resource<ResultType>>

    init {
        val localObservable = Observable.defer {
            loadFromDb()
                .subscribeOn(Schedulers.io())
        }

        val remoteObservable = Observable.defer {
            createCall()
                .subscribeOn(Schedulers.io())
                .doOnNext {
                    if (it.isSuccessful) {
                        saveCallResult(processResponse(it))
                    }
                }
                .onErrorReturn { throw Exceptions.propagate(it) }
                .flatMap { loadFromDb() }
        }

        result = when {
            isNetworkAvailable -> remoteObservable
                .map<Resource<ResultType>> { Resource.Success(it) }
                .onErrorReturn { Resource.Failure(it) }
                .startWith(Observable.just(Resource.Loading()))
            else -> localObservable
                .map<Resource<ResultType>> { Resource.Success(it) }
                .onErrorReturn { Resource.Failure(it) }
                .startWith(Observable.just(Resource.Loading()))
        }
    }

    protected abstract fun loadFromDb(): Observable<ResultType>

    fun asObservable(): Observable<Resource<ResultType>> {
        return result
    }

    private fun processResponse(response: Response<RequestType>): RequestType {
        return response.body()!!
    }

    protected abstract fun saveCallResult(request: RequestType)

    protected abstract fun createCall(): Observable<Response<RequestType>>
}
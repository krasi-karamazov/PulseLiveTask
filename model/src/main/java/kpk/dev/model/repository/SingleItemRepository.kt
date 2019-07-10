package kpk.dev.model.repository

import io.reactivex.Observable
import kpk.dev.model.datasource.local.ItemDetailsLocalDataSource
import kpk.dev.model.datasource.remote.SingleItemRemoteDataSource
import kpk.dev.model.poko.ItemDetails
import kpk.dev.model.poko.ItemDetailsContainer
import kpk.dev.model.resource.NetworkBoundResourse
import kpk.dev.model.resource.Resource
import retrofit2.Response
import javax.inject.Inject

class SingleItemRepository @Inject constructor(
    val singleItemRemoteDataSource: SingleItemRemoteDataSource,
    val itemDetailsLocalDataSource: ItemDetailsLocalDataSource
) {

    fun getData(id: Int, isNetworkAvailable: Boolean): Observable<Resource<ItemDetails>> {

        return object : NetworkBoundResourse<ItemDetails, ItemDetailsContainer>(isNetworkAvailable) {
            override fun loadFromDb(): Observable<ItemDetails> {
                return Observable.fromCallable { itemDetailsLocalDataSource.itemDetailsDao.getItemById(id) }
            }

            override fun saveCallResult(request: ItemDetailsContainer) {
                itemDetailsLocalDataSource.itemDetailsDao.insertItem(request.item)
            }

            override fun createCall(): Observable<Response<ItemDetailsContainer>> {
                return Observable.just(singleItemRemoteDataSource.getItem(id))
            }

        }.asObservable()
    }
}
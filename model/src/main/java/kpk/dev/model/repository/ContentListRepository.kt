package kpk.dev.model.repository

import io.reactivex.Observable
import kpk.dev.model.datasource.local.ItemsLocalDataSource
import kpk.dev.model.datasource.remote.ContentListRemoteDataSource
import kpk.dev.model.poko.Item
import kpk.dev.model.poko.ItemsList
import kpk.dev.model.resource.NetworkBoundResourse
import kpk.dev.model.resource.Resource
import retrofit2.Response
import javax.inject.Inject

class ContentListRepository @Inject constructor(val contentListRemoteDataSource: ContentListRemoteDataSource, val itemsLocalDataSource: ItemsLocalDataSource): BaseRepository<List<Item>>() {

    override fun getData(isNetworkAvailable:Boolean): Observable<Resource<List<Item>>> {
        return object: NetworkBoundResourse<List<Item>, ItemsList>(isNetworkAvailable) {
            override fun saveCallResult(request: ItemsList) {
                itemsLocalDataSource.itemDao.insertAll(request.items)
            }

            override fun loadFromDb(): Observable<List<Item>> {
                return Observable.fromCallable { itemsLocalDataSource.itemDao.getAll() }
            }

            override fun createCall(): Observable<Response<ItemsList>> {
                return Observable.just(contentListRemoteDataSource.getContentList())
            }
        }.asObservable()
    }
}
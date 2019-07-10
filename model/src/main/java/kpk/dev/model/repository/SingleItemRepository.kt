package kpk.dev.model.repository

import io.reactivex.Observable
import kpk.dev.model.datasource.local.ItemDetailsLocalDataSource
import kpk.dev.model.datasource.local.ItemsLocalDataSource
import kpk.dev.model.datasource.remote.ContentListRemoteDataSource
import kpk.dev.model.datasource.remote.SingleItemRemoteDataSource
import kpk.dev.model.poko.Item
import kpk.dev.model.poko.ItemDetails
import kpk.dev.model.resource.NetworkBoundResourse
import kpk.dev.model.resource.Resource
import retrofit2.Response
import javax.inject.Inject

class SingleItemRepository @Inject constructor(val singleItemRemoteDataSource: SingleItemRemoteDataSource, val itemDetailsLocalDataSource: ItemDetailsLocalDataSource): BaseRepository<ItemDetails>()  {

    override fun getData(isNetworkAvailable: Boolean): Observable<Resource<ItemDetails>> {
        return object : NetworkBoundResourse<ItemDetails, ItemDetails>(isNetworkAvailable) {

            override fun saveCallResult(request: ItemDetails) {
                itemDetailsLocalDataSource.itemDetailsDao.insertItem(request)
            }

            override fun loadFromDb(): Observable<ItemDetails> {
                return Observable.fromCallable { itemDetailsLocalDataSource.itemDetailsDao.getItemById(36) }
            }

            override fun createCall(): Observable<Response<ItemDetails>> {
                return Observable.just(singleItemRemoteDataSource.getItem(36))
            }
        }.asObservable()
    }
}
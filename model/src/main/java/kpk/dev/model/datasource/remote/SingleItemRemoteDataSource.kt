package kpk.dev.model.datasource.remote

import io.reactivex.Single
import kpk.dev.model.poko.Item
import retrofit2.Retrofit
import javax.inject.Inject

class SingleItemRemoteDataSource @Inject constructor(retrofit: Retrofit): BaseRemoteDataSource(retrofit), ISingleItemRemoteDataSource {

    override fun getItem(id: Int): Single<Item> {
        return retrofit.create(PulseLiveAPI::class.java).getItemById(id)
    }

}
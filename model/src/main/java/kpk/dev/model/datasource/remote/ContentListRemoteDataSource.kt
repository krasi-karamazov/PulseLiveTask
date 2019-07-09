package kpk.dev.model.datasource.remote

import io.reactivex.Single
import kpk.dev.model.poko.ItemsList
import retrofit2.Retrofit
import javax.inject.Inject

class ContentListRemoteDataSource @Inject constructor(retrofit: Retrofit): BaseRemoteDataSource(retrofit), IContentListRemoteDataSource {

    override fun getContentList(): Single<ItemsList> {
        return create(PulseLiveAPI::class.java).getContentList()
    }

}
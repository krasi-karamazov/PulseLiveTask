package kpk.dev.model.datasource.remote

import kpk.dev.model.poko.ItemsList
import retrofit2.Response
import javax.inject.Inject

class ContentListRemoteDataSource @Inject constructor(val pulseLiveAPI: PulseLiveAPI): IContentListRemoteDataSource {

    override fun getContentList(): Response<ItemsList> {
        return pulseLiveAPI.getContentList().execute()
    }

}
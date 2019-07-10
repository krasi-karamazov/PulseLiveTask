package kpk.dev.model.datasource.remote

import kpk.dev.model.poko.ItemDetailsContainer
import retrofit2.Response
import javax.inject.Inject

class SingleItemRemoteDataSource @Inject constructor(val pulseLiveAPI: PulseLiveAPI): ISingleItemRemoteDataSource {

    override fun getItem(id: Int): Response<ItemDetailsContainer> {
        return pulseLiveAPI.getItemById(id).execute()
    }

}
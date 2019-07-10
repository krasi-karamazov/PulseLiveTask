package kpk.dev.model.datasource.remote

import io.reactivex.Single
import kpk.dev.model.poko.Item
import kpk.dev.model.poko.ItemDetails
import kpk.dev.model.poko.ItemsList
import retrofit2.Response
import javax.inject.Inject

class SingleItemRemoteDataSource @Inject constructor(val pulseLiveAPI: PulseLiveAPI): ISingleItemRemoteDataSource {

    override fun getItem(id: Int): Response<ItemDetails> {
        return pulseLiveAPI.getItemById(id).execute()
    }

}
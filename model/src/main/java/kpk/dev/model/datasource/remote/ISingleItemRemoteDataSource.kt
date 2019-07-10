package kpk.dev.model.datasource.remote

import io.reactivex.Single
import kpk.dev.model.poko.Item
import kpk.dev.model.poko.ItemDetails
import retrofit2.Response

interface ISingleItemRemoteDataSource {
    fun getItem(id: Int): Response<ItemDetails>
}
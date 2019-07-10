package kpk.dev.model.datasource.remote

import kpk.dev.model.poko.ItemDetailsContainer
import retrofit2.Response

interface ISingleItemRemoteDataSource {
    fun getItem(id: Int): Response<ItemDetailsContainer>
}
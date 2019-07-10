package kpk.dev.model.datasource.remote

import kpk.dev.model.poko.ItemsList
import retrofit2.Response

interface IContentListRemoteDataSource {
    fun getContentList(): Response<ItemsList>
}
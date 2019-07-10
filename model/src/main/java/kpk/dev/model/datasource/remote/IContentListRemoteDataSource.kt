package kpk.dev.model.datasource.remote

import io.reactivex.Single
import kpk.dev.model.poko.ItemsList
import retrofit2.Response

interface IContentListRemoteDataSource {
    fun getContentList(): Response<ItemsList>
}
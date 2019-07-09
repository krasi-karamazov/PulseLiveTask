package kpk.dev.model.datasource.remote

import io.reactivex.Single
import kpk.dev.model.poko.ItemsList

interface IContentListRemoteDataSource {
    fun getContentList(): Single<ItemsList>
}
package kpk.dev.model.datasource.remote

import io.reactivex.Single
import kpk.dev.model.poko.Item

interface ISingleItemRemoteDataSource {
    fun getItem(id: Int): Single<Item>
}
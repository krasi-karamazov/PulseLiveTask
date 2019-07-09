package kpk.dev.model.datasource.local

import io.reactivex.Single
import kpk.dev.model.poko.Item

interface IItemsLocalDataSource {
    fun getAllItems(): Single<List<Item>>
    fun getItemById(id: Int): Single<Item>
    fun addItems(items: List<Item>)
}
package kpk.dev.model.datasource.local

import io.reactivex.Single
import kpk.dev.model.poko.ItemDetails

interface IItemDetailsLocalDataSource {
    fun getAllItems(): Single<List<ItemDetails>>
    fun getItemById(id: Int): Single<ItemDetails>
    fun addItem(item: ItemDetails)
}
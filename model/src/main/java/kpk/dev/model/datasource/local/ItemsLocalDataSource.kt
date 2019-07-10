package kpk.dev.model.datasource.local

import io.reactivex.Single
import kpk.dev.model.poko.Item
import javax.inject.Inject

class ItemsLocalDataSource @Inject constructor(val itemDao: ItemDao): IItemsLocalDataSource {
    override fun getAllItems(): Single<List<Item>> {
       return Single.fromCallable { itemDao.getAll() }
    }

    override fun getItemById(id: Int): Single<Item> {
        return Single.fromCallable { itemDao.getItemById(id) }
    }

    override fun addItems(items: List<Item>) {
        itemDao.insertAll(items)
    }
}
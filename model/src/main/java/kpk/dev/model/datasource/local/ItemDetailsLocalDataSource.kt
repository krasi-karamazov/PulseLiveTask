package kpk.dev.model.datasource.local

import io.reactivex.Single
import kpk.dev.model.poko.ItemDetails
import javax.inject.Inject

class ItemDetailsLocalDataSource @Inject constructor(val itemDetailsDao: FullItemDao): IItemDetailsLocalDataSource {
    override fun getAllItems(): Single<List<ItemDetails>> {
        return Single.fromCallable { itemDetailsDao.getAll() }
    }

    override fun getItemById(id: Int): Single<ItemDetails> {
        return Single.fromCallable { itemDetailsDao.getItemById(id) }
    }

    override fun addItem(item: ItemDetails) {
        itemDetailsDao.insertItem(item)
    }
}
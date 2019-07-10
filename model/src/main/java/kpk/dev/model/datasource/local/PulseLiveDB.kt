package kpk.dev.model.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kpk.dev.model.poko.Item
import kpk.dev.model.poko.ItemDetails


@Database(entities = [Item::class, ItemDetails::class], version = 2, exportSchema = false)
abstract class PulseLiveDB : RoomDatabase() {

    abstract fun itemsDao(): ItemDao

    abstract fun fullItemDao(): FullItemDao
}
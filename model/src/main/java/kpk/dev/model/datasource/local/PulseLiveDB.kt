package kpk.dev.model.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import kpk.dev.model.poko.Item


@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class LocalDB : RoomDatabase() {

    abstract fun itemsDao(): Item
}
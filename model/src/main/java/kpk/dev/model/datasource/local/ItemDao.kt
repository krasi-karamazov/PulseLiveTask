package kpk.dev.model.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kpk.dev.model.poko.Item

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items: List<Item>)

    @Query("SELECT * FROM $ITEMS_TABLE_NAME")
    fun getAll(): List<Item>

    @Query("SELECT * FROM" + ITEMS_TABLE_NAME + "WHERE id=(:id)")
    fun getItemById(id: Int): Item
}
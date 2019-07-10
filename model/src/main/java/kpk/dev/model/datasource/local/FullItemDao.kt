package kpk.dev.model.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kpk.dev.model.poko.ItemDetails


@Dao
interface FullItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItem(item: ItemDetails)

    @Query("SELECT * FROM $FULL_ITEMS_TABLE_NAME")
    fun getAll(): List<ItemDetails>

    @Query("SELECT * FROM $FULL_ITEMS_TABLE_NAME WHERE id=(:id)")
    fun getItemById(id: Int): ItemDetails
}
package kpk.dev.model.poko

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kpk.dev.model.datasource.local.*

@Entity
data class ItemDetails(
    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: Int,

    @ColumnInfo(name = DATE)
    val date: String,

    @ColumnInfo(name = SUBTITLE)
    val subtitle: String,

    @ColumnInfo(name = TITLE)
    val title: String,

    @ColumnInfo(name = BODY)
    val body: String
)
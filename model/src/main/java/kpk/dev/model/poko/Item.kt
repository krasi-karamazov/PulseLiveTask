package kpk.dev.model.poko

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import kpk.dev.model.datasource.local.DATE
import kpk.dev.model.datasource.local.ID
import kpk.dev.model.datasource.local.SUBTITLE
import kpk.dev.model.datasource.local.TITLE

data class Item(

    @PrimaryKey
    @ColumnInfo(name = ID)
    val id: Int,

    @ColumnInfo(name = DATE)
    val date: String,

    @ColumnInfo(name = SUBTITLE)
    val subtitle: String,

    @ColumnInfo(name = TITLE)
    val title: String
)
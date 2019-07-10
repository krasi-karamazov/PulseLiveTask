package kpk.dev.model.datasource.remote

import io.reactivex.Single
import kpk.dev.model.poko.Item
import kpk.dev.model.poko.ItemDetails
import kpk.dev.model.poko.ItemsList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PulseLiveAPI {
    @GET("/test/native/contentList.json")
    fun getContentList(): Call<ItemsList>

    @GET("/test/native/content/{id}.json")
    fun getItemById(@Path("id") id: Int): Call<ItemDetails>
}
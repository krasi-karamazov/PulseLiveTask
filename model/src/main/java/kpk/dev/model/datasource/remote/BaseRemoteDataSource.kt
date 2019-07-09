package kpk.dev.model.datasource.remote

import retrofit2.Retrofit

open class BaseRemoteDataSource constructor(open val retrofit: Retrofit) {

    protected fun <T> create(clazz: Class<T>): T {
        return retrofit.create(clazz)
    }
}
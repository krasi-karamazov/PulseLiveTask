package kpk.dev.model.repository

import io.reactivex.Single
import kpk.dev.model.datasource.remote.PulseLiveAPI

abstract class BaseRepository<T> constructor(protected val palmsBetApi: PulseLiveAPI){
    abstract fun getItems(args: Map<String, Any>?): Single<T>

}
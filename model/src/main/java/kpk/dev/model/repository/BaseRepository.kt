package kpk.dev.model.repository

import io.reactivex.Observable
import io.reactivex.Single
import kpk.dev.model.datasource.remote.PulseLiveAPI
import kpk.dev.model.resource.Resource

abstract class BaseRepository<T> {
    abstract fun getData(isNetworkAvailable: Boolean): Observable<Resource<T>>

}
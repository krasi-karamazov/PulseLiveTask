package kpk.dev.domain

import io.reactivex.Observable
import io.reactivex.Single
import kpk.dev.model.repository.BaseRepository

abstract class BaseUseCase<RepositoryReturnType, UseCaseReturnType> constructor(val baseRepository: BaseRepository<RepositoryReturnType>) {
    abstract fun getData(isNetworkAvailable: Boolean): Observable<UseCaseReturnType>
}
package kpk.dev.domain

import io.reactivex.Observable
import kpk.dev.model.poko.ItemDetails
import kpk.dev.model.repository.SingleItemRepository
import kpk.dev.model.resource.Resource
import javax.inject.Inject

class ItemDetailsUseCase @Inject constructor(val repo: SingleItemRepository) {

    fun getData(id: Int, isNetworkAvailable: Boolean): Observable<Resource<ItemDetails>> {
        return repo.getData(id, isNetworkAvailable)
    }
}
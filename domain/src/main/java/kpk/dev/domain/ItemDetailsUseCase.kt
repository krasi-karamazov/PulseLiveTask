package kpk.dev.domain

import io.reactivex.Observable
import kpk.dev.model.poko.Item
import kpk.dev.model.poko.ItemDetails
import kpk.dev.model.repository.ContentListRepository
import kpk.dev.model.repository.SingleItemRepository
import kpk.dev.model.resource.Resource
import javax.inject.Inject

class ItemDetailsUseCase @Inject constructor(val repo: SingleItemRepository): BaseUseCase<ItemDetails, Resource<ItemDetails>>(repo) {

    override fun getData(isNetworkAvailable: Boolean): Observable<Resource<ItemDetails>> {
        return repo.getData(isNetworkAvailable)
    }
}
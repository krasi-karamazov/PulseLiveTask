package kpk.dev.domain

import io.reactivex.Observable
import kpk.dev.model.poko.Item
import kpk.dev.model.repository.ContentListRepository
import kpk.dev.model.resource.Resource
import javax.inject.Inject

class ContentListUseCase @Inject constructor(val repo: ContentListRepository): BaseUseCase<List<Item>, Resource<List<Item>>>(repo) {

    override fun getData(isNetworkAvailable: Boolean): Observable<Resource<List<Item>>> {
        return repo.getData(isNetworkAvailable)
    }
}
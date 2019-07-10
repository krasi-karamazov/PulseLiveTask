package kpk.dev.presentation.contentlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kpk.dev.domain.ContentListUseCase
import kpk.dev.model.poko.Item
import kpk.dev.model.resource.Resource
import kpk.dev.presentation.viewmodel.base.BaseViewModel
import javax.inject.Inject

class ContentListViewModel @Inject constructor(val useCase: ContentListUseCase, override var compositeDisposable: CompositeDisposable): BaseViewModel(compositeDisposable) {

    private val data:MutableLiveData<Resource<List<Item>>> = MutableLiveData()

    fun getContentList(isNetworkAvailable: Boolean): LiveData<Resource<List<Item>>> {
        compositeDisposable.add(useCase.getData(isNetworkAvailable)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                data.postValue(it)
            })

        return data
    }
}
package kpk.dev.presentation.itemdetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kpk.dev.domain.ItemDetailsUseCase
import kpk.dev.model.poko.ItemDetails
import kpk.dev.model.resource.Resource
import kpk.dev.presentation.viewmodel.base.BaseViewModel
import javax.inject.Inject

class ItemDetailsViewModel @Inject constructor(
    val useCase: ItemDetailsUseCase,
    override var compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable) {
    private val data: MutableLiveData<Resource<ItemDetails>> = MutableLiveData()

    fun getItemDetails(id: Int, isNetworkAvailable: Boolean): LiveData<Resource<ItemDetails>> {
        compositeDisposable.add(useCase.getData(id, isNetworkAvailable)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                data.postValue(it)
            })

        return data
    }
}
package kpk.dev.presentation.contentlist.view

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import kpk.dev.model.resource.Resource
import kpk.dev.presentation.R
import kpk.dev.presentation.view.fragments.BaseFragment
import kpk.dev.presentation.contentlist.viewmodel.ContentListViewModel
import kpk.dev.presentation.viewmodel.factory.ViewModelFactory
import javax.inject.Inject

class ContentListFragment : BaseFragment(){

    @Inject
    internal lateinit var vmFactory:ViewModelFactory

    private lateinit var viewModel: ContentListViewModel

    companion object{
        fun getInstance(args: Bundle?): ContentListFragment {
            val fragment = ContentListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun init() {
        viewModel = vmFactory.get()
        viewModel.getContentList(true)
            .observe(this, Observer {
                when (it) {
                    is Resource.Loading -> Log.d("LOADING", "LOADING")
                    is Resource.Failure -> Log.d("ERROR", it.throwable.message)
                    else -> {
                        Log.d("SUCCESS", "SUCCESS")
                    }
                }
            })
    }

    override fun getLayoutId(): Int = R.layout.fragment_list
}
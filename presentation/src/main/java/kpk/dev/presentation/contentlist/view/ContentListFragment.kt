package kpk.dev.presentation.contentlist.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_list.*
import kpk.dev.model.resource.Resource
import kpk.dev.presentation.R
import kpk.dev.presentation.contentlist.ContentListAdapter
import kpk.dev.presentation.contentlist.viewmodel.ContentListViewModel
import kpk.dev.presentation.extensions.isConnected
import kpk.dev.presentation.main.MainActivity
import kpk.dev.presentation.view.fragments.BaseFragment
import kpk.dev.presentation.viewmodel.factory.ViewModelFactory
import javax.inject.Inject

class ContentListFragment : BaseFragment(){

    @Inject
    internal lateinit var vmFactory:ViewModelFactory

    private lateinit var viewModel: ContentListViewModel

    private val contentListAdapter: ContentListAdapter by lazy {
        ContentListAdapter {
            itemCLicked(it)
        }
    }

    companion object{
        fun getInstance(args: Bundle?): ContentListFragment {
            val fragment = ContentListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun init() {
        viewModel = vmFactory.get()
        viewModel.getContentList(isConnected(activity as AppCompatActivity))
            .observe(this, Observer {
                when (it) {
                    is Resource.Loading -> pb_loading_data.visibility = View.VISIBLE
                    is Resource.Failure -> {
                        pb_loading_data.visibility = View.GONE
                        displayError(it.throwable.message)
                    }
                    is Resource.Success -> {
                        pb_loading_data.visibility = View.GONE
                        contentListAdapter.updateData(it.data)
                    }
                }
            })
        rv_content.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rv_content.adapter = contentListAdapter
    }


    private fun itemCLicked(id: Int) {
        (activity as MainActivity).displayItemDetails(id)
    }

    override fun getLayoutId(): Int = R.layout.fragment_list
}
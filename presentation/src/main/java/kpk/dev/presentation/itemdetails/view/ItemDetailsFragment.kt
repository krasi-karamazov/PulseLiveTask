package kpk.dev.presentation.itemdetails.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_item_details.*
import kpk.dev.model.poko.ItemDetails
import kpk.dev.model.resource.Resource
import kpk.dev.presentation.R
import kpk.dev.presentation.itemdetails.viewmodel.ItemDetailsViewModel
import kpk.dev.presentation.view.fragments.BaseFragment
import kpk.dev.presentation.viewmodel.factory.ViewModelFactory
import javax.inject.Inject

class ItemDetailsFragment : BaseFragment() {

    @Inject
    internal lateinit var vmFactory: ViewModelFactory

    private lateinit var viewModel: ItemDetailsViewModel

    companion object {

        const val ITEM_ID_ARG_KEY = "item_details"

        fun getInstance(args: Bundle): ItemDetailsFragment {
            val fragment = ItemDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun init() {
        viewModel = vmFactory.get()
        viewModel.getItemDetails(arguments!!.getInt(ITEM_ID_ARG_KEY), true)
            .observe(this, Observer {
                when (it) {
                    is Resource.Loading -> {
                        pb_loading_data.visibility = View.VISIBLE
                        main_content.visibility = View.GONE
                    }
                    is Resource.Failure -> {
                        pb_loading_data.visibility = View.GONE
                        displayError(it.throwable.message)
                    }
                    is Resource.Success -> {
                        pb_loading_data.visibility = View.GONE
                        main_content.visibility = View.VISIBLE
                        displayData(it.data)
                    }
                }
            })
    }

    fun displayData(data: ItemDetails?) {
        data?.let {
            val titleSegments = it.title.split(" ")
            val title = StringBuilder()
            for (segment in titleSegments) {
                title.append(segment[0])
            }

            tv_article_deco.text = title
            tv_title.text = it.title
            tv_subtitle.text = it.subtitle
            tv_date.text = it.date
            tv_body.text = it.body
        }
    }

    override fun getLayoutId(): Int = R.layout.fragment_item_details
}
package kpk.dev.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kpk.dev.presentation.R
import kpk.dev.presentation.contentlist.view.ContentListFragment
import kpk.dev.presentation.itemdetails.view.ItemDetailsFragment
import kpk.dev.presentation.view.base.BaseActivity
import javax.inject.Inject

class MainActivity: BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (supportFragmentManager.findFragmentByTag(ContentListFragment::class.java.simpleName) == null) {
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.fl_fragment_cointainer,
                    ContentListFragment.getInstance(null),
                    ContentListFragment::class.java.simpleName
                )
                .addToBackStack("contentList")
                .commit()
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            super.onBackPressed()
        }
    }

    fun displayItemDetails(id: Int) {

        val bundle = Bundle()
        bundle.putInt(ItemDetailsFragment.ITEM_ID_ARG_KEY, id)

        supportFragmentManager.beginTransaction()
            .add(
                R.id.fl_fragment_cointainer,
                ItemDetailsFragment.getInstance(bundle),
                ItemDetailsFragment::class.java.simpleName
            )
            .addToBackStack("contentList")
            .commit()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

}
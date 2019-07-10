package kpk.dev.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kpk.dev.presentation.R
import kpk.dev.presentation.view.base.BaseActivity
import kpk.dev.presentation.contentlist.view.ContentListFragment
import javax.inject.Inject

class MainActivity: BaseActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .add(R.id.fl_fragment_cointainer, ContentListFragment.getInstance(null), "")
            .addToBackStack("contentList")
            .commit()
    }

    override fun getLayoutId(): Int = R.layout.activity_main

}
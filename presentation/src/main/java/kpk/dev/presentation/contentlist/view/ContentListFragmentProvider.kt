package kpk.dev.presentation.contentlist.view

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ContentListFragmentProvider {

    @ContributesAndroidInjector
    internal abstract fun provideContentListFragment(): ContentListFragment
}
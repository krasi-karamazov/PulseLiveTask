package kpk.dev.presentation.itemdetails.view

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ItemDetailsFragmentProvider {

    @ContributesAndroidInjector
    internal abstract fun provideItemDetailsFragment(): ItemDetailsFragment
}
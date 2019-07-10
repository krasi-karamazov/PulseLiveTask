package kpk.dev.presentation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kpk.dev.presentation.contentlist.view.ContentListFragmentProvider
import kpk.dev.presentation.itemdetails.view.ItemDetailsFragmentProvider
import kpk.dev.presentation.main.MainActivity

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [ContentListFragmentProvider::class, ItemDetailsFragmentProvider::class])
    abstract fun bindSplashActivity(): MainActivity
}
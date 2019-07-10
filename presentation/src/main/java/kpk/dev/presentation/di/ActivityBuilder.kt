package kpk.dev.presentation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kpk.dev.presentation.main.MainActivity
import kpk.dev.presentation.contentlist.view.ContentListFragmentProvider

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(ContentListFragmentProvider::class)])
    abstract fun bindSplashActivity(): MainActivity
}
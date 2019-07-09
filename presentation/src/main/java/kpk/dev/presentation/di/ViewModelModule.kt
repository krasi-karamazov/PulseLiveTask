package kpk.dev.presentation.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import kpk.dev.presentation.viewmodel.factory.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    //Add more ViewModels here
}
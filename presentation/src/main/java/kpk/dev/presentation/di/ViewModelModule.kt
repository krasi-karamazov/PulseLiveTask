package kpk.dev.presentation.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kpk.dev.presentation.contentlist.viewmodel.ContentListViewModel
import kpk.dev.presentation.viewmodel.factory.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ContentListViewModel::class)
    internal abstract fun bindContentListViewModel(viewModel: ContentListViewModel): ViewModel

    //Add more ViewModels here
}
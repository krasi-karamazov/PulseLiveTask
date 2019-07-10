package kpk.dev.pulselivetask.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import kpk.dev.model.di.DataSourceModule
import kpk.dev.model.di.NetworkingModule
import kpk.dev.presentation.di.ActivityBuilder
import kpk.dev.presentation.di.ApplicationModule
import kpk.dev.presentation.di.DisposableModule
import kpk.dev.presentation.di.ViewModelModule
import kpk.dev.pulselivetask.application.PulseLiveTaskApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ActivityBuilder::class, NetworkingModule::class, DisposableModule::class, ViewModelModule::class, ApplicationModule::class, DataSourceModule::class])
interface ApplicationComponent {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application:Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(application: PulseLiveTaskApplication)

}
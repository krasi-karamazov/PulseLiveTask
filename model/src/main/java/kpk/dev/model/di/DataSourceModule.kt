package kpk.dev.model.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import kpk.dev.model.datasource.local.*
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    internal fun providePulseLiveDB(application: Application): PulseLiveDB = Room.databaseBuilder(application, PulseLiveDB::class.java, DB_NAME).build()

    @Provides
    @Singleton
    internal fun provideItemsDao(pulseLiveDB: PulseLiveDB) = pulseLiveDB.itemsDao()

    @Provides
    @Singleton
    internal fun provideItemDetailsDao(pulseLiveDB: PulseLiveDB) = pulseLiveDB.fullItemDao()

    @Provides
    @Singleton
    internal fun provideLocalDataSource(itemDao: ItemDao): IItemsLocalDataSource = ItemsLocalDataSource(itemDao)

    @Provides
    @Singleton
    internal fun provideItemDetailsLocalDataSource(fullItemDao: FullItemDao): IItemDetailsLocalDataSource = ItemDetailsLocalDataSource(fullItemDao)
}
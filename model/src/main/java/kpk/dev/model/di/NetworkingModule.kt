package kpk.dev.model.di

import dagger.Module
import dagger.Provides
import kpk.dev.model.PALMSBET_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkingModule {

    @Provides
    @Singleton
    internal fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(PALMSBET_BASE_URL)
            .build()
    }


    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptorBody = HttpLoggingInterceptor()
        loggingInterceptorBody.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder().cache(null)
            .addInterceptor(loggingInterceptorBody)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS).build()
    }
}
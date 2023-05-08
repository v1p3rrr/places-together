package com.vpr.places_together.di

import android.content.Context
import androidx.room.Room
import com.vpr.places_together.data.local.database.PlacesTogetherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "http://10.0.2.2:8080/"

//    @Singleton
//    @Provides
//    fun provideRepository(service: sService, dao: Dao): Repository = RepositoryImpl(api = service, dao = dao)

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectionSpecs(listOf(ConnectionSpec.CLEARTEXT, ConnectionSpec.MODERN_TLS))
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//    @Singleton
//    @Provides
//    fun providesService(retrofit: Retrofit): sService = retrofit.create(sService::class.java)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context.applicationContext,
            PlacesTogetherDatabase::class.java,
            "gasoline_price_database"
        ).build()

    @Singleton
    @Provides
    fun provideAccountDao(database: PlacesTogetherDatabase) = database.accountDao()

    @Singleton
    @Provides
    fun provideProfileDao(database: PlacesTogetherDatabase) = database.profileDao()

    @Singleton
    @Provides
    fun provideFriendshipDao(database: PlacesTogetherDatabase) = database.friendshipDao()

    @Singleton
    @Provides
    fun provideGroupDao(database: PlacesTogetherDatabase) = database.groupDao()

    @Singleton
    @Provides
    fun providePlaceDao(database: PlacesTogetherDatabase) = database.placeDao()

    @Singleton
    @Provides
    fun provideGroupMembershipDao(database: PlacesTogetherDatabase) = database.groupMembershipDao()

    @Singleton
    @Provides
    fun provideGroupPlaceDao(database: PlacesTogetherDatabase) = database.groupPlaceDao()

    @Singleton
    @Provides
    fun provideMarkPlaceDao(database: PlacesTogetherDatabase) = database.markPlaceDao()

    @Singleton
    @Provides
    fun provideCommentPlaceDao(database: PlacesTogetherDatabase) = database.commentPlaceDao()

    @Singleton
    @Provides
    fun provideRatingPlaceDao(database: PlacesTogetherDatabase) = database.ratingPlaceDao()
    
}
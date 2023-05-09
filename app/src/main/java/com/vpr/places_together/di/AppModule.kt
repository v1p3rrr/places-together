package com.vpr.places_together.di

import android.content.Context
import androidx.room.Room
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vpr.places_together.BuildConfig
import com.vpr.places_together.R
import com.vpr.places_together.data.local.database.PlacesTogetherDatabase
import com.vpr.places_together.data.remote.service.AccountProfileApiService
import com.vpr.places_together.data.remote.service.AuthService
import com.vpr.places_together.data.remote.service.CommentApiService
import com.vpr.places_together.data.remote.service.FriendshipApiService
import com.vpr.places_together.data.remote.service.GoogleSignInService
import com.vpr.places_together.data.remote.service.GroupApiService
import com.vpr.places_together.data.remote.service.MarkGroupPlaceApiService
import com.vpr.places_together.data.remote.service.PlaceApiService
import com.vpr.places_together.data.remote.service.RatingApiService
import com.vpr.places_together.data.repository.AuthRepositoryImpl
import com.vpr.places_together.data.repository.SessionManager
import com.vpr.places_together.domain.repository.AuthRepository
import com.vpr.places_together.utils.LocalDateTimeDeserializer
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
import java.time.LocalDateTime
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "http://localhost:8080/"

    @Singleton
    @Provides
    fun provideAuthRepository(service: AuthService): AuthRepository =
        AuthRepositoryImpl(apiService = service)

    @Provides
    @Singleton
    fun provideGoogleSignInService(@ApplicationContext context: Context): GoogleSignInService {
        return GoogleSignInService(context)
    }

    @Provides
    @Singleton
    fun provideGso(@ApplicationContext context: Context): GoogleSignInOptions =
        GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestIdToken(BuildConfig.WEB_CLIENT_ID)
            .build()

    @Provides
    @Singleton
    fun provideGoogleSignInClient(
        @ApplicationContext context: Context,
        gso: GoogleSignInOptions
    ): GoogleSignInClient =
        GoogleSignIn.getClient(context, gso)

    @Provides
    @Singleton
    fun provideSessionManager(@ApplicationContext context: Context): SessionManager =
        SessionManager(context)

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideGson(): Gson =
        GsonBuilder().registerTypeAdapter(LocalDateTime::class.java, LocalDateTimeDeserializer())
            .setLenient()
            .create()

    @Singleton
    @Provides
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectionSpecs(listOf(ConnectionSpec.CLEARTEXT, ConnectionSpec.MODERN_TLS))
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Singleton
    @Provides
    fun provideAuthService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)

    @Singleton
    @Provides
    fun provideAccountProfileApiService(retrofit: Retrofit): AccountProfileApiService =
        retrofit.create(AccountProfileApiService::class.java)

    @Singleton
    @Provides
    fun provideCommentApiService(retrofit: Retrofit): CommentApiService =
        retrofit.create(CommentApiService::class.java)

    @Singleton
    @Provides
    fun provideFriendshipApiService(retrofit: Retrofit): FriendshipApiService =
        retrofit.create(FriendshipApiService::class.java)

    @Singleton
    @Provides
    fun provideGroupApiService(retrofit: Retrofit): GroupApiService =
        retrofit.create(GroupApiService::class.java)

    @Singleton
    @Provides
    fun provideMarkGroupPlaceApiService(retrofit: Retrofit): MarkGroupPlaceApiService =
        retrofit.create(MarkGroupPlaceApiService::class.java)

    @Singleton
    @Provides
    fun providePlaceApiService(retrofit: Retrofit): PlaceApiService =
        retrofit.create(PlaceApiService::class.java)

    @Singleton
    @Provides
    fun provideRatingApiService(retrofit: Retrofit): RatingApiService =
        retrofit.create(RatingApiService::class.java)

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
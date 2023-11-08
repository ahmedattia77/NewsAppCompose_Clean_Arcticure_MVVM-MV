package com.example.newsapp.di

import android.app.Application
import androidx.room.Room
import com.example.newsapp.data.local.ArticleDao
import com.example.newsapp.data.local.ArticleDatabase
import com.example.newsapp.data.local.ArticleTypeConvertor
import com.example.newsapp.data.manger.LocalUserMangerImpl
import com.example.newsapp.data.remote.ApiService
import com.example.newsapp.data.repository.ArticlesRepositoryImp
import com.example.newsapp.data.repository.SearchArticlesRepositoryImp
import com.example.newsapp.domain.manger.LocalUserManger
import com.example.newsapp.domain.repository.ArticlesRepository
import com.example.newsapp.domain.repository.SearchArticlesRepository
import com.example.newsapp.domain.usacase.app_entry.AppEntryUseCases
import com.example.newsapp.domain.usacase.app_entry.ReadUserEntry
import com.example.newsapp.domain.usacase.app_entry.SaveUserEntry
import com.example.newsapp.domain.usacase.articles.ArticlesUseCase
import com.example.newsapp.domain.usacase.articles.DeleteArticle
import com.example.newsapp.domain.usacase.articles.GetArticles
import com.example.newsapp.domain.usacase.articles.SearchArticles
import com.example.newsapp.domain.usacase.articles.SearchArticlesUseCase
import com.example.newsapp.domain.usacase.articles.SelectArticle
import com.example.newsapp.domain.usacase.articles.UpsertArticle
import com.example.newsapp.domain.usacase.articles.room_usecase.RoomArticlesUseCase
import com.example.newsapp.utils.Constants.ARTICLE_DB_NAME
import com.example.newsapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(
        localUserManger: LocalUserManger
    ) = AppEntryUseCases(
        readUserEntry = ReadUserEntry(localUserManger),
        saveUserEntry = SaveUserEntry(localUserManger)
    )


    @Provides
    @Singleton
    fun provideApiInstance(): ApiService {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideArticlesRepository(apiService: ApiService):
            ArticlesRepository = ArticlesRepositoryImp(apiService)


    @Provides
    @Singleton
    fun provideSearchArticlesRepository(apiService: ApiService):
            SearchArticlesRepository = SearchArticlesRepositoryImp(apiService)

    @Provides
    @Singleton
    fun provideArticleRepo(articlesRepository: ArticlesRepository):
            ArticlesUseCase = ArticlesUseCase(getArticles = GetArticles(articlesRepository))
    @Provides
    @Singleton
    fun provideSearchArticleRepo(articlesRepository: SearchArticlesRepository):
            SearchArticlesUseCase = SearchArticlesUseCase(searchArticles = SearchArticles(articlesRepository))

    @Provides
    @Singleton
    fun provideRoomArticleUseCases(
        articleDao: ArticleDao ,

    ) : RoomArticlesUseCase = RoomArticlesUseCase(
        upsertArticles = UpsertArticle(articleDao) ,
        selectArticle = SelectArticle(articleDao) ,
        deleteArticle =DeleteArticle(articleDao))

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): ArticleDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = ArticleDatabase::class.java,
            name = ARTICLE_DB_NAME
        ).addTypeConverter(ArticleTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        articleDatabase: ArticleDatabase
    ): ArticleDao = articleDatabase.newsDao



}
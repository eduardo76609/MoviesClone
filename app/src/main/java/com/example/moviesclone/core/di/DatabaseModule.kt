package com.example.moviesclone.core.di

import android.content.Context
import androidx.room.Room
import com.example.moviesclone.core.persistence.MoviesCloneDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DB_FILE_NAME = "moviesclone.db"

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context): MoviesCloneDatabase {
        return Room.databaseBuilder(
            context,
            MoviesCloneDatabase::class.java,
            DB_FILE_NAME
        ).fallbackToDestructiveMigration().build()
    }

//    @Provides
//    fun provideMemberDao(database: MoviesCloneDatabase): MemberDao = database.memberDao()
//
//    @Provides
//    fun provideLocalAccountDataSource(memberDao: MemberDao) =
//        LocalAccountDataSource(memberDao)

}
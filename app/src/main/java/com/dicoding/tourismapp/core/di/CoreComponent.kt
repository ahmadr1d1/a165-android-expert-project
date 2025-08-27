package com.dicoding.tourismapp.core.di

import android.content.Context
import com.dicoding.tourismapp.core.domain.repository.ITourismRepository
import dagger.*
import jakarta.inject.Singleton

@Singleton
@Component(
    modules = [RepositoryModule::class]
)
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): CoreComponent
    }

    fun provideRepository() : ITourismRepository
}
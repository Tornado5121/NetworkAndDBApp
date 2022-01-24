package com.natife.example.networkandbdapp.di

import android.content.Context
import com.natife.example.networkandbdapp.ui.userDetailedScreen.UserDetailedFragment
import com.natife.example.networkandbdapp.ui.userListScreen.UserListFragment
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Component(
    modules = [ContextModule::class, DataModule::class]
)
@Singleton
interface AppComponent {

    fun inject(userListFragment: UserListFragment)
    fun inject(userDetailedFragment: UserDetailedFragment)

    @Component.Builder
    interface Builder {

        fun contextModule(contextModule: ContextModule): Builder
        fun build(): AppComponent

    }

}

@Module
class ContextModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

}

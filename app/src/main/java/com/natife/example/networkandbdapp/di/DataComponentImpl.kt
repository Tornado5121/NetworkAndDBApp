package com.natife.example.networkandbdapp.di

import android.content.Context
import com.natife.example.networkandbdapp.ui.MainActivity
import com.natife.example.networkandbdapp.ui.userListScreen.UserListFragment
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [
        DataModule::class,
    ]
)
interface DataComponent {}

@Component(
    dependencies = [
        DataComponent::class
    ],
    modules = [ContextModule::class]
)
interface AppComponent {

    fun inject(userListFragment: UserListFragment)

    @Component.Builder
    interface Builder {

        fun contextModule(contextModule: ContextModule): Builder

        fun dataComponent(dataComponent: DataComponent): Builder

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

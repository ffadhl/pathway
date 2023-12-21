package com.fadhlalhafizh.pathway.app.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fadhlalhafizh.pathway.app.ui.login.LoginViewModel
import com.fadhlalhafizh.pathway.app.ui.main.MainViewModel
import com.fadhlalhafizh.pathway.app.ui.main.ui.home.HomeViewModel
import com.fadhlalhafizh.pathway.app.ui.path.inputpath.InputPathActivityViewModel
import com.fadhlalhafizh.pathway.app.ui.path.outputpath.OutputPathActivityViewModel
import com.fadhlalhafizh.pathway.app.ui.register.RegisterViewModel
import com.fadhlalhafizh.pathway.data.repository.UserRepository
import com.fadhlalhafizh.pathway.di.Injection

class ViewModelFactory(private val repository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(RegisterViewModel::class.java) -> {
                RegisterViewModel(repository) as T
            }

            modelClass.isAssignableFrom(LoginViewModel::class.java) -> {
                LoginViewModel(repository) as T
            }

            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(repository) as T
            }

            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                HomeViewModel(repository) as T
            }

            modelClass.isAssignableFrom(InputPathActivityViewModel::class.java) -> {
                InputPathActivityViewModel(repository) as T
            }

            modelClass.isAssignableFrom(OutputPathActivityViewModel::class.java) -> {
                OutputPathActivityViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(context: Context): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}
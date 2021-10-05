package com.github.sookhee.kotlinandroidtemplate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.sookhee.data.UserRepositoryImpl
import com.github.sookhee.data.datasource.UserDataSourceImpl
import com.github.sookhee.data.network.RetrofitBuilder
import com.github.sookhee.domain.usecase.GetUserListUseCase
import com.github.sookhee.domain.usecase.GetUserListUseCaseImpl

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val getUserListUseCase: GetUserListUseCase
) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>) =
        when (modelClass::class.java) {
            MainViewModel::class.java ->
                MainViewModel(getUserListUseCase)

            else ->
                MainViewModel(getUserListUseCase)

        } as T

    companion object {
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance() =
            INSTANCE
                ?: synchronized(ViewModelFactory::class.java) {
                    INSTANCE
                        ?: ViewModelFactory(
                            getUserListUseCase = GetUserListUseCaseImpl(
                                UserRepositoryImpl(
                                    UserDataSourceImpl(
                                        RetrofitBuilder.apiService
                                    )
                                )
                            )
                        )
                }
    }
}

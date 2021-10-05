package com.github.sookhee.kotlinandroidtemplate

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.sookhee.domain.entity.UserList
import com.github.sookhee.domain.usecase.GetUserListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val getUserListUseCase: GetUserListUseCase) : ViewModel() {
    private val _userList = MutableStateFlow(UserList(results = arrayListOf()))
    val userList: StateFlow<UserList>
        get() = _userList

    fun getUserList(size: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getUserListUseCase.getUserList(size)

                _userList.value = result
            } catch (exception: Exception) {
                Log.e("MainViewModel", "exception: ${exception.message}")
            }
        }
    }
}

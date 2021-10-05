package com.github.sookhee.data.datasource

import com.github.sookhee.data.network.ApiService
import com.github.sookhee.data.spec.UserList

class UserDataSourceImpl(private val apiService: ApiService) : UserDataSource {
    override suspend fun requestUserList(size: Int): UserList {
        return apiService.getUsers(size)
    }
}

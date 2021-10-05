package com.github.sookhee.data.datasource

import com.github.sookhee.data.spec.UserList

interface UserDataSource {
    suspend fun requestUserList(size: Int): UserList
}

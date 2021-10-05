package com.github.sookhee.domain

import com.github.sookhee.domain.entity.UserList

interface UserRepository {
    suspend fun requestUserList(size: Int): UserList
}

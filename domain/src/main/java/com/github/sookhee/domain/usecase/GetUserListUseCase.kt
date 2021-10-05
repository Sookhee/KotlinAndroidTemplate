package com.github.sookhee.domain.usecase

import com.github.sookhee.domain.entity.UserList

interface GetUserListUseCase {
    suspend fun getUserList(size: Int): UserList
}

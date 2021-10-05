package com.github.sookhee.domain.usecase

import com.github.sookhee.domain.UserRepository
import com.github.sookhee.domain.entity.UserList

class GetUserListUseCaseImpl(private val userRepository: UserRepository) : GetUserListUseCase {
    override suspend fun getUserList(size: Int): UserList {
        return userRepository.requestUserList(size)
    }
}

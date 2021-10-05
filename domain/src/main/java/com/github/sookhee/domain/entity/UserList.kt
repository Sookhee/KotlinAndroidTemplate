package com.github.sookhee.domain.entity

data class UserList(
    val results: ArrayList<User>
)

data class User(
    val name: String,
    val nation: String
)

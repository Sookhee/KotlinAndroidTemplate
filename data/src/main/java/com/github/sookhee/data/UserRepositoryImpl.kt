package com.github.sookhee.data

import com.github.sookhee.data.datasource.UserDataSource
import com.github.sookhee.domain.UserRepository
import com.github.sookhee.domain.entity.User
import com.github.sookhee.domain.entity.UserList

class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override suspend fun requestUserList(size: Int): UserList {
        val results = ArrayList<User>()

        val response = userDataSource.requestUserList(size)
        response.results.forEach {
            results.add(
                User(
                    name = "${it.name.last} ${it.name.first}",
                    nation = when (it.nation) {
                        "AU" -> "\uD83C\uDDE6\uD83C\uDDFA"
                        "BR" -> "\uD83C\uDDE7\uD83C\uDDF7"
                        "CA" -> "\uD83C\uDDE8\uD83C\uDDE6"
                        "CH" -> "\uD83C\uDDE8\uD83C\uDDED"
                        "DE" -> "\uD83C\uDDE9\uD83C\uDDEA"
                        "DK" -> "\uD83C\uDDE9\uD83C\uDDF0"
                        "ES" -> "\uD83C\uDDEA\uD83C\uDDF8"
                        "FI" -> "\uD83C\uDDEB\uD83C\uDDEE"
                        "FR" -> "\uD83C\uDDEB\uD83C\uDDF7"
                        "GB" -> "\uD83C\uDDEC\uD83C\uDDE7"
                        "IE" -> "\uD83C\uDDEE\uD83C\uDDEA"
                        "IR" -> "\uD83C\uDDEE\uD83C\uDDF7"
                        "NO" -> "\uD83C\uDDF3\uD83C\uDDF4"
                        "NL" -> "\uD83C\uDDF3\uD83C\uDDF1"
                        "NZ" -> "\uD83C\uDDF3\uD83C\uDDFF"
                        "TR" -> "\uD83C\uDDF9\uD83C\uDDF7"
                        "US" -> "\uD83C\uDDFA\uD83C\uDDF8"
                        else -> "\uD83C\uDDFA\uD83C\uDDF8"
                    }
                )
            )
        }

        return UserList(results)
    }
}

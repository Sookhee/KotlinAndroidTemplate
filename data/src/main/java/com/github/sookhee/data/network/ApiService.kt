package com.github.sookhee.data.network

import com.github.sookhee.data.spec.UserList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/api")
    suspend fun getUsers(@Query("results") key: Int): UserList
}

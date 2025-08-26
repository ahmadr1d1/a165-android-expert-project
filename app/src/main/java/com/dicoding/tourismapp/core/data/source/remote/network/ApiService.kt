package com.dicoding.tourismapp.core.data.source.remote.network

import com.dicoding.tourismapp.core.data.source.remote.response.ListTourismResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.*

interface ApiService {
    @GET("list")
    fun getList(): Flowable<ListTourismResponse>
}
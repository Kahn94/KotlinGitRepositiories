package ru.kahn.kotlingitrepositiories.interfaces

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.kahn.kotlingitrepositiories.model.ModelAutorRepo

interface MainApi {
    @GET("repositories")
    fun getGitResponce(@Query("language") language: String, @Query("since") since: String?): Call<MutableList<ModelAutorRepo>>
}
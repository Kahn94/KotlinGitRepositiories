package ru.kahn.kotlingitrepositiories.application

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.kahn.kotlingitrepositiories.interfaces.MainApi

class AppKotlinGitRepo : Application() {
    companion object {
        var retrofit = Retrofit.Builder()
            .baseUrl("https://ghapi.huchen.dev/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiInterface: MainApi = retrofit.create(
            MainApi:: class.java)
    }
}
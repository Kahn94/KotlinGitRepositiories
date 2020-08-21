package ru.kahn.kotlingitrepositiories.model

import android.app.Activity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.kahn.kotlingitrepositiories.adapter.AdapterMain
import ru.kahn.kotlingitrepositiories.application.AppKotlinGitRepo
import ru.kahn.kotlingitrepositiories.interfaces.MainContract
import ru.kahn.kotlingitrepositiories.model.ModelAutorRepo

class MainResponce : MainContract.Responce {

    override fun loadGitRepo(since: String?, view: Activity, adapter: AdapterMain) {

        val call: Call<MutableList<ModelAutorRepo>> = AppKotlinGitRepo.apiInterface.getGitResponce("kotlin", since) //weekly
        call.enqueue(object : Callback<MutableList<ModelAutorRepo>> {
            override fun onResponse(call: Call<MutableList<ModelAutorRepo>>, response: Response<MutableList<ModelAutorRepo>>) {
                adapter.arrayListRepo.clear()
                adapter.arrayListRepo = response.body()!!
                adapter.notifyDataSetChanged()
                view.sr_activity_main.isRefreshing = false
            }

            override fun onFailure(call: Call<MutableList<ModelAutorRepo>>, t: Throwable) {
                Log.e("ОШИБКА", t.toString())
            }
        })
    }
}
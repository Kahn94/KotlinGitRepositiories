package ru.kahn.kotlingitrepositiories.presenter

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.activity_main.*
import ru.kahn.kotlingitrepositiories.model.MainResponce
import ru.kahn.kotlingitrepositiories.adapter.AdapterMain
import ru.kahn.kotlingitrepositiories.interfaces.MainContract

class MainPresenter(val view: Activity, val adapter: AdapterMain) : MainContract.Presenter {
    val responce = MainResponce()
    val pref = view.getPreferences(MODE_PRIVATE)

    override fun loadRepo() {
        view.sr_activity_main.isRefreshing = true
        responce.loadGitRepo(getSince(), view, adapter)
    }

    override fun setSince(since: String) {
        val editor: SharedPreferences.Editor = pref.edit();
        editor.putString("since", since)
        editor.apply()
        loadRepo()
    }

    override fun getSince(): String? {
        return pref.getString("since", "")
    }

    override fun onDestroy() {
        
    }

}
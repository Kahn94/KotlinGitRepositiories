package ru.kahn.kotlingitrepositiories.interfaces

import android.app.Activity
import ru.kahn.kotlingitrepositiories.adapter.AdapterMain

interface MainContract {

    interface Presenter {
        fun loadRepo()
        fun setSince(since: String)
        fun getSince(): String?
        fun onDestroy()
    }
    interface Responce {
        fun loadGitRepo(since: String?, view: Activity, adapter: AdapterMain)
    }
    interface ClickListenerItem {
        fun onClick(url: String)
    }
}
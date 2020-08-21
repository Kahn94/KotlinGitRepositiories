package ru.kahn.kotlingitrepositiories.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import ru.kahn.kotlingitrepositiories.interfaces.MainContract
import ru.kahn.kotlingitrepositiories.presenter.MainPresenter
import ru.kahn.kotlingitrepositiories.R
import ru.kahn.kotlingitrepositiories.adapter.AdapterMain

class MainActivity : AppCompatActivity(),
    MainContract.ClickListenerItem {

    var adapter: AdapterMain =
        AdapterMain(mutableListOf(), this)
    var mainPresenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainPresenter =
            MainPresenter(this, adapter)

        val layoutManager = LinearLayoutManager(this)

        toolbar_main.setTitle(resources.getString(R.string.top));
        setSupportActionBar(toolbar_main);

        rv_activity_main.setLayoutManager(layoutManager)
        rv_activity_main.setAdapter(adapter)

        mainPresenter!!.loadRepo()

        sr_activity_main.setOnRefreshListener {
            mainPresenter!!.loadRepo()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_main, menu)
        menu.getItem(3).setVisible(false)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_menu_daily -> mainPresenter!!.setSince(resources.getString(R.string.daily))
            R.id.action_menu_weekly -> mainPresenter!!.setSince(resources.getString(R.string.weekly))
            R.id.action_menu_monthly -> mainPresenter!!.setSince(resources.getString(R.string.monthly))
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(url: String) {
        val intent = Intent(this, WebActivity:: class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter?.onDestroy()
    }
}
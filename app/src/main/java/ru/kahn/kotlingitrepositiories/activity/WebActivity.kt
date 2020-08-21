package ru.kahn.kotlingitrepositiories.activity

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.toolbar.*
import ru.kahn.kotlingitrepositiories.R

class WebActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        toolbar_main.setTitle(resources.getString(R.string.project));
        setSupportActionBar(toolbar_main);

        webView.settings.javaScriptEnabled
        webView.loadUrl(intent.getStringExtra("url"))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_main, menu)
        menu.getItem(0).setVisible(false)
        menu.getItem(1).setVisible(false)
        menu.getItem(2).setVisible(false)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_menu_back -> {
                setResult(Activity.RESULT_OK)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
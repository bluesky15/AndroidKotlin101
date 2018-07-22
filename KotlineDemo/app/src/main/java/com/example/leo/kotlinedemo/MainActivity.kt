package com.example.leo.kotlinedemo

import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var tmsg: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
         tmsg = textMsg

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        var task = Mytask()
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,8000)
        var task2 = Mytask()
        task2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,3000)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    inner class Mytask : AsyncTask<Long,Void,String>(){
        override fun doInBackground(vararg params: Long?): String {
            params[0]?.let { Thread.sleep(it) }
            return params[0].toString()
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            tmsg.text = result
        }


    }
}

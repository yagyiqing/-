package com.example.broadcastbestpractice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.AlertDialog
import android.app.AlertDialog


open class BaseActivity:ComponentActivity() {
    lateinit var receiver:ForceOffLineReciver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.example.broadcastbestpractice.FORCE_OFFLINE")
        receiver = ForceOffLineReciver()
        registerReceiver(receiver,intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    inner class ForceOffLineReciver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            AlertDialog.Builder(context).apply {
                setTitle("Warning")
                setMessage("Mr.WU,Danger!Danger!")
                setCancelable(false)
                setPositiveButton("OK") { _, _ ->
                    ActivityCollector.finishAll()
                    val i = Intent(context, loginActivity::class.java)
                    context.startActivity(i)
                }
                show()
            }
        }
    }
}

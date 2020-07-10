package com.rahul.weather.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.rahul.weather.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    lateinit var handler: Handler

    var intentRunnable: Runnable = Runnable {
        launchMainActivity()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handler = Handler(Looper.getMainLooper())
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(intentRunnable, DELAY)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(intentRunnable)
    }

    private fun launchMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

    companion object {
        const val DELAY = 1000L
    }
}
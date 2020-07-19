package br.com.vittoria.arandu_android

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MotionEvent
import android.view.Window
import android.view.WindowManager
import android.widget.VideoView


class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_splash)

        try {
            val videoHolder = VideoView(this)

            setContentView(videoHolder)
            val video = Uri.parse("android.resource://" + packageName + "/" + R.raw.vinheta)
            videoHolder.setVideoURI(video)

            videoHolder.setOnCompletionListener { jump() }
            videoHolder.start()
        } catch (ex: Exception) {
            jump()
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        jump()
        return true
    }

    private fun jump(){
        if (isFinishing)
            return
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
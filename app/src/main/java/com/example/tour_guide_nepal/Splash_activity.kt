package com.example.tour_guide_nepal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import android.media.MediaPlayer





class Splash_activity : AppCompatActivity() {

    val SPLASH_SCREEN = 5000
    lateinit var music: MediaPlayer

    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    private lateinit var centerlogo: ImageView
    private lateinit var word1: TextView

    private lateinit var travelvehicle: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        travelvehicle = findViewById(R.id.travelvehicle)

//hide status bar

        val actionBar = supportActionBar
        actionBar!!.hide()

        //creating two animations
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bot_animation)

        centerlogo = findViewById(R.id.centerlogo)
        word1 = findViewById(R.id.word1)

        music=MediaPlayer.create(this,R.raw.splash);
        music.start()

        word1.animation = topAnimation
        centerlogo.animation = topAnimation
        travelvehicle.animation = bottomAnimation

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_SCREEN.toLong())

    }
}
package com.example.diceroller

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)
        val diceImage1: ImageView = findViewById(R.id.diceImage1)
        val diceImage2: ImageView = findViewById(R.id.diceImage2)
        val totalText: TextView = findViewById(R.id.totalText)

        val diceAnimation = AnimationUtils.loadAnimation(this, R.anim.dice_roll)

        rollButton.setOnClickListener {
            diceImage1.startAnimation(diceAnimation)
            diceImage2.startAnimation(diceAnimation)

            val random1 = Random.nextInt(1, 7)
            val random2 = Random.nextInt(1, 7)

            val res1 = resources.getIdentifier("dice_$random1", "drawable", packageName)
            val res2 = resources.getIdentifier("dice_$random2", "drawable", packageName)

            diceImage1.setImageResource(res1)
            diceImage2.setImageResource(res2)

            totalText.text = "Total: ${random1 + random2}"
        }
    }
}

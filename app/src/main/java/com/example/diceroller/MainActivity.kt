package com.example.diceroller

import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.view.isInvisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val attackButton : Button = findViewById(R.id.button)
        attackButton.setOnClickListener {
            rollDice()

        }

    }

    class RollToAttack (private val diceSides : Int) {
        fun roll() :Int {
          return (1..diceSides)  .random()
        }
    }

    private fun rollDice() {
      val  rollIt = RollToAttack(20)
        val rollResult = rollIt.roll()
        val resText : TextView = findViewById(R.id.textView2)
        resText.text = rollResult.toString()
        val imageTest : ImageView = findViewById(R.id.imageView)
        val videoTest : VideoView = findViewById(R.id.videoView)
        if (rollResult >= 10) {
            imageTest.setImageResource(R.drawable.rdr2)
            imageTest.isVisible = true
            videoTest.isVisible = false
        } else {
            imageTest.isInvisible = true
            videoTest.isInvisible = false
            videoTest.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.test))
            videoTest.start()
        }
    }

}


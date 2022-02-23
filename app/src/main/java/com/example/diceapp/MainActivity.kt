package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dice: Dice = Dice(6)
        val tvDiceValue: TextView = findViewById<TextView>(R.id.tvDiceValue)
//declare the btRoll button
        val btRoll: Button = findViewById<Button>(R.id.btRoll)
//declare the imageView variable
        val diceImage : ImageView = findViewById<ImageView>(R.id.ivDice)
        btRoll.setOnClickListener {
            rollDice(dice, tvDiceValue, diceImage)
        }
        rollDice(dice, tvDiceValue, diceImage)
    }
    //organize the code more modular, create a function rollDice
    private fun rollDice(dice: Dice, tvDiceValue : TextView, diceImage: ImageView){
        var value = dice.roll() //roll the dice
        tvDiceValue.text = value.toString() //show the value in the TextView
        Log.d("MainActivity", "Dice value is ${value}") //show the value in Logcat
//toast
        Toast.makeText(this,"Dice value is ${value}", Toast.LENGTH_SHORT).show()
//show the right image according to the resulted value
        when (value) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            else -> diceImage.setImageResource(R.drawable.dice_6)
        }
    }
}
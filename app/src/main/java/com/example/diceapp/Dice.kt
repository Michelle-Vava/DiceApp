package com.example.diceapp

class Dice (val numSize: Int){
    //function roll
    fun roll():Int{
        return (1..numSize).random()
    }
}
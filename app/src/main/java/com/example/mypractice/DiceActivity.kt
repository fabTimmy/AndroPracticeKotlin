package com.example.mypractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_dice.*
import java.util.Random

class DiceActivity : AppCompatActivity() {
var builder = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)
        val noR = intent.getIntExtra("num_of_rolls",0)

        Log.i("RollActivity","number of rolls is $noR")
        Toast.makeText(this,noR.toString(), Toast.LENGTH_SHORT).show()
        display_txt.text = keepRolling(noR)
        reset_button.setOnClickListener {
            goBack()
        }
    }
    private fun keepRolling(numOfRolls:Int):String{
//        if (numOfRolls < 1){
//            Toast.makeText(this,"Sorry, can't perform this task", Toast.LENGTH_SHORT).show()
//        }
//        else {
            for (i in 1 .. numOfRolls) {
                builder.append(rolldice().toString())
                builder.append(" ")
            }
Log.i("RollActivity",builder.toString())
//        }

        return builder.toString()
    }
    private fun rolldice() : Int{
        val rand = Random()
        return rand.nextInt(9)
    }
    private fun goBack(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }
}

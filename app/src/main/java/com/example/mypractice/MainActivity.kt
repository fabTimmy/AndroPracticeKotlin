package com.example.mypractice

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val ROLL_NUM = "num of dice rolls"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        roll_num.isEnabled = false
        val n = roll_num.text.toString()
        val num:Int = n.toInt()

        Log.i("RollActivity","string of rolls entered is $n")
        Log.i("RollActivity","number of rolls entered is $num")
        roll_button.setOnClickListener(View.OnClickListener {
            Toast.makeText(this,"Moving to roll page",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,DiceActivity::class.java)
            intent.putExtra("num_of_rolls",num)
            startActivity(intent)
        })
        dial_btn.setOnClickListener(View.OnClickListener {
            val uri = Uri.parse("tel:08068235623")
            val intent = Intent(Intent.ACTION_DIAL,uri)
            if(intent.resolveActivity(packageManager!!) != null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Cannot find app to perform this action",Toast.LENGTH_LONG).show()
            }
        })
        map_btn.setOnClickListener(View.OnClickListener {
            val mapUri = Uri.parse("geo:22,44.8")
            val mapUri2 = Uri.parse("geo:0,0?Lagos,Nigeria&z=10")
            val intent = Intent(Intent.ACTION_VIEW,mapUri2)
            if (intent.resolveActivity(packageManager!!) != null){
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Cannot find a map app to perform this action",Toast.LENGTH_LONG).show()
            }
        })
        web_btn.setOnClickListener(View.OnClickListener {
            val googleWeb = "https://google.com"
            loadWebpage(googleWeb)
        })
        text_btn.setOnClickListener(View.OnClickListener {
            sendText("Hello there!! We are live!!")
        })

    }
    fun sendText(message:String){
        val str = StringBuilder("text:")
        str.append(message)
        val uri = Uri.parse(str.toString())
        Log.i("the text is ::: ", str.toString())
        val intent = Intent(Intent.ACTION_SEND,uri)
        intent.putExtra(Intent.EXTRA_TEXT,message)
        intent.type = "text/*"
        if (intent.resolveActivity(packageManager!!) != null){
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"Cannot find an app to perform this action",Toast.LENGTH_LONG).show()
        }
    }
    fun loadWebpage(url:String){
        val webURL = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW,webURL)
        if(intent.resolveActivity(packageManager!!) != null){
            startActivity(intent)
        }
        else{
            Toast.makeText(this,"Cannot find an app to perform this action",Toast.LENGTH_LONG).show()
        }
    }
}

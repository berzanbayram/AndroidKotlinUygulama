package com.example.berzanbayram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sayac = findViewById<TextView>(R.id.sayac)
        var name=findViewById<TextView>(R.id.name)
        val intent = Intent(applicationContext, MainActivity2::class.java)
        var choose = false
        var say = object : CountDownTimer(6000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                sayac.text = (millisUntilFinished/1000).toString()
                if(choose==false){
                    name.visibility= View.INVISIBLE
                    choose=true
                }
                else if(choose==true){
                    name.visibility= View.VISIBLE
                    choose=false
                }
            }

            override fun onFinish() {
                startActivity(intent)
                finish()
            }
        }
        say.start()

    }
}





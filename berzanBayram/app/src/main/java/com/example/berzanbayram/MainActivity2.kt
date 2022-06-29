package com.example.berzanbayram

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

val dosyaYolu = "com.berzanBayram.shared"
var anahtarIsim = "isim"
var anahtarNo = "no"
var anahtarTutucu = false

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var name = findViewById<EditText>(R.id.name)
        var schollNo = findViewById<EditText>(R.id.schollNo)
        var girisYap = findViewById<Button>(R.id.button)
        var beni_Unutma = findViewById<Switch>(R.id.switch1)

        var preferences = getSharedPreferences(dosyaYolu, Context.MODE_PRIVATE)
        var editor = preferences.edit()

        if (preferences.getBoolean(anahtarTutucu.toString(), false) == true) {
            beni_Unutma.isChecked = true
            name.setText(preferences.getString(anahtarIsim, ""))
            schollNo.setText(preferences.getString(anahtarNo, ""))
        }

        girisYap.setOnClickListener {


            val dialog = layoutInflater.inflate(R.layout.dialog, null)
            val alert = AlertDialog.Builder(this)
            alert.setView(dialog)
            var sayac = dialog.findViewById<TextView>(R.id.sayac2)
            if (name.text.toString().equals("Berzan BAYRAM") && schollNo.text.toString()
                    .equals("02195076083")
            ) {

                if (beni_Unutma.isChecked) {
                    editor.putString(anahtarIsim, name.text.toString())
                    editor.putString(anahtarNo, schollNo.text.toString())
                    editor.putBoolean(anahtarTutucu.toString(), true)
                    editor.apply()
                } else {
                    editor.remove(anahtarIsim)
                    editor.remove(anahtarNo)
                    editor.remove(anahtarTutucu.toString())
                    editor.apply()
                }

                val intent = Intent(this, login::class.java)
                alert.create().show()

                var say = object : CountDownTimer(4000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        sayac.text = (millisUntilFinished / 1000).toString()
                    }

                    override fun onFinish() {
                        startActivity(intent)
                        finish()
                    }
                }
                say.start()

            }
            if (name.text.toString().equals("") || schollNo.text.toString().equals("")) {
                val alert = AlertDialog.Builder(this)
                alert.setTitle("Hata")
                alert.setMessage("Alanlar Boş Bırakılamaz")
                alert.show()
            } else if (!name.text.toString().equals("Berzan BAYRAM") || !schollNo.text.toString()
                    .equals("02195076083")
            ) {
                val alert2 = AlertDialog.Builder(this)
                alert2.setTitle("Hata")
                alert2.setMessage("İsim veya Numara Bilgisi Yanlış")
                    .setCancelable(false)
                    .setPositiveButton(
                        "Çık",
                        DialogInterface.OnClickListener { dialog, id ->
                            finish()
                        })
                    .setNeutralButton(
                        "Yeniden Dene",
                        DialogInterface.OnClickListener { dialog, id ->
                            name.setText("")
                            schollNo.setText("")
                        })

                alert2.show()
            }
        }
    }
}
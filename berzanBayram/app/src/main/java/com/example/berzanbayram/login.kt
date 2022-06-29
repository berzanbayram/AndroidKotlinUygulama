package com.example.berzanbayram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.Fragment

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val menuBtn=findViewById<Button>(R.id.menuBtn)

        menuBtn.setOnClickListener {
            val p_menu = PopupMenu(this, menuBtn)
            p_menu.menuInflater.inflate(R.menu.p_menu, p_menu.menu)

            p_menu.setOnMenuItemClickListener { i ->
                when (i.itemId) {
                    R.id.a1 -> {
                        fragment_goster(f_mainActivity())
                        true
                    }
                    R.id.a2 -> {
                        fragment_goster(f_colors())
                        true
                    }
                    R.id.a3 -> {
                        fragment_goster(f_action())
                        true
                    }
                    R.id.a4 -> {
                        fragment_goster(f_visibility())
                        true
                    }
                    R.id.a5 -> {
                        fragment_goster(f_toast())
                        true
                    }
                    else -> false
                }
            }
            p_menu.show()
        }
    }

    fun fragment_goster(fr: Fragment) {
        var fragment_goster = supportFragmentManager.beginTransaction()
        fragment_goster.replace(R.id.fragmentContainerView, fr)
        fragment_goster.commit()

    }
}
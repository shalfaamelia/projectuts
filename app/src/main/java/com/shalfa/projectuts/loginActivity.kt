package com.shalfa.projectuts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ujianakhirsemester.presensimahasiswa2c.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username :EditText = findViewById(R.id.inputUsername)
        val userpassword :EditText = findViewById(R.id.inputPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener {
            val username = username.text.toString()
            val password = userpassword.text.toString()

            if (username == "iman" && password == "admin") {
                Toast.makeText(this,"Berhasil melakukan login", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, PresensiActivity::class.java)
                startActivity(intent)
            } else{
                Toast.makeText(this,"Login Gagal", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
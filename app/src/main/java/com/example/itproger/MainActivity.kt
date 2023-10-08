package com.example.itproger

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.io.path.fileVisitor
import com.example.itproger.R.id.link_auth as link_auth1

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin:EditText = findViewById(R.id.user_login)
        val userEmail:EditText = findViewById(R.id.user_email)
        val userPass:EditText = findViewById(R.id.user_pass)
        val button:Button = findViewById(R.id.button_red)
        val linkAuth :TextView = findViewById(R.id.link)

        linkAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
             val login = userLogin.text.toString().trim()
             val email = userEmail.text.toString().trim()
             val pass = userPass.text.toString().trim()


            if (login== "" || email == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
            else {
                val user = User(login, email, pass)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, AuthActivity::class.java)
                startActivity(intent)

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
            }
         }


    }
}
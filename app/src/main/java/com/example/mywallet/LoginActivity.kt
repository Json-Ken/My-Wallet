package com.example.mywallet

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var EdtEmail: EditText
    private lateinit var Edtpass: EditText
    private lateinit var Tvdirect: TextView
    private lateinit var Btnlogin: Button
    private lateinit var auth: FirebaseAuth
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        EdtEmail = findViewById(R.id.editTextEmail)
        Edtpass = findViewById(R.id.editTextPassword)
        Btnlogin = findViewById(R.id.buttonLogin)
        Tvdirect=findViewById(R.id.txt_Tvdirects)
        auth= Firebase.auth
        auth = FirebaseAuth.getInstance()
        Btnlogin.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        Tvdirect.setOnClickListener {
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        Btnlogin.setOnClickListener {
            val email = EdtEmail.text.toString()
            val password = Edtpass.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                loginUser(email, password)
            } else {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Login success
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    // Proceed with next steps or navigate to another activity
                } else {
                    // Login failed
                    Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
                }
            }
    }
}

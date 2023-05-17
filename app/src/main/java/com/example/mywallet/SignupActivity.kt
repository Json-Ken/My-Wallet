package com.example.mywallet

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

class SignupActivity : AppCompatActivity() {
    private lateinit var EdtEmail: EditText
    private lateinit var EdtPass: EditText
    private lateinit var EdtConfirmpass: EditText
    private lateinit var Btnsignup: Button
    private lateinit var TvDirectLOgin: TextView
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        EdtEmail=findViewById(R.id.edt_Email)
        EdtPass=findViewById(R.id.Edt_pass)
        EdtConfirmpass=findViewById(R.id.Edt_repass)
        Btnsignup=findViewById(R.id.btn_sign)
        TvDirectLOgin=findViewById(R.id.txt_TvDirect)
        auth= Firebase.auth


        TvDirectLOgin.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        Btnsignup.setOnClickListener {
            SignUpUser()
            val int= Intent(this,MainActivity::class.java)
            startActivity(int)
        }
    }
    private fun SignUpUser(){
        val email = EdtEmail.text.toString()
        val pass=EdtPass.text.toString()
        val confirmpass=EdtConfirmpass.text.toString()
        if (email.isBlank()||pass.isBlank()||confirmpass.isBlank()){
            Toast.makeText(this,"Please email and password can not be blank", Toast.LENGTH_LONG).show()
            return
        }else if (pass!=confirmpass){
            Toast.makeText(this,"Password do not match", Toast.LENGTH_LONG).show()
        }
        auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this){
            if (it.isSuccessful){
                Toast.makeText(this,"Signed Successfully", Toast.LENGTH_LONG).show()
            }else Toast.makeText(this,"Failed to create", Toast.LENGTH_LONG).show()
        }
    }
}
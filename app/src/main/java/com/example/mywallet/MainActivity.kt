package com.example.mywallet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView


class MainActivity() : AppCompatActivity() {
    private lateinit var Send: ImageView
    private lateinit var Receive: ImageView
    private lateinit var Buy: ImageView
    private lateinit var Home: ImageView
    private lateinit var Profile: ImageView
    private lateinit var Wallet: ImageView
    private lateinit var Settings: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Send.findViewById<ImageView>(R.id.img_send)
        Receive.findViewById<ImageView>(R.id.img_receive)
        Buy.findViewById<ImageView>(R.id.img_buy)
        Home.findViewById<ImageView>(R.id.img_btn1)
        Profile.findViewById<ImageView>(R.id.img_btn2)
        Wallet.findViewById<ImageView>(R.id.img_btn3)
        Settings.findViewById<ImageView>(R.id.img_btn4)

        Profile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
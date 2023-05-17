package com.example.mywallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mywallet.Adapter.ActivityAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ActivityAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerViewActivities)
        adapter = ActivityAdapter(getActivityData()) // Replace with your own data source
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    // Replace this function with your own logic to fetch activity data
    private fun getActivityData(): List<Activity> {
        // Example data
        return listOf(
            Activity("Payment", "Make a payment", R.drawable.ic_payment),
            Activity("Transfer", "Transfer funds", R.drawable.ic_transfer),
            Activity("Deposit", "Deposit money", R.drawable.ic_deposit),
            // Add more activities as needed
        )
    }
}

data class Activity(val title: String, val description: String, val iconRes: Int)

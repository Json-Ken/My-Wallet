package com.example.mywallet.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.R
import androidx.recyclerview.widget.RecyclerView

class ActivityAdapter (private val activityList: List<Wallets>) : RecyclerView.Adapter<ActivityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(com.example.mywallet.R.layout.activity_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = activityList[position]
        holder.bind(activity)
    }

    override fun getItemCount(): Int {
        return activityList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val iconImageView: ImageView = itemView.findViewById(R.id.iconImageView)
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)

        fun bind(activity: Wallets) {
            iconImageView.setImageResource(activity.iconRes)
            titleTextView.text = activity.title
            descriptionTextView.text = activity.description

            itemView.setOnClickListener {
                // Handle item click event here
                // For example, navigate to a specific activity based on the clicked item
                // You can use Intent to start a new activity or perform any desired action
            }
        }
    }
}
{
}
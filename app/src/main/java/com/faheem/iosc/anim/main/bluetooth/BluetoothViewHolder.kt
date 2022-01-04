package com.faheem.iosc.anim.main.bluetooth

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.faheem.iosc.anim.R

class BluetoothViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txtName: TextView = itemView.findViewById(R.id.name)
    val status: TextView = itemView.findViewById(R.id.status)
}
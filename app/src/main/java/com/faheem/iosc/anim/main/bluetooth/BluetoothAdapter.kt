package com.faheem.iosc.anim.main.bluetooth

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faheem.iosc.anim.R
import java.util.*

class BluetoothAdapter(
    private var context: Context,
    private val items: ArrayList<Bluetooth>,
) :
    RecyclerView.Adapter<BluetoothViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BluetoothViewHolder {
        return BluetoothViewHolder(
            LayoutInflater.from(context).inflate(R.layout.blutooth_item, null, false)
        )
    }

    override fun onBindViewHolder(holder: BluetoothViewHolder, position: Int) {
        val item = items[position]
        holder.txtName.text = item.name
        holder.status.text = item.status
    }


    override fun getItemCount(): Int {
        return items.size
    }

}
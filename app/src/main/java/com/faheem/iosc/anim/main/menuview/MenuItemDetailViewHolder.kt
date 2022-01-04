package com.faheem.iosc.anim.main.menuview

import android.view.View
import android.widget.TextView
import com.faheem.iosc.anim.R

class MenuItemDetailViewHolder(itemView: View) : MenuItemViewHolder(itemView) {
    var name: TextView = itemView.findViewById(R.id.name)
    var status: TextView = itemView.findViewById(R.id.status)
}

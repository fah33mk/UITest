package com.faheem.iosc.anim.main.menuview

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.faheem.iosc.anim.R

open class MenuItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var control: ImageView = itemView.findViewById(R.id.control)
}

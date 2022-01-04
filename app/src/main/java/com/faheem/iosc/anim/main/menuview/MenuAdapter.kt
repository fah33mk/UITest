package com.faheem.iosc.anim.main.menuview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.faheem.iosc.anim.R
import java.util.*

class MenuAdapter(
    private var context: Context,
    private val items: ArrayList<MenuItem>,
    var menuType: MenuType
) :
    RecyclerView.Adapter<MenuItemViewHolder>() {

    lateinit var onItemLongClickListener: OnItemLongClickListener
    lateinit var onItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuItemViewHolder {
        return if (viewType == 0) {
            MenuItemViewHolder(
                LayoutInflater.from(context).inflate(R.layout.menu_item_view, null, false)
            )
        } else {
            MenuItemDetailViewHolder(
                LayoutInflater.from(context).inflate(R.layout.menu_item_view_detailed, null, false)
            )
        }
    }

    override fun onBindViewHolder(holder: MenuItemViewHolder, position: Int) {
        val item = items[position]
        if (holder is MenuItemDetailViewHolder) {
            holder.name.text = item.name
            holder.status.text = item.status
            holder.control.tag=item
        }
        holder.control.setBackgroundResource(item.backgroundResource)
        holder.control.setImageResource(item.icon)
        holder.control.tag = item
        holder.control.setOnClickListener {
            items.indexOf((it.tag as MenuItem)).apply {
                if (this > -1) {
                    items[this].isChecked = items[this].isChecked.not()
                }
            }
        }
        holder.control.setOnLongClickListener { v ->
            if (v?.tag != null && v.tag is MenuItem) {
                onItemLongClickListener?.onItemLongClick(v.tag as MenuItem)
            }
            true
        }
        holder.control.setOnClickListener {
            if (it.tag != null && it.tag is MenuItem)
                this.onItemClickListener?.onItemClick(it.tag as MenuItem)
        }
    }

    override fun getItemCount(): Int {
        return if (menuType == MenuType.Menu4 && items.size > 4) {
            4
        } else {
            items.size
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (menuType == MenuType.Menu4) {
            0
        } else {
            1
        }
    }

}
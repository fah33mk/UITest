package com.faheem.iosc.anim.main.menuview

import android.content.Context
import android.util.AttributeSet
import android.widget.GridLayout
import androidx.recyclerview.widget.RecyclerView
import com.faheem.iosc.anim.R
import java.util.*

class MenuView : GridLayout {
    val allMenuItems = ArrayList<MenuItem>()
    var menuType = MenuType.Menu4
    private var menuAdapter: MenuAdapter? = null
    private var menu: RecyclerView? = null

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    fun addItem(item: MenuItem) {
        allMenuItems.add(item)
        menuAdapter!!.notifyDataSetChanged()
    }

    fun addItems(items: ArrayList<MenuItem>?) {
        allMenuItems.addAll(items!!)
        menuAdapter!!.notifyDataSetChanged()
    }

    @JvmName("getMenuType1")
    fun getMenuType(): MenuType {
        return menuType
    }

    @JvmName("setMenuType1")
    fun setMenuType(menuType: MenuType) {
        this.menuType = menuType
        menuAdapter!!.menuType = menuType
        menuAdapter!!.notifyDataSetChanged()
    }

    private fun init() {
        inflate(context, R.layout.menu_view, this)
        menu = findViewById(R.id.menu)
        menuAdapter = MenuAdapter(context, allMenuItems, menuType)
        menu?.adapter = menuAdapter
    }

    fun setOnItemLongClick(click: OnItemLongClickListener?) {
        menuAdapter!!.onItemLongClickListener = click!!
    }

    fun setOnItemClickListener(onClickListener: OnItemClickListener?) {
        menuAdapter!!.onItemClickListener = onClickListener!!
    }
}
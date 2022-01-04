package com.faheem.iosc.anim.main.bluetooth

import android.content.Context
import android.util.AttributeSet
import android.widget.GridLayout
import androidx.recyclerview.widget.RecyclerView
import com.faheem.iosc.anim.R
import com.faheem.iosc.anim.main.menuview.MenuType
import java.util.*

class BluetoothListView : GridLayout {
    private val allMenuItems = ArrayList<Bluetooth>()
    private var menuType = MenuType.Menu4
    private var adapter: BluetoothAdapter? = null
    private var recyclerView: RecyclerView? = null

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

    fun addItem(item: Bluetooth) {
        allMenuItems.add(item)
        adapter!!.notifyDataSetChanged()
    }

    fun addItems(items: ArrayList<Bluetooth>?) {
        allMenuItems.addAll(items!!)
        adapter!!.notifyDataSetChanged()
    }

    fun getMenuType(): MenuType {
        return menuType
    }

    fun setMenuType(menuType: MenuType) {
        this.menuType = menuType
        adapter!!.notifyDataSetChanged()
    }

    private fun init() {
        inflate(context, R.layout.bluetooth_list_view, this)
        recyclerView = findViewById(R.id.recyclerView)
        adapter = BluetoothAdapter(context, allMenuItems)
        recyclerView?.adapter = adapter
    }
}
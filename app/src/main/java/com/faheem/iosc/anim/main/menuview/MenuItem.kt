package com.faheem.iosc.anim.main.menuview

import com.faheem.iosc.anim.R

class MenuItem(selectedBackgroundDrawable: Int, defaultBackgroundDrawable: Int) {
    var name: String = ""
    var status: String = ""
    var icon = R.drawable.ic_default
    var isChecked = false
    var selectedBackgroundDrawable = 0
    var defaultBackgroundDrawable = 0
    val backgroundResource: Int
        get() = if (isChecked) {
            selectedBackgroundDrawable
        } else {
            defaultBackgroundDrawable
        }

    companion object {
        fun newItem(): MenuItem {
            return MenuItem(R.drawable.menu_item_selected, R.drawable.menu_item_default)
        }

        fun newItem(selectedBackgroundDrawable: Int): MenuItem {
            return MenuItem(selectedBackgroundDrawable, R.drawable.menu_item_default)
        }
    }

    init {
        this.selectedBackgroundDrawable = selectedBackgroundDrawable
        this.defaultBackgroundDrawable = defaultBackgroundDrawable
    }
}
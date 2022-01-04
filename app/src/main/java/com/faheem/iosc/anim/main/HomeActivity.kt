package com.faheem.iosc.anim.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.faheem.iosc.anim.R
import com.faheem.iosc.anim.main.alert.Alert
import com.faheem.iosc.anim.main.bluetooth.Bluetooth
import com.faheem.iosc.anim.main.bluetooth.BluetoothListView
import com.faheem.iosc.anim.main.heptic.Heptic
import com.faheem.iosc.anim.main.menuview.*
import com.skydoves.elasticviews.ElasticAnimation
import com.skydoves.elasticviews.ElasticFinishListener
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        menuView.setMenuType(MenuType.Menu4)
        menuView.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(item: MenuItem) {
                Heptic.vibrate(this@HomeActivity,300)
                ElasticAnimation(menuView).setScaleX(0.95f).setScaleY(0.95f).setDuration(300)
                    .setOnFinishListener(ElasticFinishListener {
                        onAnimationFinished()
                    }).doAction();
            }
        })
        menuView.addItems(getMenuItems(menuView.menuType))

    }

    private fun onAnimationFinished() {
        val mv = MenuView(this)
        val alert = Alert.make(this)
        mv.setMenuType(MenuType.MenuX)
        mv.addItems(getMenuItems(mv.menuType))
        mv.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(item: MenuItem) {
                Heptic.vibrate(this@HomeActivity,300)
                alert.dismiss()
                var bv = BluetoothListView(this@HomeActivity)
                bv.addItem(Bluetooth("Air Pods Pro (Anekcahap)", "Connected"))
                bv.addItem(Bluetooth("Mi Band 2", "Connected"))
                bv.addItem(Bluetooth("", ""))
                bv.addItem(Bluetooth("", ""))
                bv.addItem(Bluetooth("", ""))
                Alert.make(this@HomeActivity).addView(bv).show()
            }
        })
        mv.setOnItemLongClick(object : OnItemLongClickListener {
            override fun onItemLongClick(item: MenuItem) {
                Heptic.vibrate(this@HomeActivity,300)
                Toast.makeText(this@HomeActivity, "Long Click", Toast.LENGTH_LONG).show()
                alert.dismiss()
            }
        })
        alert.addView(mv).show()
    }

    private fun getMenuItems(menuType: MenuType): ArrayList<MenuItem> {
        val items = ArrayList<MenuItem>()
        val airplane = MenuItem.newItem()
        airplane.icon = R.drawable.ic_airplane
        airplane.isChecked = false
        airplane.name = "Airplane"
        airplane.status = "Off"
        items.add(airplane)
        val cdata = MenuItem.newItem(R.drawable.menu_item_data_selected)
        cdata.icon = R.drawable.ic_cellular_data
        cdata.isChecked = true
        cdata.name = "Mobile Data"
        cdata.status = "On"
        items.add(cdata)
        val wifi = MenuItem.newItem()
        wifi.icon = R.drawable.ic_wifi
        wifi.isChecked = true
        wifi.name = "Wifi"
        wifi.status = "Huawei-9zBx-5G"
        items.add(wifi)
        val bluetooth = MenuItem.newItem()
        bluetooth.icon = R.drawable.ic_bluetooth
        bluetooth.isChecked = true
        bluetooth.name = "Bluetooth"
        bluetooth.status = "2 Devices"
        items.add(bluetooth)
        if (menuType == MenuType.MenuX) {
            val airdrop = MenuItem.newItem()
            airdrop.icon = R.drawable.ic_airdrop
            airdrop.isChecked = false
            airdrop.name = "Air Drop"
            airdrop.status = "Receiving Off"
            items.add(airdrop)

            val hotspot = MenuItem.newItem()
            hotspot.icon = R.drawable.ic_hotspot
            hotspot.isChecked = false
            hotspot.name = "Personal Hotspot"
            hotspot.status = "Not Discoverable"
            items.add(hotspot)
        }
        return items
    }
}
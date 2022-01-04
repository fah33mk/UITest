package com.faheem.iosc.anim.main.alert

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import com.faheem.iosc.anim.R
import java.util.*


class Alert(val activity: Activity?) {
    private var dialogView: View? = null
    var alertBuilder: AlertDialog.Builder? = null
        private set
    var dialog: AlertDialog? = null
    private var cancelable = true
    private var parentContainer: LinearLayout? = null
    private fun init(): Alert {
        val inflater =
            activity!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        dialogView = inflater.inflate(R.layout.alert_view, null)
        parentContainer = dialogView?.findViewById(R.id.parentContainer)
        return this
    }

    fun addView(view: View): Alert {
        parentContainer?.addView(view)
        return this
    }


    fun show(): AlertDialog? {
        return if (activity != null && !activity.isFinishing) {
            alertBuilder = AlertDialog.Builder(activity)
            alertBuilder!!.setView(dialogView)
            alertBuilder!!.setCancelable(cancelable)
            dialog = alertBuilder!!.create()
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.attributes.windowAnimations = R.style.CustomAnimations
            dialog!!.setOnDismissListener { dialog: DialogInterface ->
                if (listOfDialogs.containsKey(
                        dialog.hashCode()
                    )
                ) listOfDialogs.remove(dialog.hashCode())
            }
            dialog!!.show()
            val lp = WindowManager.LayoutParams()
            lp.copyFrom(dialog?.getWindow()?.getAttributes())
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.x = -170
            lp.y = 100
            lp.horizontalMargin = 50f
            dialog?.getWindow()?.setAttributes(lp)
            listOfDialogs[dialog.hashCode()] = dialog
            dialog
        } else {
            Log.d("Alert", "Null referenced passed for instance activity")
            null
        }
    }

    fun dismiss() {
        dialog?.dismiss()
    }


    companion object {
        private val listOfDialogs = HashMap<Int, AlertDialog?>()
        fun dialogsVisible(): Boolean {
            return listOfDialogs.size > 0
        }

        fun make(activity: Activity?): Alert {
            val alert = Alert(activity)
            return alert.init()
        }

        fun clearAllDialogs() {
            val it: MutableIterator<*> = listOfDialogs.entries.iterator()
            while (it.hasNext()) {
                val pair = it.next() as Map.Entry<*, *>
                (pair.value as AlertDialog).dismiss()
                it.remove()
            }
        }
    }
}
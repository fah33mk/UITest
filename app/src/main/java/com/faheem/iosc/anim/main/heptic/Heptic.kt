package com.faheem.iosc.anim.main.heptic

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator


class Heptic {
    companion object {
        @SuppressLint("ServiceCast")
        fun vibrate(context: Activity, timeInMillies: Long) {
            val heptic: Vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (Build.VERSION.SDK_INT >= 26) {
                heptic.vibrate(
                    VibrationEffect.createOneShot(
                        200,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                heptic.vibrate(timeInMillies)
            }
        }
    }
}
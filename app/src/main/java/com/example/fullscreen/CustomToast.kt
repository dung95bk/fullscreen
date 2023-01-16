package com.example.fullscreen

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast

class CustomToast(context: Context) : Toast(context) {
    companion object {
        fun makeText(context: Context, message: String, duration: Int, customLayout: Int): Toast {
            val toast = Toast(context)
            toast.duration = duration
            val layout = LayoutInflater.from(context).inflate(
                customLayout,
                null,
                false
            )
            toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL, 0,0)
            toast.view = layout
            return toast
        }
    }
}

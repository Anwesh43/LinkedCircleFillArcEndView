package com.example.circlefillarcendview

import android.view.View
import android.view.MotionEvent
import android.graphics.Paint
import android.graphics.Color
import android.graphics.Canvas
import android.graphics.RectF
import android.app.Activity
import android.content.Context

val colors : Array<Int> = arrayOf(
    "#F44336",
    "#3F51B5",
    "#4CAF50",
    "#795548",
    "#03A9F4"
).map {
    Color.parseColor(it)
}.toTypedArray()
val strokeFactor : Float = 90f
val arcFactor : Float = 2.9f
val rFactor : Float = 8.9f
val delay : Long = 20
val parts : Int = 4
val scGap : Float = 0.02f
val deg : Float = 360f
val backColor : Int = Color.parseColor("#BDBDBD")

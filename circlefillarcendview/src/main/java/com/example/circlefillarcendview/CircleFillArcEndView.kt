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
val parts : Int = 5
val scGap : Float = 0.02f
val deg : Float = 360f
val backColor : Int = Color.parseColor("#BDBDBD")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse())
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n

fun Canvas.drawCircleFillEnd(w : Float, h : Float, scale : Float, paint : Paint) {
    val sc1 : Float = scale.divideScale(0, parts)
    val sc2 : Float = scale.divideScale(1, parts)
    val sc3 : Float = scale.divideScale(2, parts)
    val sc4 : Float = scale.divideScale(3, parts)
    val sc5 : Float = scale.divideScale(4, parts)
    val size : Float = Math.min(w, h) / arcFactor
    val r : Float = Math.min(w, h) / rFactor
    save()
    translate(w / 2, h / 2)
    paint.style = Paint.Style.STROKE
    drawArc(RectF(-size, -size, size, size), deg * sc5, deg * (sc1 - sc5), false, paint)
    paint.style = Paint.Style.FILL
    save()
    rotate(deg * sc3)
    drawCircle((size - r), 0f, r * (sc2 - sc4), paint)
    restore()
    restore()
}

fun Canvas.drawCFAENode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    paint.color = colors[i]
    paint.strokeCap = Paint.Cap.ROUND
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    drawCircleFillEnd(w, h, scale, paint)
}

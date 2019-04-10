package com.example.customview_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * Created by TianZuLin on 2019/3/27.
 */
class LineView : View {
    val paint: Paint

    constructor(context: Context) : super(context) {
        paint = Paint()
        paint.isAntiAlias = true
        paint.strokeWidth = 20f
        paint.color = ContextCompat.getColor(context, R.color.material_deep_teal_200)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        paint = Paint()
        paint.isAntiAlias = true
        paint.strokeWidth = 20f
        paint.color = ContextCompat.getColor(context, R.color.material_deep_teal_200)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Log.i("TTZZLL" , "$left  $top   $right   $bottom   $measuredWidth")
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        canvas?.drawLine(0f, 0f, 300f, 0f, paint)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = MeasureSpec.getSize(widthMeasureSpec)

        val height = MeasureSpec.getSize(heightMeasureSpec)

        val widthModel = MeasureSpec.getMode(widthMeasureSpec)
        val heightMode = MeasureSpec.getMode(heightMeasureSpec)

        Log.i("TTZZLL", " width = $width  height = $height  widthModel = $widthModel heightMode = $heightMode")
        setMeasuredDimension(300, 20)
    }
}

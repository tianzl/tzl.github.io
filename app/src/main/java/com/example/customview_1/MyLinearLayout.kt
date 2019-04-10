package com.example.customview_1

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.LinearLayout

/**
 * Created by TianZuLin on 2019/4/8.
 */
class MyLinearLayout : LinearLayout {

    constructor(context: Context) : super(context) {
        CustomEditText(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        super.onLayout(changed, l, t, r, b)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val measureWidth = MeasureSpec.getSize(widthMeasureSpec)
        val measureHeight = MeasureSpec.getSize(heightMeasureSpec)
        val measureWidthMode = MeasureSpec.getMode(widthMeasureSpec)
        val measureHeightMode = MeasureSpec.getMode(heightMeasureSpec)
        var width = 0
        var height = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            measureChild(child ,widthMeasureSpec ,heightMeasureSpec )
            val childWidth = child.measuredWidth
            val childHeight = child.measuredHeight

            height += childHeight
            width = Math.max(width , childWidth)
            Log.i("TTZZLL" , "childWidth = $childWidth  childHeight = $childHeight ")

        }
        setMeasuredDimension(width,height)
    }
}
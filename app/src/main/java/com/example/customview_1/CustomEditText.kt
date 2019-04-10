package com.example.customview_1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.support.v7.widget.AppCompatEditText
import android.text.TextUtils
import android.util.AttributeSet

/**
 * Created by TianZuLin on 2019/4/2.
 */
class CustomEditText : AppCompatEditText {
    companion object {
        const val GRAVITY_RIGHT = "GRAVITY_RIGHT" // 当输入框显示hint的时候，此属性控制光标显示在最右边 。。。默认在最左边就不管了
    }

    private var mHint: CharSequence? = null

    private var mHintPaint: Paint? = null
    private var mCurHintTextColor = 0

    private var gravity = ""

    constructor(context: Context) : super(context) {
        CustomEditText(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mHint = hint
        hint = ""
        mHintPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.DITHER_FLAG)
        mHintPaint?.textSize = textSize
        mHintPaint?.textAlign = Paint.Align.RIGHT

//        setOnFocusChangeListener { v, hasFocus ->
//            if (hasFocus)
//                setSelection(3)
//        }
    }

    fun setGravityType(gravity: String) {
        this.gravity = gravity
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (TextUtils.isEmpty(mHint) || !TextUtils.isEmpty(text.toString()))
            return
        if (gravity == GRAVITY_RIGHT) {
            canvas?.save()
            val hintColor = hintTextColors
            if (hintColor != null) {
                val color = hintColor.getColorForState(drawableState, 0)
                if (color != mCurHintTextColor) {
                    mCurHintTextColor = color
                    mHintPaint?.color = color
                }

                val fontMetrics = mHintPaint?.fontMetricsInt
                val baseline = (height - fontMetrics!!.bottom + fontMetrics!!.top) / 2 - fontMetrics.top
                canvas?.drawText(
                    mHint, 0, mHint?.length!!.toInt(),
                    (width - paddingRight + scrollX).toFloat(),
                    baseline.toFloat(), mHintPaint
                )
                canvas?.restore()
            }
        }
    }
}

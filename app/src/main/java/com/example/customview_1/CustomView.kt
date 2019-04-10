package com.example.customview_1

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.LinearInterpolator

/**
 * Created by TianZuLin on 2019/4/3.
 */
class CustomView : View {
    var mPaint: Paint? = null
    var mPath: Path? = null
    var moveDx = 0

    val andWidth = 200f


    constructor(context: Context) : super(context) {
        CustomEditText(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        mPaint = Paint()
        mPaint?.color = Color.RED
        mPaint?.strokeWidth = 10f
        mPaint?.style = Paint.Style.FILL
        mPaint?.textSize = 100f
        mPaint?.setShadowLayer(10f, 15f, 15f, Color.GREEN) // 阴影

        mPath = Path()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
////        canvas?.drawText("呵呵啊哈" ,10f, 10f, mPaint)
//
//        canvas?.drawCircle(100f,200f, 100f, mPaint)
//
//        canvas?.drawLine(300f,200f ,400f,200f,mPaint)
//
//       var path =  Path()
//
//        path.moveTo(10f, 10f); //设定起始点
//        path.lineTo(10f, 100f);//第一条直线的终点，也是第二条直线的起点
//        path.lineTo(300f, 100f);//画第二条直线
//        path.lineTo(500f, 100f);//第三条直线
//        path.close();//闭环
//
//        canvas?.drawPath(path, mPaint)
//        canvas.drawColor(Color.RED)
//        //保存的画布大小为全屏幕大小
//        canvas.save()
//
//        canvas.clipRect( Rect(100, 100, 800, 800));
//        canvas.drawColor(Color.GREEN);
//        //保存画布大小为Rect(100, 100, 800, 800)
//        canvas.save();
//
//        canvas.clipRect( Rect(200, 200, 700, 700));
//        canvas.drawColor(Color.BLUE);
//        //保存画布大小为Rect(200, 200, 700, 700)
//        canvas.save();
//
//        canvas.clipRect( Rect(300, 300, 600, 600));
//        canvas.drawColor(Color.BLACK);
//        //保存画布大小为Rect(300, 300, 600, 600)
//        canvas.save();
//
//        canvas.clipRect( Rect(400, 400, 500, 500));
//        canvas.drawColor(Color.WHITE);

//        val path = Path()
//        path.moveTo(100f, 300f)
//        path.quadTo(200f, 200f, 300f, 300f)
//        path.quadTo(400f, 400f, 500f, 300f)
//        canvas.drawPath(path, mPaint)
//
//
//        canvas.drawPath(mPath, mPaint)
//        val widthS = lineWidth / 2f

        mPath?.reset()

        var i = 0f
        var x = 0
        mPath?.moveTo(-(andWidth * 2) + moveDx, originY)


//        mPath?.rQuadTo(andWidth / 2 ,originY / 2 , andWidth , 0f )
//        mPath?.rQuadTo(andWidth / 2 ,-originY / 2 , andWidth , 0f )
//        mPath?.rQuadTo(andWidth / 2 ,originY / 2 , andWidth , 0f )
//        mPath?.rQuadTo(andWidth / 2 ,-originY / 2 , andWidth , 0f )


        while (i <= width + andWidth* 2) {

            i += andWidth
            x++
            mPath?.rQuadTo(andWidth / 2, if (x % 2 == 0) 100f / 2 else -100f / 2, andWidth, 0f)
        }

        mPath?.lineTo(width.toFloat(), height.toFloat())
        mPath?.lineTo(0f, height.toFloat())
        mPath?.close()
        canvas.drawPath(mPath, mPaint)
    }

    var toX = 0f
    var toY = 0f

    val lineWidth = 400f
    val originY = 500f

    override fun onTouchEvent(event: MotionEvent): Boolean {
//        when (event.action) {
//            MotionEvent.ACTION_DOWN -> {
//                mPath?.moveTo(event.x, event.y)
//                return true
//            }
//            MotionEvent.ACTION_MOVE -> {
//                mPath?.lineTo(event.x, event.y)
//                postInvalidate()
//            }
//        }

//        when (event.action) {
//            MotionEvent.ACTION_DOWN -> {
//                toX = event.x
//                toY = event.y
//                mPath?.moveTo(toX, toY)
//                return true
//            }
//            MotionEvent.ACTION_MOVE -> {
//                var endX = (toX + event.x) / 2
//                var endY = (toY + event.y) / 2
//                mPath?.quadTo(toX, toY, endX, endY)
//                toX = endX
//                toY = endY
//                postInvalidate()
//            }
//        }


        return super.onTouchEvent(event)
    }

    fun startAnim() {
        val anim = ValueAnimator.ofInt(0, (andWidth * 2).toInt())
        anim.duration = 1000
        anim.interpolator = LinearInterpolator()
        anim.repeatCount = ValueAnimator.INFINITE
        anim.addUpdateListener {
            moveDx = it.animatedValue as Int
            postInvalidate()
            Log.i("TTZZLL", "$moveDx")
        }
        anim.start()
    }
}

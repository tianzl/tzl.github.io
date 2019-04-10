package com.example.customview_1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val a = intArrayOf(3, 2, 5)
        val b = intArrayOf(4, 6)

        val custom_view = findViewById<CustomView>(R.id.custom_view)
        val btn_start = findViewById<Button>(R.id.btn_start)
        btn_start.setOnClickListener {
            custom_view.startAnim()
        }

//        val findMedianSortedArrays = findMedianSortedArrays(a, b)
//        Log.i("TTZZLL", "$findMedianSortedArrays")
//
//        for(i in 0 until 10){
//            Log.i("TTZZLL" , "$i")
//        }
//
//        val edittext = findViewById<CustomEditText>(R.id.edittext)
//        edittext.setGravityType(CustomEditText.GRAVITY_RIGHT)
//        edittext.setOnFocusChangeListener { v, hasFocus ->
//                edittext.setSelection(edittext.text.toString().length)
//        }
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        var num3 = IntArray((nums1?.size ?: 0) + (nums2?.size ?: 0))
        if (nums1 != null) {
            for (i in 0 until nums1.size) {
                num3[i] = nums1[i]
            }
        }
        if (nums2 != null) {
            for (i in 0 until nums2.size) {
                num3[nums2.size + i] = nums2[i]
            }
        }

        for (i in 0 until num3.size - 1) {
            for (x in 0 + i until num3.size) {
                if (num3[x] <= num3[i]) {
                    val n = num3[x]
                    num3[x] = num3[i]
                    num3[i] = n
                }
            }
        }

        return if (num3.size % 2 == 0) {
            (num3[num3.size / 2] + num3[num3.size / 2 + 1]).toDouble() / 2.0
        } else {
            num3[num3.size / 2 + 1].toDouble()
        }
    }
}

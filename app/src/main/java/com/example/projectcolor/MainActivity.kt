package com.example.projectcolor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.myrow.view.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var timer: Boolean = true
    var countClicks: Int = 0

    override fun onClick(v: View?) {

        var visib1 = View.INVISIBLE
        var visib2 = View.INVISIBLE
        var visib3 = View.INVISIBLE
        var visib4 = View.INVISIBLE
        var visib5 = View.INVISIBLE

        Handler().postDelayed(
            Runnable {
                timer = false
                visib1 = View.INVISIBLE
                visib2 = View.INVISIBLE
                visib3 = View.INVISIBLE
                visib4 = View.INVISIBLE
                visib5 = View.INVISIBLE
                countClicks = 0
            },
            5000
        )
        var colorInt: Int = 0

        fun checkClicks() {
            if (countClicks == 2) {
                visib1 = View.INVISIBLE
                visib2 = View.VISIBLE
                drawUpLine2(colorInt, visib2)
            }
            if (countClicks == 3) {
                visib1 = View.INVISIBLE
                visib2 = View.INVISIBLE
                visib3 = View.VISIBLE
                drawUpLine3(colorInt, visib3)
            }
            if (countClicks == 4) {
                visib1 = View.INVISIBLE
                visib2 = View.INVISIBLE
                visib3 = View.INVISIBLE
                visib4 = View.VISIBLE
                drawUpLine4(colorInt, visib4)
            }
            if (countClicks == 5) {
                visib1 = View.INVISIBLE
                visib2 = View.INVISIBLE
                visib3 = View.INVISIBLE
                visib4 = View.INVISIBLE
                visib5 = View.VISIBLE
                drawUpLine5(colorInt, visib5)
            }
            if (countClicks > 5) {
                countClicks = 0
            }
        }

        fun timerTrue() {
            if (timer == true) {
                countClicks++
                visib1 = View.VISIBLE
                checkClicks()
            }
        }

        when (v?.getId()) {
            R.id.btn1 -> {
                colorInt = v.getResources().getColor(R.color.colorAccent)
                timerTrue()
                colorInt = v.getResources().getColor(R.color.colorAccent)
            }
            R.id.btn2 -> {
                colorInt = v.getResources().getColor(R.color.colorPrimary)
                timerTrue()
                colorInt = v.getResources().getColor(R.color.colorPrimary)
            }

            R.id.btn3 -> {
                colorInt = v.getResources().getColor(R.color.colorYellow)
                timerTrue()
                colorInt = v.getResources().getColor(R.color.colorYellow)
            }
        }
        drawLine(colorInt, visib1)
        timer = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
    }

    private fun drawLine(color: Int, visib: Int) {
        var myview: View = layoutInflater.inflate(R.layout.myrow, null, false)
        myview.line.setBackgroundColor(color)
        myview.line.setVisibility(visib)
        mparent.addView(myview)
    }

    private fun drawUpLine2(color: Int, visib: Int) {
        var myview: View = layoutInflater.inflate(R.layout.myrow, null, false)
        myview.lineUp.setBackgroundColor(color)
        myview.lineUp.setVisibility(visib)
        mparent.addView(myview)
    }

    private fun drawUpLine3(color: Int, visib: Int) {
        var myview: View = layoutInflater.inflate(R.layout.myrow, null, false)
        myview.lineUp2.setBackgroundColor(color)
        myview.lineUp2.setVisibility(visib)
        mparent.addView(myview)
    }

    private fun drawUpLine4(color: Int, visib: Int) {
        var myview: View = layoutInflater.inflate(R.layout.myrow, null, false)
        myview.lineUp3.setBackgroundColor(color)
        myview.lineUp3.setVisibility(visib)
        mparent.addView(myview)
    }

    private fun drawUpLine5(color: Int, visib: Int) {
        var myview: View = layoutInflater.inflate(R.layout.myrow, null, false)
        myview.lineUp4.setBackgroundColor(color)
        myview.lineUp4.setVisibility(visib)
        mparent.addView(myview)
    }

}


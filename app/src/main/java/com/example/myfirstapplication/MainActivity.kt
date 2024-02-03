package com.tutorialkart.drawshapeoncanvas

import android.graphics.Canvas
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Bitmap
import android.graphics.Paint
import android.graphics.drawable.BitmapDrawable
import android.util.DisplayMetrics


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bitmap = Bitmap.createBitmap(700, 1000, Bitmap.Config.ARGB_4444)
        val canvas = Canvas(bitmap)

        // canvas background color
        canvas.drawARGB(255, 78, 168, 186);

        var paint = Paint()
        paint.setColor(Color.parseColor("#FFFFFF"))
        paint.setStrokeWidth(30F)
        paint.setStyle(Paint.Style.STROKE)
        paint.setAntiAlias(true)
        paint.setDither(true)

        // get device dimensions
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        // circle center
        System.out.println("Width : "+displayMetrics.widthPixels)
        var center_x = (displayMetrics.widthPixels/2).toFloat()
        var center_y = (displayMetrics.heightPixels/2).toFloat()
        var radius = 300F

        // draw circle
        canvas.drawCircle(center_x, center_y, radius, paint)
        // now bitmap holds the updated pixels

        // set bitmap as background to ImageView
        imageV.background = BitmapDrawable(getResources(), bitmap)
    }
}
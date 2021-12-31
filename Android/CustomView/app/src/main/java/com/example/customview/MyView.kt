package com.example.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View

/**
 * 作者: LiangKe
 * 时间: 2021/9/8 14:44
 * 描述:
 */
class MyView :View{
    var paint = Paint()
    constructor(context: Context?) : super(context)




    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr)


    @SuppressLint("Range")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //paint.color=Color.RED

        /*paint.style=Paint.Style.STROKE
        paint.strokeWidth=20f
        paint.isAntiAlias=true
        canvas.drawCircle((300).toFloat(), (300).toFloat(), 200.toFloat(),paint)*/
        //绘制矩形
        /*paint.style=Paint.Style.STROKE
        canvas.drawRect(100f, 100f, 500f, 500f, paint)*/
       //绘制点
      /*  paint.strokeWidth=30f
        paint.strokeCap=Paint.Cap.BUTT
        canvas.drawPoint(50f,50f,paint)*/
       //绘制 批量点
      /*  val posits= floatArrayOf(0F, 0F, 50F, 50F, 50F, 100F, 100F, 50F, 100F, 100F, 150F, 50F)
        paint.strokeWidth=20f
        paint.strokeCap=Paint.Cap.ROUND
        canvas.drawPoints(posits,2,8,paint)*/
        //画椭圆
    /*    paint.style=Paint.Style.STROKE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(100f,50f,700f,200f,paint)
        }*/
        //划线
      /*  paint.strokeWidth=20f
        canvas.drawLine(200f,200f,800f,500f,paint)*/

        //批量划线
      /*  val posits= floatArrayOf(20F, 20F, 120F, 20F, 70F, 20F, 70F, 120F, 20F, 120F,120f,120f)
        paint.strokeWidth=20f
        canvas.drawLines(posits,paint)*/
        //绘制圆角矩形
       /* paint.style=Paint.Style.STROKE
        paint.strokeWidth=20f
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(100f,100f,500f,300f,50f,50f,paint)
        }*/
       //绘制弧形或扇形
        paint.style=Paint.Style.FILL
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(200f,100f,800f,500f,-100f,100f,true,paint)
            canvas.drawArc(200f, 100f, 800f, 500f, 20f, 140f, false, paint)
            paint.style=Paint.Style.STROKE
            canvas.drawArc(200f, 100f, 800f, 500f, 180f, 60f, false, paint)
        }

    }

}
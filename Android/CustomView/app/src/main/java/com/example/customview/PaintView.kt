package com.example.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * 作者: LiangKe
 * 时间: 2021/9/15 14:48
 * 描述:
 */
class PaintView:View {

    private val paint= Paint()
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        //直接设置颜色
       paint.color = Color.parseColor("#009688")

        canvas.drawRect(30f,30f,280f,170f,paint)

        paint.color = Color.parseColor("#FF9800")
        paint.strokeWidth=21f
        canvas.drawLine(300f, 30f, 450f, 180f, paint)

        paint.color = Color.parseColor("#E91E63")
        paint.textSize=80f
        canvas.drawText("HenCoder", 500f, 130f, paint)


    }


}
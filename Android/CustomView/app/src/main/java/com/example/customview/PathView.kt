package com.example.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * 作者: LiangKe
 * 时间: 2021/9/9 14:44
 * 描述:
 */
class PathView : View {
    private val paint = Paint()

    private val path = Path()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
              path.addArc(200f, 200f, 400f, 400f, -225f, 225f)
              path.arcTo(400f, 200f, 600f, 400f, -180f, 225f, false);
              path.lineTo(400f, 542f);
          }
          canvas.drawPath(path, paint)*/

        path.addCircle(200f, 200f, 200f, Path.Direction.CCW)

        canvas.drawPath(path, paint)
//划线
        /*   paint.style=Paint.Style.STROKE
           paint.strokeWidth=23f
           path.lineTo(500f,100f)  // 由当前位置 (0, 0) 向 (100, 100) 画一条直线
           path.rLineTo(100f,0f) // 由当前位置 (100, 100) 向正右方 100 像素的位置画

           canvas.drawPath(path, paint)*/
//画弧形
        /*     paint.style=Paint.Style.STROKE
             paint.strokeWidth=10f

             path.lineTo(100f,100f)

             if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                 path.arcTo(100f,100f,300f,300f,-90f,90f,true)
             }
             canvas.drawPath(path, paint)*/
/*//addArc画弧形
        paint.style = Paint.Style.STROKE
        path.lineTo(100f, 100f);
        paint.strokeWidth=10f
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.addArc(100f, 100f, 300f, 300f, -90f, 90f)
        };*/
//封闭子图形
        /*     paint.style = Paint.Style.STROKE
             paint.strokeWidth=10f
             path.moveTo(100f, 100f);
             path.lineTo(200f, 100f);
             path.lineTo(150f, 150f);
            // path.close(); // 使用 close() 封闭子图形。等价于 path.lineTo(100, 100)

             canvas.drawPath(path, paint)*/
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {


        var measuredWidth = 400
        var measuredHeight = 400

        measuredWidth = resolveSize(measuredWidth, widthMeasureSpec)
        measuredHeight = resolveSize(measuredHeight, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, measuredHeight)
    }
}
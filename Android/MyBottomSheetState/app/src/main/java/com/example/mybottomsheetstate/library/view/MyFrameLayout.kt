package com.example.mybottomsheetstate.library.view

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.widget.FrameLayout


/**
 * 作者: LiangKe
 * 时间: 2021/10/9 12:52
 * 描述:
 */
class MyFrameLayout:FrameLayout {
    private var paint: Paint= Paint()
    private var path: Path = Path()
   // private var width = 0f


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        //2、通过Resources获取
        //2、通过Resources获取
        val dm = resources.displayMetrics
     //   width = dm.widthPixels.toFloat()

        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.strokeWidth=10f
        path = Path()
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = Color.BLACK
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun onDraw(canvas: Canvas) {
        paint.color = resources.getColor(R.color.black)
        paint.setShadowLayer(30f, 0f, 20f, Color.BLACK)
        path.moveTo(0f, dip2px(28f))
        path.lineTo(dip2px(150f), dip2px(28f))
        path.quadTo(width / 2 - dip2px(30f), dip2px(28f), width / 2 - dip2px(25f), dip2px(18f))
        path.quadTo((width / 2).toFloat(), -45f, width / 2 + dip2px(25f), dip2px(18f))
        path.quadTo(width / 2 + dip2px(30f), dip2px(28f), width - dip2px(150f), dip2px(28f))
        path.lineTo(width.toFloat(), dip2px(28f))
        path.lineTo(width.toFloat(), dip2px(71f))
        path.lineTo(0f, dip2px(71f))
        path.close()
        canvas.drawPath(path, paint)
        super.onDraw(canvas)
    }

    /**
     * 根据屏幕的分辨率从 dp 的单位 转成为 px(像素)
     */
    private fun dip2px(dpValue: Float): Float {
        val scale = resources.displayMetrics.density
        return (dpValue * scale + 0.5f)
    }



}
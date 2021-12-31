package com.example.customview

import android.animation.ObjectAnimator
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.animation.LinearInterpolator
import androidx.appcompat.widget.AppCompatImageView


/**
 * 作者: LiangKe
 * 时间: 2021/9/16 9:16
 * 描述:
 */
class MusicButton:AppCompatImageView {

   private lateinit var objectAnimator: ObjectAnimator
    private val playing = 1 //正在播放

    private val pause = 2 //暂停

    private val stop = 3 //停止

    var state = 0


    constructor(context: Context) : super(context){

    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs){
        init()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr

    )




private fun init(){
    state = stop
    objectAnimator = ObjectAnimator.ofFloat(this, "rotation", 0f, 360f) //添加旋转动画，旋转中心默认为控件中点

    objectAnimator.duration = 3000 //设置动画时间

    objectAnimator.interpolator = LinearInterpolator() //动画时间线性渐变

    objectAnimator.repeatCount = ObjectAnimator.INFINITE
    objectAnimator.repeatMode = ObjectAnimator.RESTART
}

    /**
     * 开始动画
     */
    fun playMusic() {
        when (state) {
            stop -> {
                objectAnimator.start() //动画开始
                state = playing
            }
            pause -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    objectAnimator.resume()
                } //动画重新开始
                state = playing
            }
            playing -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    objectAnimator.pause()
                } //动画暂停
                state = pause
            }
        }
    }

    /**
     * 结束动画
     */
    fun stopMusic() {
        objectAnimator.end() //动画结束
        state = stop
    }

}
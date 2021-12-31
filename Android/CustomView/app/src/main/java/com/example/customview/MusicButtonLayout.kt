package com.example.customview


import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout


/**
 * 作者: LiangKe
 * 时间: 2021/9/18 13:31
 * 描述:
 */
class MusicButtonLayout : FrameLayout {

    private var mTotalProgress = 0

    private var mCurrentProgress = 0

    //进度条
    private var mTasksView: MusicButtonView? = null

    //内圆
    private lateinit var musicButtonViewInnerCircle: MusicButtonViewInnerCircle

    private lateinit var objectAnimator: ObjectAnimator
    private val playing = 1 //正在播放

    private val pause = 2 //暂停

    private val stop = 3 //停止

    var state = 0

    private var jumpOut = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mTasksView = MusicButtonView(context, attrs)

        musicButtonViewInnerCircle = MusicButtonViewInnerCircle(context, attrs)
        init()

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    /**
     *  是否显示字体
     * @param isDisplayText Boolean
     */
    fun isDisplayText(isDisplayText:Boolean){
        mTasksView?.isDisplayText(isDisplayText)
    }
    /**
     * 进度条总值
     * @param TotalProgress Int
     */
    fun setTotalProgress(TotalProgress: Int) {
        this.mTotalProgress = TotalProgress
        Thread(ProgressRunnable()).start()
        this.addView(mTasksView)
    }

    /**
     * 设置圆内图片
     * @param bitmap Bitmap
     */
    fun setBitmap(bitmap: Bitmap){
        musicButtonViewInnerCircle.setBitmap(bitmap)
    }
    private fun init() {
        state = stop
        objectAnimator = ObjectAnimator.ofFloat(
            musicButtonViewInnerCircle,
            "rotation",
            0f,
            360f
        ) //添加旋转动画，旋转中心默认为控件中点

        objectAnimator.duration = 10000 //设置动画时间  也就是旋转时间

        objectAnimator.interpolator = LinearInterpolator() //动画时间线性渐变

        objectAnimator.repeatCount = ObjectAnimator.INFINITE
        objectAnimator.repeatMode = ObjectAnimator.RESTART
        this.addView(musicButtonViewInnerCircle)
    }

    /**
     * 开始动画
     */
    fun playMusic() {
        when (state) {
            stop -> {
                objectAnimator.start() //动画开始
                state = playing
                jumpOut = false
                Thread(ProgressRunnable()).start()
            }
            pause -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    objectAnimator.resume()
                } //动画重新开始
                state = playing
                jumpOut = false
                Thread(ProgressRunnable()).start()
            }
            playing -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    objectAnimator.pause()
                } //动画暂停
                state = pause
                jumpOut = true
            }
        }
    }

    /**
     * 结束动画
     */
    fun stopMusic() {
        objectAnimator.end() //动画结束
        state = stop
        jumpOut = true
        mCurrentProgress = 0
        mTasksView?.setProgress(mCurrentProgress)
    }

    inner class ProgressRunnable : Runnable {
        override fun run() {

            while (mCurrentProgress < mTotalProgress) {
                Log.d("ProgressRunnable", jumpOut.toString())
                if (jumpOut) {
                    break
                }
                mCurrentProgress += 1

                mTasksView?.setProgress(mCurrentProgress)
                if (mCurrentProgress==mTotalProgress){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                         Handler(Looper.getMainLooper()).post {
                             stopMusic()
                         }
                    }
                }
                try {
                    Thread.sleep(500)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

}

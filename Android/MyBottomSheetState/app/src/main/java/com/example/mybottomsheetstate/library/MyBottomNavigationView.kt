package com.example.mybottomsheetstate.library

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.annotation.IdRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mybottomsheetstate.R
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * 作者: LiangKe
 * 时间: 2021/10/6 21:59
 * 描述:
 */
class MyBottomNavigationView : RelativeLayout {

    @SuppressLint("ResourceType")
    @IdRes
    var TAG1401 = 1001
    var TAG1402 = 1002
    var TAG1403 = 1003


    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    @SuppressLint("ResourceType")
    private fun initView(context: Context, attrs: AttributeSet?) {
   /*     val bLayout = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        val navView = BottomNavigationView(context, attrs)
        bLayout.addRule(ALIGN_PARENT_BOTTOM)
        navView.layoutParams = bLayout

        navView.id = TAG1401
        addView(navView)
*/

/*        val layout = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        val arc = DrawArc(context, attrs)
        arc.id = TAG1402
        layout.addRule(BELOW, R.id.nav_view)
        arc.layoutParams = layout

        addView(arc)*/
        //layout.addRule(ALIGN_PARENT_BOTTOM)


/*        val lp = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)

        val straightLine = StraightLine(context, attrs)
        straightLine.id = TAG1403
    //    lp.addRule(BELOW, TAG1402)
        straightLine.layoutParams = lp
        addView(straightLine)*/


    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)



    }


}
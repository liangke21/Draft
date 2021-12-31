package com.example.mybottomsheetstate.library.util

import android.content.Context


/**
 * 作者: LiangKe
 * 时间: 2021/10/7 15:45
 * 描述:
 */
object Uitl {


    private fun dp2px(dp: Int,context: Context): Int {
        return (context.resources.displayMetrics.density * dp).toInt()
    }
}
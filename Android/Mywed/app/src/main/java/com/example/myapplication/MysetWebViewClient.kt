package com.example.myapplication

import android.webkit.WebView
import android.webkit.WebViewClient

class MysetWebViewClient: WebViewClient() {
    override fun onPageFinished(view: WebView?, url: String?) {



   if (url != null && url.contains("https://play.kotlinlang.org/?_ga=2.106047427.1527444061.1611111387-584556140.1611111387#eyJ2ZXJzaW9uIjoiMS40LjIwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsImpzQ29kZSI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiLyoqXG4gKiBZb3UgY2FuIGVkaXQsIHJ1biwgYW5kIHNoYXJlIHRoaXMgY29kZS4gXG4gKiBwbGF5LmtvdGxpbmxhbmcub3JnIFxuICovXG5cbmZ1biBtYWluKCkge1xuICAgIHByaW50bG4oXCJIZWxsbyx3b3JsZFwiKVxufSJ9")) {
            val fun1 =
                "javascript:function getClass(parent,sClass) { var aEle=parent.getElementsByTagName('div'); var aResult=[]; var i=0; for(i<0;i<aEle.length;i++) { if(aEle[i].className==sClass) { aResult.push(aEle[i]); } }; return aResult; } "
            view!!.loadUrl(fun1)
            val fun2 =
                "javascript:function hideOther() " +
                        "{getClass(document,'header')[0].style.display='none'; " +
                        "getClass(document,'jetbrains-cookies-banner jetbrains-cookies-banner--position-right')[0].style.display='none'; " +
                        "getClass(document,'configuration')[0].style.display='none'; " +
                        "getClass(document,'share')[0].style.display='none'; " +
                        "getClass(document,'help-button')[0].style.display='none'; " +
                        "getClass(document,'footer')[0].style.display='none';" +//底部文字
                        "getClass(document,'playground playground_default')[0].style='margin-top:0px';" +//修改网页高外边距
                      //  "getClass(document,'js-code-output-executor darcula')[0].style.display='none';" +//底部横线 找了半天
                        " document.getElementById('id_sidebar').style.display='none'; " +
                        "document.getElementById('top_nav').style.display='none'; " +
                        "document.getElementById('fix-personal').style.display='none'; " +
                        "document.getElementById('waterlogo').style.display='none';" +
                        "getClass(document,'wrap')[0].style.minWidth=0;" +
                        "getClass(document,'game')[0].style.paddingTop=0;}"
            view!!.loadUrl(fun2)
            view!!.loadUrl("javascript:hideOther();")
        }

        super.onPageFinished(view, url)
    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
        view.loadUrl(url)
        return true
    }
}
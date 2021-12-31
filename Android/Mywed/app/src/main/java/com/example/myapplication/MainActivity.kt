package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_maina.*

class MainActivity : AppCompatActivity() {
    private val handler: Handler = Handler()

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maina)
        supportActionBar?.hide()
        val a =
            "https://play.kotlinlang.org/?_ga=2.106047427.1527444061.1611111387-584556140.1611111387#eyJ2ZXJzaW9uIjoiMS40LjIwIiwicGxhdGZvcm0iOiJqYXZhIiwiYXJncyI6IiIsImpzQ29kZSI6IiIsIm5vbmVNYXJrZXJzIjp0cnVlLCJ0aGVtZSI6ImlkZWEiLCJjb2RlIjoiLyoqXG4gKiBZb3UgY2FuIGVkaXQsIHJ1biwgYW5kIHNoYXJlIHRoaXMgY29kZS4gXG4gKiBwbGF5LmtvdGxpbmxhbmcub3JnIFxuICovXG5cbmZ1biBtYWluKCkge1xuICAgIHByaW50bG4oXCJIZWxsbyx3b3JsZFwiKVxufSJ9"
        val b = "https://www.baidu.com"
        webWebView.loadUrl(a)
        webWebView.webViewClient = MysetWebViewClient()
        webWebView.settings.javaScriptEnabled = true
        webWebView.onResume()
        webWebView.webChromeClient = MyWebChromeClient()
    }

    inner class MyWebChromeClient : WebChromeClient() {

        @SuppressLint("SetTextI18n")
        override fun onProgressChanged(view: WebView?, newProgress: Int) {
            super.onProgressChanged(view, newProgress)
            /**
             * 要执行的操作
             */
            progressBar.progress = newProgress
            txtProgress.text = "$newProgress %"
            if (newProgress == 100 && progressBar.visibility == View.VISIBLE) {
                handler.postDelayed(
                    {
                        progressBar.visibility = View.GONE
                        txtProgress.visibility = View.GONE
                        /**
                         * 要执行的操作
                         */

                    }, 2000//延迟2秒
                )

            }

        }
    }

}
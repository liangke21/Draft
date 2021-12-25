package com.example.webViewOAuth

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.*
import com.example.webViewOAuth.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

       private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityMainBinding.inflate(layoutInflater)

        supportActionBar?.hide()

        setContentView(binding.root)

        oauthWebViewClient()
    }

    /**
     * wabView 获取授权码
     */

    @SuppressLint("SetJavaScriptEnabled")
    private fun oauthWebViewClient() {
        binding.videoView.settings.javaScriptEnabled = true;
        val redirectUri = "http://openapi.baidu.com/oauth/2.0/login_success?code="//一定要多加入一个返回授权码的键?code=
        val url =
            "https://openapi.baidu.com/oauth/2.0/authorize?response_type=code&client_id=KX2pTgOhg0IKAdeAZTfPWTIwfGva5XVY&redirect_uri=http://openapi.baidu.com/oauth/2.0/login_success&scope=basic,netdisk&display=mobile&qrcode=0&force_login=1&device_id=820921428tp8x63q51"
        binding.videoView.loadUrl(url)
        /**
         *重点 重点 重点  说三遍,一定要设置一个redirectUri回调地址,通过webview的shouldOverrideUrlLoading函数来判断
         */
        binding.videoView.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                Log.d("MainActivity", url!!)

                if (url.contains(redirectUri)) {

                    //实现逻辑

                    return true
                }

                return false
            }


        }
        binding.videoView.webChromeClient=object:WebChromeClient(){

            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)

                binding.textView.text= title
            }

            override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
                super.onReceivedIcon(view, icon)
                binding.imageView.setImageBitmap(icon)
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        //登录成功后销毁Cookie
        CookieManager.getInstance().removeAllCookies { value -> Log.d("MainActivity  清除", value.toString()) }
        binding.videoView.clearCache(true)
        binding.videoView.clearHistory()
        binding.videoView.clearFormData()
        binding.videoView.destroy()
    }

    /**
     * A native method that is implemented by the 'webViewOAuth' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'webViewOAuth' library on application startup.
        init {
            System.loadLibrary("webViewOAuth")
        }
    }
}
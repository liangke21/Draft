package com.androidlk.processthreadcommunication


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
@Suppress("UNREACHABLE_CODE")
class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        //testCacheThreadPool()
        // testFixedThreadPool()
        // testSingleThreadExecutor()
        //testScheduledThreadPool()

    }

    /**
     * 单一线程 定时 定周期
     */

    private fun testScheduledThreadPool() {
        val mScheduledThreadPool = Executors.newSingleThreadScheduledExecutor()

        /* mScheduledThreadPool.schedule(object : Runnable {
             //定时3秒后执行
             override fun run() {
                 Log.d("TAG", "${Thread.currentThread().name} 延迟执行")
             }
         }, 3, TimeUnit.SECONDS)*/

        //定时为两秒后执行每隔3秒执行一次
        mScheduledThreadPool.scheduleAtFixedRate(object : Runnable {
            override fun run() {
                Log.d("TAG", "${Thread.currentThread().name} 延迟执行")
            }

        }, 2, 3, TimeUnit.SECONDS)
        //关闭线程
        //  mScheduledThreadPool.shutdown()

    }

    /**
     * 创建一个单列化的线程池
     * 他只会用唯一的线程来执行任务 保证所有的任务都是顺序执行
     *
     */
    private fun testSingleThreadExecutor() {
        val mSingleThreadExecutor = Executors.newSingleThreadExecutor()
        for (i in 0 until 10) {

            mSingleThreadExecutor.submit(object : Runnable {
                override fun run() {
                    Log.d("TAG", "${Thread.currentThread().name} $i")
                }
            })

        }
    }

    /**
     * 可控制线程最大并发数
     * 超出最大线程会在列队中等待
     * 执行完回收线程
     */
    private fun testFixedThreadPool() {

        val mFixedThreadPool = Executors.newFixedThreadPool(3)

        for (i in 0 until 10) {
            mFixedThreadPool.submit(object : Runnable {
                override fun run() {
                    Log.d("TAG", "${Thread.currentThread().name} $i")
                    //同时执行3个,没3个休息2秒
                    Thread.sleep(2000)
                }
            })
        }
    }

    /**
     * 缓存线程池
     * 超出线程处理的需要可以灵活的回收 字面意思就是 回收先执行完的线程
     * 若无可回收,就新建
     */
    private fun testCacheThreadPool() {
        val mCachedThreadPool = Executors.newCachedThreadPool()
        for (i in 0 until 10) {
            //没2秒执行一个
            Thread.sleep(2000)
            mCachedThreadPool.submit(object : Runnable {
                override fun run() {
                    Log.d("TAG", "${Thread.currentThread().name} age${i}")

                }
            })
        }
    }


}
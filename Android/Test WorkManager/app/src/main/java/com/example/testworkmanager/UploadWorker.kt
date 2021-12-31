package com.example.testworkmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 * 作者: LiangKe
 * 时间: 2021/11/5 13:04
 * 描述:
 */

class UploadWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // Do the work here--in this case, upload the images.
        //uploadImages()

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}

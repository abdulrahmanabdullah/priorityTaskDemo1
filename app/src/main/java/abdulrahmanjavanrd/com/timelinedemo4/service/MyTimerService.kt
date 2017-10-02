package abdulrahmanjavanrd.com.timelinedemo4.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * Created by nfs05 on 01/10/2017.
 */
class MyTimerService:Service() {
companion object {
    private val TAG = MyTimerService::class.java.simpleName
}
    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"onCreate , ${Thread.currentThread().name}")
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var time:Int = intent!!.getIntExtra("timer",1)
        MyTaskSync().execute(time)
         Log.i(TAG,"onStartCommand   ${Thread.currentThread().name}")
        return START_STICKY
    }


    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"onDestroy , ${Thread.currentThread().name}")
    }
}


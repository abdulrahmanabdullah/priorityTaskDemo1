package abdulrahmanjavanrd.com.timelinedemo4.service

import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import android.util.Log

/**
 * Created by nfs05 on 02/10/2017.
 */

class MyIntentService():IntentService("Worker Thread"){
    companion object {
        private val TAG = MyIntentService::class.java.simpleName
    }

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"onCreate , Thread => ${Thread.currentThread().name}")
    }

    override fun onHandleIntent(p0: Intent?) {

        var timer = p0!!.getIntExtra("timer",5)
        var ctr = 1

        // reciver
        var reciver:ResultReceiver = p0!!.getParcelableExtra("sendReceiver")

        var bundle = Bundle()
        while (ctr <= timer!!){
            Log.i(TAG,"Counter = $ctr")
            Thread.sleep(1000)
            ctr++

            bundle.putString("result","$ctr")
            reciver.send(1,bundle)

            if (ctr >= timer){
                bundle.putString("finish","Done")
                bundle.putInt("removeItem",0)
                reciver.send(2,bundle)
            }


        } // end while loop .
        Log.i(TAG,"onHandleIntent , Thread => ${Thread.currentThread().name}")

    }


    override fun onDestroy() {
        Log.i(TAG,"onDestroy , Thread => ${Thread.currentThread().name}")
        super.onDestroy()
    }

}
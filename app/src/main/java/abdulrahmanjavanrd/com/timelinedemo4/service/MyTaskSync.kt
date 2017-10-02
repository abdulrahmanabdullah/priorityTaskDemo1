package abdulrahmanjavanrd.com.timelinedemo4.service

import abdulrahmanjavanrd.com.timelinedemo4.Model.WorksList
import android.os.AsyncTask
import android.util.Log

/**
 * Created by nfs05 on 01/10/2017.
 */
class MyTaskSync: AsyncTask<Int, String, Void>(){

    companion object {
        private val TAG = MyTaskSync::class.java.simpleName
    }
    override fun onPreExecute() {

        Log.i(TAG,"onPreEXecute , Thread name = ${Thread.currentThread().name} ")
        super.onPreExecute()
    }

    override fun onProgressUpdate(vararg values: String?) {
        Log.i(TAG,"onProgressUpdate  Counter=${values[0]}, Thread name = ${Thread.currentThread().name} ")
        super.onProgressUpdate(*values)
    }

    // long running ..
    override fun doInBackground(vararg p0: Int?): Void? {
        var timer = p0[0]
        var ctr = 1
        var o = setTextViewResult()
        while (ctr <= timer!!){
            publishProgress("$ctr")
            Thread.sleep(1000)
            o.setTxt = "$ctr"
            ctr++
            if(ctr == timer){
                //TODO: remove first items in ArrayList
                var workList = WorksList()
                var list:ArrayList<String> = workList.getArrayList()
                list.removeAt(0)
            }
        }
        Log.i(TAG,"doInBackground , $ctr ," +
                "Test TXT = ${o.setTxt} Thread name = ${Thread.currentThread().name} ")
        return null
    }

    override fun onPostExecute(result: Void?) {

        Log.i(TAG,"onPostExecute, Thread name = ${Thread.currentThread().name} ")
        super.onPostExecute(result)
    }
}

class setTextViewResult{
    var setTxt:String?=null

}
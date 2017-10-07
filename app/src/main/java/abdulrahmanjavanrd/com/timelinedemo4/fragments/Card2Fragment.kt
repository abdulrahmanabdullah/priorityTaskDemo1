package abdulrahmanjavanrd.com.timelinedemo4.fragments

import abdulrahmanjavanrd.com.timelinedemo4.Model.WorksList
import abdulrahmanjavanrd.com.timelinedemo4.R
import abdulrahmanjavanrd.com.timelinedemo4.service.MyIntentService
import android.app.Activity
import android.app.Fragment
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

/**
 * Created by nfs05 on 28/09/2017.
 */
class Card2Fragment:Fragment() {


    var handler = Handler()
    var o = WorksList()
    var ar:ArrayList<String> =o.getArrayList()
    var list:ListView?=null
    var listAdapter:ArrayAdapter<String>?=null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v:View = inflater!!.inflate(R.layout.fragment_card2,container,false)

        list  = v.findViewById(R.id.list_item_priority)
        listAdapter = ArrayAdapter(activity,R.layout.list_items_layout,ar)
        list!!.adapter = listAdapter


        return v
    }




    private val resultRe = object :BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
    override fun onResume() {
        super.onResume()
        var intentFilter = IntentFilter()
        intentFilter.addAction("android.send.to.activity")
        activity.registerReceiver(resultRe,intentFilter)
    }

    // ResultReceiver to remove firstItems ..
    private inner class MyresultReceiverInner(handler:Handler?):ResultReceiver(handler){

        override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {
            if(resultCode == 2 && resultData != null ){

                var item:Int = resultData.getInt("removeItem")
                handler.post(Runnable {
                    kotlin.run {
                        ar.removeAt(item)
                         listAdapter = ArrayAdapter(activity,R.layout.list_items_layout,ar)
                        list!!.adapter = listAdapter
                       Log.i("My","list item = $ar")
                    }
                })
            }
            super.onReceiveResult(resultCode, resultData)
        }

    }


}
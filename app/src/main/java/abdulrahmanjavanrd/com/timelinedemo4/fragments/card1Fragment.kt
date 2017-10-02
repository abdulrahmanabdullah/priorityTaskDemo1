package abdulrahmanjavanrd.com.timelinedemo4.fragments

import abdulrahmanjavanrd.com.timelinedemo4.R
import abdulrahmanjavanrd.com.timelinedemo4.service.MyIntentService
import android.os.Bundle
import android.app.Fragment
import android.content.Intent
import android.os.Handler
import android.os.ResultReceiver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class card1Fragment : Fragment() {

    // init time hours and day and month
    var numberType:Int?= null
    var hours:Int?=null
    var day:Int?=null
    var month:Int?=null

    // declare spinner
    var spinnerNumbers: Spinner? = null
    var spinnerDate: Spinner? = null


    var handler = Handler()
    var title: TextView? = null

    var timer: TextView? = null

    var upTime: Int = 0
    // Adapter for spinner numbers and spinner Date ..
    // I need to init two array ..
    private val spArrayNumber: String = arrayOf("", 0, 1, 2, 3, 4, 5, 6, 7, 8, 9).toString()
    private val spArrayDate = arrayOf("", "hours", "Day", "Month")

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v: View = inflater!!.inflate(R.layout.fragment_card1, container, false)

//        mySpinner(v)


        startTime(v)
        return v
    }

    // create method for spinner ..
//    private fun mySpinner(v:View){
//        title = v.findViewById(R.id.txCard1Title)
//        spinnerNumbers = v.findViewById(R.id.spinner_numbers)
//        var adapterArray:ArrayAdapter<String> = ArrayAdapter(activity,android.R.layout.simple_list_item_1,spArrayDate)
//        spinnerNumbers!!.adapter = adapterArray
//        spinnerDate = v.findViewById(R.id.spinner_date)
//
//        spinnerNumbers!!.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(p0: AdapterView<*>?) {
//               title!!.text = "Nothing"
//            }
//
//            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
//                title!!.text = spArrayDate[p2]
//            }
//
//        }
//
//
//    }
//
//    private fun testSpinner(v: View) {
//        title = v.findViewById(R.id.txCard1Title)
//        spinnerNumbers = v.findViewById(R.id.spinner_numbers)
//        title!!.text = spinnerNumbers!!.selectedItem.toString()
//        Log.d("spinner ", "${spinnerNumbers!!.selectedItem}")
//    }


    /************************** Timer ********************************/
    private fun startTime(v: View) {

        var myResultReceiver = MyresultReceiver(null)
          timer = v.findViewById(R.id.tvTimer)
        timer!!.text = "Click to start "
        timer!!.setOnClickListener({
            var intentP = Intent(activity, MyIntentService::class.java)
            // TODO: pass all time to MyTimerService .
            intentP.putExtra("timer",5)
            intentP.putExtra("sendReceiver",myResultReceiver)
            activity.startService(intentP)

        })


    }



    /************************* Inner class for ResultReceiver  .. *********************/

    private inner class MyresultReceiver(handler:Handler?):ResultReceiver(handler){

        override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {

            if (resultCode == 1 && resultData != null ){
                var str = resultData.get("result").toString()
                handler.post(Runnable {
                    kotlin.run {
                        timer!!.text = str
                    }

                })


            }

            else if (resultCode == 2 && resultData != null){
                var str = resultData.get("finish").toString()
                handler.post(Runnable {
                    kotlin.run {
                        timer!!.text = str
                    }

                })
            }

            super.onReceiveResult(resultCode, resultData)
        }
    }
    /************************* End ResultReciver .. *********************/

}// Required empty public constructor


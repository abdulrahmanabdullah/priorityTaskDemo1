package abdulrahmanjavanrd.com.timelinedemo4.fragments

import abdulrahmanjavanrd.com.timelinedemo4.R
import abdulrahmanjavanrd.com.timelinedemo4.service.MyTimerService
import abdulrahmanjavanrd.com.timelinedemo4.service.setTextViewResult
import android.os.Bundle
import android.app.Fragment
import android.content.Intent
import android.os.CountDownTimer
import android.util.Log
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

    private fun testSpinner(v: View) {
        title = v.findViewById(R.id.txCard1Title)
        spinnerNumbers = v.findViewById(R.id.spinner_numbers)
        title!!.text = spinnerNumbers!!.selectedItem.toString()
        Log.d("spinner ", "${spinnerNumbers!!.selectedItem}")
    }


    /************************** Timer ********************************/
    private fun startTime(v: View) {
//        var count = counter(100000, 100)

        timer = v.findViewById(R.id.tvTimer)
        timer!!.text = "Click to start "
        timer!!.setOnClickListener({
            var intentP = Intent(activity, MyTimerService::class.java)
            // TODO: pass all time to MyTimerService .
            intentP.putExtra("timer",10)
            activity.startService(intentP)

            var obj = setTextViewResult()
            var o = obj.setTxt
            timer!!.text = o
        })


    }


    private fun stopTime(v: View) {
        timer = v.findViewById(R.id.tvTimer)
        var count = counter(100000, 100)
        count.cancel()
    }

    /**************************  end Timer ********************************/


    /************************* Inner class for timer .. *********************/
    inner class counter(millSecond: Long, countDown: Long) : CountDownTimer(millSecond, countDown) {


        override fun onFinish() {

            timer!!.text = "Done"
        }

        override fun onTick(p0: Long) {

            upTime++
            timer!!.text = upTime.toString()


        }

    }
    /************************* End Inner class for timer .. *********************/

}// Required empty public constructor

//fun LoneWolf(){
//    var ar = arrayOf("It's not easy going it alone " +
//            "But if you keep going " +
//            "Stay true to yourself " +
//            "It well be worth it in the end " +
//            "the hardest walk you can make " +
//            "is the walk you make alone " +
//            "But that is the  walk " +
//            "that makes you the strongest " +
//            "That is the walk that builds your character the most " +
//            "to all of you fighting battles alone " +
//            "to all of you going against the grain battling naysayers " +
//            "Stay Strong keep Going ")
//}
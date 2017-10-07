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
import android.widget.AdapterView.OnItemSelectedListener

class card1Fragment : Fragment() {

    // init time hours and day and month
//    private lateinit var  numberType:Int

    private var numberType:Int =0

    var hours: Int? = null
    var day: Int? = null
    var month: Int? = null

    // declare spinner
    var spinnerNumbers: Spinner? = null
    var spinnerDate: Spinner? = null


    var handler = Handler()
    var title: TextView? = null

    var timer: TextView? = null

    var upTime: Int = 0
    // Adapter for spinner numbers and spinner Date ..
    // I need to init two array ..
    private val spArrayNumber = arrayOf("", "1", "2", "3", "4", "5", "6", "7", "8", "9")
    private val spArrayDate = arrayOf("", "hours", "Day", "Month")

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v: View = inflater!!.inflate(R.layout.fragment_card1, container, false)


        /************ init access element of gui . ****************/

        spinnerNumbers = v.findViewById(R.id.spinner_numbers)
        spinnerDate = v.findViewById(R.id.spinner_date)
        timer = v.findViewById(R.id.tvTimer)

        readyMethod()

        return v
    }

    fun initSpinner(v: View) {
        var mSpinnerNumbers:Spinner = v.findViewById(R.id.spinner_numbers)

        val mSpinnerDate:Spinner = v.findViewById(R.id.spinner_date)
        val mNumbersAdapter: ArrayAdapter<String> = ArrayAdapter(activity, android.R.layout.simple_spinner_dropdown_item, spArrayNumber)
        val mDateAdapter:ArrayAdapter<String> = ArrayAdapter(activity,android.R.layout.simple_spinner_dropdown_item,spArrayDate)

         mSpinnerNumbers.adapter = mNumbersAdapter
        mSpinnerDate.adapter = mDateAdapter

        Toast.makeText(activity,"your choice ${mSpinnerNumbers.selectedItem}",Toast.LENGTH_LONG).show()
    }


    private fun  takeDateSelected(){
        spinnerDate!!.myOnItemsSelected(object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               Toast.makeText(activity,"you selected ${p0!!.getItemAtPosition(p2)}",Toast.LENGTH_LONG).show()
            }

        })
    }

 private fun takeNumberSelected(){

     spinnerNumbers!!.myOnItemsSelected(object : AdapterView.OnItemSelectedListener{

         override fun onNothingSelected(p0: AdapterView<*>?) {
             numberType = -2
         }

         override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
             var currentPosition = p0!!.getItemAtPosition(p2)
             
             when(currentPosition){
                 0 -> { numberType = currentPosition as Int
                 }
                 1 -> {numberType  = currentPosition as Int }
                 2 -> {numberType  = currentPosition as Int }
                 3 -> {numberType = 3 }
                 4 -> {numberType = 4 }
                 5 -> {numberType = 5 }
                 6 -> {numberType = 6 }
                 7 -> {numberType = 7 }
                 8 -> {numberType = 8 }
                 9 -> {numberType = 9 }

                 else ->{ numberType = -1}
             }
             Toast.makeText(activity,"you choice $numberType ",Toast.LENGTH_SHORT).show()

         }

     })
 }

    private fun Spinner.myOnItemsSelected(listener: OnItemSelectedListener){
        onItemSelectedListener = listener
    }
    /************************** Timer ********************************/
    private fun startTime() {
        val myResultReceiver = MyresultReceiverInner(null)
        timer!!.text = "Click to start "
        timer!!.setOnClickListener({
            var intentP = Intent(activity, MyIntentService::class.java)
            // TODO: pass all time to MyTimerService .
            intentP.putExtra("timer", 5)
            intentP.putExtra("sendReceiver", myResultReceiver)
            activity.startService(intentP)

     })


    }

    private fun readyMethod(){
        startTime()
        takeNumberSelected()
        takeDateSelected()

    }

    /************************* Inner class for ResultReceiver  .. *********************/

    private inner class MyresultReceiverInner(handler: Handler?) : ResultReceiver(handler) {

        override fun onReceiveResult(resultCode: Int, resultData: Bundle?) {

            if (resultCode == 1 && resultData != null) {
                var str = resultData.get("result").toString()
                handler.post(Runnable {
                    kotlin.run {
                        timer!!.text = str
                    }

                })


            } else if (resultCode == 2 && resultData != null) {
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

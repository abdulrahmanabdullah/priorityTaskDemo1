package abdulrahmanjavanrd.com.timelinedemo4.fragments

import abdulrahmanjavanrd.com.timelinedemo4.Model.WorksList
import abdulrahmanjavanrd.com.timelinedemo4.R
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Fragment
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.bar_app_main.view.*
import kotlinx.android.synthetic.main.fragment_card2.*

/**
 * Created by nfs05 on 28/09/2017.
 */
class Card2Fragment:Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var v:View = inflater!!.inflate(R.layout.fragment_card2,container,false)
//       val ad =  MyList(WorksList.getWorkList(),activity)
        var list:ListView = v.findViewById(R.id.list_item_priority)
//        list.adapter = ad
        var o = WorksList()
        var ar:ArrayList<String> =o.getArrayList()
        var listAdapter = ArrayAdapter<String>(activity,R.layout.list_items_layout,ar)
        list.adapter = listAdapter
        return v
    }

    override fun onResume() {

        super.onResume()
    }


}
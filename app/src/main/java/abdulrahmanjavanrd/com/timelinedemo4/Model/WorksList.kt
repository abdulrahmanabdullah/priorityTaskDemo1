package abdulrahmanjavanrd.com.timelinedemo4.Model

import android.util.Log

/**
 * Created by nfs05 on 28/09/2017.
 */
class WorksList {
    var list:ArrayList<String>?=null

    var title:String?=null

    companion object {
        var list = ArrayList<WorksList>()
        fun getWorkList():ArrayList<WorksList>{
            var titles = titlesList()
            for (item in titles.indices){
                var obj = WorksList()
                obj.title = titles[item]
                list.add(obj)
                Log.d("list = ","all list ${obj.title}")
            }
            return list
        }


        // array list to set title ..
         fun titlesList():Array<String>{
            var title = arrayOf("FireBase",
                    "Java9","React","Python","JavaScript"
                    ,"Android","Thread","Android_Security"
            )
            return title
        }

    }

    // this method to get single items
    fun getOneItem(p:Int):String{
        var title = arrayOf("FireBase",
                "Java9","React","Python","JavaScript"
                ,"Android","Thread","Android_Security")
        return title[p]
    }

    fun getArrayList():ArrayList<String>{

        var ar = ArrayList<String>()
        ar.add("FireBase")
        ar.add("Java9")
        ar.add("React")
        ar.add("Python")
        ar.add("JavaScript")
        ar.add("Android_Security")
        ar.add("Thread")
        ar.add("Android")

        return ar
    }
}
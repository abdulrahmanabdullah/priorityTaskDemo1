package abdulrahmanjavanrd.com.timelinedemo4

import abdulrahmanjavanrd.com.timelinedemo4.Intents.ProcessIntent
import abdulrahmanjavanrd.com.timelinedemo4.fragments.Card2Fragment
import abdulrahmanjavanrd.com.timelinedemo4.fragments.card1Fragment
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_layout.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    // toolbar ..
    var toolBar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // toolBar = findViewById(R.id.toolbar_layout)
        setSupportActionBar(toolbar_layout)

        /************************************DrawerLayout***********************************/
        var toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar_layout, R.string.nav_open, R.string.nav_close)
        drawer_layout.addDrawerListener(toggle)
        nav_layout.setNavigationItemSelectedListener(this)
        toggle.syncState()
        /************************************End DrawerLayout***********************************/
        callFragment1()
        callFragment2()
    }

    /************************************DrawerLayout call items***********************************/
    //Drawer func
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.drawer_home->{
                // TODO: return to MainActivity
            }
            R.id.drawer_process->{

                // TODO: call Fragment 1 . by using Intent .
                var processIntent = Intent(this@MainActivity,ProcessIntent::class.java)
                startActivity(processIntent)

            }

            R.id.done_process->{
                //TODO: call fragment 3 -> to show all process w've done .
            }

            R.id.sync_process->{
                // TODO: sync all list .
            }
            R.id.exit->{
                // TODO: Exit app .
                finish()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    // when select item the drawer should gone .
        override fun onBackPressed(){
        if(drawer_layout.isDrawerOpen(Gravity.START)){
            drawer_layout.closeDrawer(Gravity.START)
        }else {
            super.onBackPressed()
        }
    }


    /************************************End onNavigation ***********************************/

    /************************************ Menu ***********************************/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.setting_btn->{
                //TODO: open page setting of my app .
            }

        else->{
            // Do SomeThing
        }
        }
        return true
    }
    /************************************End Menu ***********************************/



    /************************************Fragment 1 ***********************************/
    // call fragment of card 1 ... Done
    private fun callFragment1() {
//        var intent = Intent(this,MyTimerService::class.java)
//        intent.putExtra("startServiec","start")
//        startService(intent)
        var frag = card1Fragment()
        var manger = fragmentManager
        var tran = manger.beginTransaction()
        tran.add(R.id.frag_card1_layout, frag, "1")
        tran.commit()

    }
    /************************************End Fragment 1 ***********************************/


    /************************************Fragment 2 ***********************************/
    // call fragment of card 1 ... Done
    private fun callFragment2() {
        var frag = Card2Fragment()
        var manger = fragmentManager
        var tran = manger.beginTransaction()
        tran.add(R.id.frag_card2_layout, frag, "2")
        tran.commit()

    }
    /************************************End Fragment 2 ***********************************/
}

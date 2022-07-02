package com.example.tour_guide_nepal

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tour_guide_nepal.adapter.ViewPagerAdapter
import com.example.tour_guide_nepal.fragments.AboutUsFragment
import com.example.tour_guide_nepal.fragments.ProfileFragment
import com.example.tour_guide_nepal.fragments.Select_cityFragment
import com.example.tour_guide_nepal.fragments.Selectplaces
import com.example.tour_guide_nepal.hotel.HotelBookingInfo
import com.example.tour_guide_nepal.hotel.Hotelbooking_Activity

import com.example.tour_guide_nepal.notification.NotificationChannels
import com.example.tour_guide_nepal.termsandservices.termsandconditions
import com.example.tour_guide_nepal.vehicle.Updatevehiclebooking_activity
import com.example.tour_guide_nepal.vehicle.ViewVehicleRent

import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val permissions = arrayOf(
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.READ_EXTERNAL_STORAGE
    )

    private var counter = 0L

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var lstTitle: ArrayList<String>
    private lateinit var lstFragments: ArrayList<Fragment>
    private lateinit var viewpager2: ViewPager2
    private lateinit var tablayout: TabLayout
    private lateinit var nav_rateapp: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager2 = findViewById(R.id.viewpager)
        tablayout = findViewById(R.id.tablayout)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer)
        val navView: NavigationView = findViewById(R.id.navmenu)

        // check for permission
        if (!hasPermission()) {
            requestPermission()
        }

        populateList()
        val adapter = ViewPagerAdapter(lstFragments, supportFragmentManager, lifecycle)
        viewpager2.adapter = adapter
        TabLayoutMediator(tablayout, viewpager2) { tab, position ->
            tab.text = lstTitle[position]
        }.attach()

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                }

                R.id.nav_select_city -> {
                    startActivity(Intent(this, Selectplaces::class.java))
                }
                R.id.nav_bookhotel -> {
                    startActivity(Intent(this, Hotelbooking_Activity::class.java))
                }
                R.id.nav_viewbookhotel -> {

                    startActivity(Intent(this, HotelBookingInfo::class.java))
                }
                R.id.nav_contact -> {
 
                    startActivity(Intent(this,Emergency_contact_activity::class.java))
                }
                R.id.nav_terms -> {
                    startActivity(Intent(this,termsandconditions::class.java))
                }
                R.id.nav_viewvehiclerent -> {
                    startActivity(Intent(this, ViewVehicleRent::class.java))
                }
                R.id.nav_rateapp -> {
                    startActivity(Intent(this,RateApp::class.java))
 
                }
                R.id.nav_logout -> {

                    logout()
                }
            }

            true

        }

    }

    override fun onBackPressed() {

        if (counter + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
            finish()
        }
        else {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
        }
        counter = System.currentTimeMillis()
    }


    private fun logout() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Log Out!!")
        builder.setMessage("Are you sure do you want to Logout ?")
        builder.setIcon(android.R.drawable.ic_dialog_alert)
        builder.setPositiveButton("Yes") {_,_ ->
            userlogout()
        }
        builder.setNegativeButton("No") {_,_ ->
            Toast.makeText(this,"Cancelled", Toast.LENGTH_SHORT).show()
        }
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    private fun userlogout() {
        val sharedPref=this?.getPreferences(Context.MODE_PRIVATE)?:return
        val editsharedPref = this.getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
        val editor = editsharedPref.edit()
        editor.clear()
        editor.apply()

        sharedPref.edit().remove("Email").apply()
        var intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
        logoutnotification()
    }

    private fun logoutnotification() {
        val notificationManager = NotificationManagerCompat.from(this)

        val notificationChannels = NotificationChannels(this)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(this, notificationChannels.channel_2)
            .setSmallIcon(R.drawable.notification)
            .setContentTitle("Tour Guide Nepal")
            .setContentText("See you again...")
            .setColor(Color.BLUE)
            .build()

        notificationManager.notify(2, notification)
 
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this@MainActivity,
            permissions, 1
        )
    }

    private fun hasPermission(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    permission
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                hasPermission = false
            }
        }
        return hasPermission
    }

    private fun populateList() {
        lstTitle = ArrayList<String>()
        lstTitle.add("Home")
        lstTitle.add("Profile")
        lstTitle.add("About Us")
        lstFragments = ArrayList<Fragment>()
        lstFragments.add(Select_cityFragment())
        lstFragments.add(ProfileFragment())
        lstFragments.add(AboutUsFragment())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {

            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
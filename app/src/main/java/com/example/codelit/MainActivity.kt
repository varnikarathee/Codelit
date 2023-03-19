package com.example.codelit

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.codelit.Fragments.CodeFragment
import com.example.codelit.Fragments.HomeFragment
import com.example.codelit.Fragments.ProfileFragment
import com.example.codelit.Fragments.SearchFragment
import com.example.codelit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding



    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
             moveTofragment(HomeFragment())
                return@OnNavigationItemSelectedListener true

            }
            R.id.navigation_search -> {
                moveTofragment(SearchFragment())
                return@OnNavigationItemSelectedListener true


            }
            R.id.navigation_add -> {

//                item.isChecked = false
//                startActivity(Intent(this@MainActivity, AddPostActivity::class.java))
        return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_code-> {

                moveTofragment(CodeFragment())
                return@OnNavigationItemSelectedListener true


            }
            R.id.navigation_profile-> {


                moveTofragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true


            }
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //remove the actionbar , window function
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
       //to make home fragment firstscreen
        moveTofragment(HomeFragment())


//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)


    }


    private fun moveTofragment(fragement: Fragment){
        val fragmentTrans= supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container,fragement)
        fragmentTrans.commit()
    }
}
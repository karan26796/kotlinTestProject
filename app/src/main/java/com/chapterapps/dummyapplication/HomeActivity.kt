package com.chapterapps.dummyapplication

import android.os.Bundle
import android.view.View
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.bottom_navigation.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.navigation -> return
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FragmentHome(), "")
                        .commit()
                message!!.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment(), "")
                        .commit()
                message!!.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ChipGroupDemoFragment(), "")
                        .commit()
                message!!.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, FragmentHome(), "")
                    .commit()


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        //navigation.setOnClickListener(this)
    }

}

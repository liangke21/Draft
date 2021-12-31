package com.example.mybottomsheetstate
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mybottomsheetstate.databinding.ActivityMain2Binding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
  private lateinit var navView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        navView = binding.layout.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main2)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val behavior1 = BottomSheetBehavior.from(findViewById(R.id.ll_content_bottom_sheet))


        val behavior2=BottomSheetBehavior.from(findViewById(R.id.bottom_sheet_behavior2))
         behavior2.state=STATE_EXPANDED

        navView.setOnNavigationItemSelectedListener { item ->
             when (item.itemId) {
                 R.id.navigation_home -> {
                     behavior1.state = STATE_EXPANDED
                     behavior2.state= STATE_COLLAPSED
                 }
             }
             true
         }
        behavior1.addBottomSheetCallback(object: BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {
             Log.e("onStateChanged",newState.toString())

                when(newState){
                   STATE_COLLAPSED->{
                        behavior2.state=STATE_EXPANDED
                    }
                }
            }
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })
    }
}
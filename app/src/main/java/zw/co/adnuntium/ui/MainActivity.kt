package zw.co.adnuntium.ui

import android.os.Bundle
import android.util.AttributeSet
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import dagger.hilt.android.AndroidEntryPoint
import zw.co.adnuntium.R
import zw.co.adnuntium.databinding.ActivityMainBinding
import zw.co.adnuntium.utils.categories

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initChips()

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun initChips(){
        val flexBox = binding.flexiBox
        for (category in categories){
            val chip = Chip(this)
            val layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            layoutParams.marginEnd = 8
            chip.layoutParams =layoutParams
            val drawable = ChipDrawable.createFromAttributes(this, null, 0, R.style.Base_Theme_MaterialComponents_Light)
            chip.setChipDrawable(drawable)
            chip.setChipBackgroundColorResource(R.color.spring_green)
            chip.text = category
            chip.setOnClickListener {

            }
            flexBox.addView(chip)
        }
    }
}
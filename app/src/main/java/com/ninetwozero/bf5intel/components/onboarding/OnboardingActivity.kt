package com.ninetwozero.bf5intel.components.onboarding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.ninetwozero.bf5intel.R

class OnboardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_activity)

        val navHost: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.onboardin_nav_host_fragment) as NavHostFragment?
                ?: return
    }
}

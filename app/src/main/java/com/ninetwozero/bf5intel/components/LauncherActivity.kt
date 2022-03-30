package com.ninetwozero.bf5intel.components

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ninetwozero.bf5intel.BfVApplication
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.components.onboarding.OnboardingActivity
import com.ninetwozero.bf5intel.components.onboarding.viewmodels.SettingsViewModel
import com.ninetwozero.bf5intel.components.onboarding.viewmodels.SettingsViewModelFactory
import com.ninetwozero.bf5intel.repository.SettingsRepository

class LauncherActivity : AppCompatActivity() {

    private val settingsViewModel: SettingsViewModel by viewModels {
        SettingsViewModelFactory(SettingsRepository(BfVApplication.getDatabase().settingsDao()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launcher_activity)

        Handler(Looper.getMainLooper()).postDelayed({
            openNextScreen()
        }, 3000)

    }

    private fun openNextScreen() {
        //TODO need to check on conditional navigation to skip onboarding if settings populated and solder available
        //https://developer.android.com/guide/navigation/navigation-conditional
        //TODO("Implement DB check to see if this is first launch and user need to select language")
        startActivity(
            Intent(
                this,
                if (settingsViewModel.settings.value === null) OnboardingActivity::class.java else MainActivity::class.java
            )
        )
        finish()
    }
}

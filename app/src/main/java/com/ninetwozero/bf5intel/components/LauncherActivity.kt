package com.ninetwozero.bf5intel.components

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.components.onboarding.OnboardingActivity

class LauncherActivity : AppCompatActivity() {

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
        startActivity(Intent(this, if(true) OnboardingActivity::class.java else MainActivity::class.java))
        finish()
    }
}

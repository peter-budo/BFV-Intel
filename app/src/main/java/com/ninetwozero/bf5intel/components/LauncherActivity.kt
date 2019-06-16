package com.ninetwozero.bf5intel.components

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.components.localization.SetupActivity

class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.launcher_activity)

        val delay = Handler()
        delay.postDelayed({openNextScreen()}, 3000)

    }

    private fun openNextScreen() {
        //TODO("Implement DB check to see if this is first launch and user need to select language")
        startActivity(Intent(this, if(true) SetupActivity::class.java else MainActivity::class.java))
        finish()
    }
}

package com.ninetwozero.bf5intel.components.localization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.components.localization.fragments.LanguageFragment

class SetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LanguageFragment.newInstance())
                .commitNow()
        }
    }

}

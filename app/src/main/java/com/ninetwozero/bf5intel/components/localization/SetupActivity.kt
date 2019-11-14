package com.ninetwozero.bf5intel.components.localization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.components.localization.fragments.LanguageFragment
import com.ninetwozero.bf5intel.components.localization.fragments.PermissionsFragment

class SetupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_activity)
        if (savedInstanceState == null) {
            showScreen(R.layout.language_fragment)
        }
    }


    fun showScreen(@LayoutRes layoutId: Int) {
        val fragmentToOpen: Fragment = when(layoutId) {
            R.layout.language_fragment -> LanguageFragment.newInstance()
            R.layout.permissions_fragment -> PermissionsFragment.newInstance()
            else -> Fragment() //FIXME
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragmentToOpen)
            .commitNow()
    }
}

package com.ninetwozero.bf5intel.components.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ninetwozero.bf5intel.R


class PermissionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.permissions_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val safeArgs: PermissionsFragmentArgs by navArgs()
        val languageCode = safeArgs.selectedLanguageCode

        val analyticsToggle = view.findViewById<SwitchCompat>(R.id.permission_switch)

        view.findViewById<Button>(R.id.finish_btn).setOnClickListener {
            savePermissions(languageCode, analyticsToggle.isChecked)

            launchMainActivity()
        }
    }

    private fun savePermissions(languageCode: String, analyticsAllowed: Boolean) {
        //TODO("Not yet implemented")
    }

    private fun launchMainActivity() {
        //TODO need to check on conditional navigation to skip onboarding if settings populated and solder available
        val directions = PermissionsFragmentDirections.navigateToMainActivity("")
        findNavController().navigate(directions)
    }
}
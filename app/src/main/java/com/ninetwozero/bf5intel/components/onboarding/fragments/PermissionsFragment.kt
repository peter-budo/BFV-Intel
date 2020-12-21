package com.ninetwozero.bf5intel.components.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ninetwozero.bf5intel.BfVApplication
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.components.onboarding.viewmodels.SettingsViewModel
import com.ninetwozero.bf5intel.components.onboarding.viewmodels.SettingsViewModelFactory
import com.ninetwozero.bf5intel.databinding.PermissionsFragmentBinding
import com.ninetwozero.bf5intel.repository.SettingsRepository
import com.ninetwozero.bf5intel.repository.storage.entity.Settings
import com.ninetwozero.bf5intel.viewbinding.viewBinding


class PermissionsFragment : Fragment() {

    private val binding: PermissionsFragmentBinding by viewBinding(PermissionsFragmentBinding::bind)

    private val settingsViewModel: SettingsViewModel by viewModels {
        SettingsViewModelFactory(SettingsRepository(BfVApplication.getDatabase().settingsDao()))
    }

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

        binding.finishBtn.setOnClickListener {
            savePermissions(languageCode, analyticsToggle.isChecked)

            launchMainActivity()
        }
    }

    private fun savePermissions(languageCode: String, analyticsAllowed: Boolean) {
        settingsViewModel.insert(Settings(position = 1, language = languageCode, analyticsPermission = analyticsAllowed, selectedSoldier = ""))
    }

    private fun launchMainActivity() {
        val directions = PermissionsFragmentDirections.navigateToMainActivity("")
        findNavController().navigate(directions)
    }
}
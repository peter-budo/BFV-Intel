package com.ninetwozero.bf5intel.components.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.databinding.FindSoldierFragmentBinding
import com.ninetwozero.bf5intel.viewbinding.viewBinding

class FindSoldierFragment : Fragment() {

    private val binding: FindSoldierFragmentBinding by viewBinding(FindSoldierFragmentBinding::bind)

    private val soldierInputLayout: TextInputLayout
        get() = binding.soldierInputLayout

    private val soldierNameInput: TextInputEditText
        get() = binding.soldierNameInput

    private val dropdown: TextInputLayout
        get() = binding.platformDropdown

    private val findSoldierBtn: MaterialButton
        get() = binding.findSoldierBtn

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.find_soldier_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireContext().let {
            ArrayAdapter.createFromResource(it, R.array.platform_options, R.layout.spinner_item)
                .also { adapter ->
                    adapter.setDropDownViewResource(R.layout.spinner_item)
                    (dropdown.editText as? AutoCompleteTextView)?.setAdapter(adapter)
                }
        }

        findSoldierBtn.setOnClickListener {
            val soldierName = soldierNameInput.text.toString()
            val platformName = dropdown.editText?.text.toString()
            if (validateName(soldierName) && validatePlatform(platformName)) {
                Toast.makeText(requireContext(), "Make network call", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateName(soldierName: String): Boolean {
        return if (soldierName.isEmpty()) {
            soldierInputLayout.error = getString(R.string.error_enter_soldier_name)
            false
        } else {
            soldierInputLayout.error = null
            true
        }
    }

    private fun validatePlatform(platformName: String): Boolean {
        return if (platformName.isEmpty()) {
            dropdown.error = getString(R.string.error_select_platform)
            false
        } else {
            dropdown.error = null
            true
        }
    }
}
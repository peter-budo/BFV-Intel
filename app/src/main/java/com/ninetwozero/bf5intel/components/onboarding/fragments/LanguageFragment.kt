package com.ninetwozero.bf5intel.components.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ninetwozero.bf5intel.R

class LanguageFragment : Fragment() {

    private lateinit var spinner: AppCompatSpinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.language_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner = requireView().findViewById(R.id.language_spinner)
        requireContext().let {
            ArrayAdapter.createFromResource(it, R.array.settings_languages, R.layout.spinner_item)
                .also { adapter ->
                    adapter.setDropDownViewResource(R.layout.spinner_item)
                    spinner.adapter = adapter
                }
        }

        view.findViewById<Button>(R.id.language_next_btn)?.setOnClickListener {
            val langCode = resources.getStringArray(R.array.settings_languages_codes)[spinner.selectedItemPosition]
            val action = LanguageFragmentDirections.nextAction(langCode)
            findNavController().navigate(action)
        }
    }
}

package com.ninetwozero.bf5intel.components.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.databinding.LanguageFragmentBinding
import com.ninetwozero.bf5intel.viewbinding.viewBinding

class LanguageFragment : Fragment() {

    private val binding: LanguageFragmentBinding by viewBinding(LanguageFragmentBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.language_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireContext().let {
            ArrayAdapter.createFromResource(it, R.array.settings_languages, R.layout.spinner_item)
                .also { adapter ->
                    adapter.setDropDownViewResource(R.layout.spinner_item)
                    binding.languageSpinner.adapter = adapter
                }
        }

        binding.languageNextBtn.setOnClickListener {
            val langCode = resources.getStringArray(R.array.settings_languages_codes)[binding.languageSpinner.selectedItemPosition]
            val action = LanguageFragmentDirections.nextAction(langCode)
            findNavController().navigate(action)
        }
    }
}

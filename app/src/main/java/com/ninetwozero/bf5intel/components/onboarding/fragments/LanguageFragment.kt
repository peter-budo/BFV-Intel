package com.ninetwozero.bf5intel.components.onboarding.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ninetwozero.bf5intel.R

class LanguageFragment : Fragment(), AdapterView.OnItemSelectedListener {

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
        context?.let {
            ArrayAdapter.createFromResource(it, R.array.settings_languages, R.layout.spinner_item)
                .also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    spinner.adapter = adapter
                }
        }

        view.findViewById<View>(R.id.language_next_btn).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.next_action)
        )
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //do nothing
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, index: Int, id: Long) {
        TODO("not implemented, DB store locale preference for network calls")
    }
}

package com.ninetwozero.bf5intel.components.localization.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.button.MaterialButton
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.components.localization.viewmodels.LanguageViewModel

class LanguageFragment : Fragment(), AdapterView.OnItemSelectedListener {

    companion object {
        fun newInstance() = LanguageFragment()
    }

    private lateinit var viewModel: LanguageViewModel
    private lateinit var spinner: AppCompatSpinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.language_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(LanguageViewModel::class.java)
        // TODO: Use the ViewModel

        spinner = view!!.findViewById(R.id.settings_language_spinner)
        ArrayAdapter.createFromResource(context, R.array.settings_languages, android.R.layout.simple_spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
            }

        val nextBtn : MaterialButton = view!!.findViewById(R.id.settings_language_btn)
        nextBtn.setOnClickListener{
            TODO("Go next screen for Analytics permissions")
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //do nothing
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, index: Int, id: Long) {
        TODO("not implemented, DB store locale preference for network calls")
    }
}

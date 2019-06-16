package com.ninetwozero.bf5intel.components.localization.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.components.localization.viewmodels.LanguageViewModel

class LanguageFragment : Fragment() {

    companion object {
        fun newInstance() = LanguageFragment()
    }

    private lateinit var viewModel: LanguageViewModel

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
    }

}

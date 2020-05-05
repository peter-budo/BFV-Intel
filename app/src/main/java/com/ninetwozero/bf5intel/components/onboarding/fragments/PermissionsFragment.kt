package com.ninetwozero.bf5intel.components.onboarding.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ninetwozero.bf5intel.R
import com.ninetwozero.bf5intel.components.MainActivity


class PermissionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.permissions_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.finish_btn).setOnClickListener {
            //savePermissions()

            launchMainActivity()
        }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        Log.e("PermissionFragment", "PermissionFragment onAttach called")
    }

    private fun savePermissions() {
        TODO("Not yet implemented")
    }

    private fun launchMainActivity() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)

        activity?.finish()
    }
}
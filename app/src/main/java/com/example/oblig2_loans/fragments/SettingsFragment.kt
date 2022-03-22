package com.example.oblig2_loans.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import com.example.oblig2_loans.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity?)!!.getSupportActionBar()!!.hide()
    }

    override fun onPause() {
        super.onPause()
        (activity as AppCompatActivity?)!!.getSupportActionBar()!!.show()
    }
}
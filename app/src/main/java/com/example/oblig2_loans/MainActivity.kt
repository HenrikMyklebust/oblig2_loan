package com.example.oblig2_loans

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import com.example.oblig2_loans.fragments.MainFragment
import com.example.oblig2_loans.fragments.SettingsFragment
import com.example.oblig2_loans.viewmodels.LoanViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val settingsFragment = SettingsFragment()
        when (item.itemId) {
            R.id.miSettings -> supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainerView, settingsFragment)
                addToBackStack(null)
                commit()
            }
        }
        return true
    }
}
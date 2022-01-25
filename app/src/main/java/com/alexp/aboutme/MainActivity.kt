package com.alexp.aboutme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.fragment.app.FragmentContainerView
import com.alexp.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            handleBottomNavigation(it.itemId)
        }

        binding.bottomNavigation.selectedItemId = R.id.menu_bio
    }

    private fun handleBottomNavigation(
            menuItemId: Int
    ): Boolean = when (menuItemId) {
        R.id.menu_bio -> {
            swapFragments(BioFragment())
            true
        }
        R.id.menu_family -> {
            swapFragments(FamilyFragment())
            true
        }
        R.id.menu_hobbies -> {
            swapFragments(HobbiesFragment())
            true
        }
        else -> false
    }

    private fun swapFragments(
            fragment: Fragment
    ) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }
}
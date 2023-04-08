package com.example.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.NightMode
import com.example.sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initWidgets()
    }

    private fun initWidgets() {

        setThemeText()

        binding.submitButton.setOnClickListener {
            switchTheme()
        }
    }

    private fun setThemeText() {

        if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM ||
            AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_UNSPECIFIED) {

            binding.themeHeader.setText(R.string.select_theme_auto)
        }
        else {

            binding.themeHeader.setText(R.string.select_theme)
        }
    }

    private fun switchTheme() {

        @NightMode
        var mode: Int = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

        when(binding.themeLayout.checkedRadioButtonId) {

            binding.night.id -> {
                mode = AppCompatDelegate.MODE_NIGHT_YES
            }

            binding.day.id -> {
                mode = AppCompatDelegate.MODE_NIGHT_NO
            }
        }

        AppCompatDelegate.setDefaultNightMode(mode)

        setThemeText()
    }
}
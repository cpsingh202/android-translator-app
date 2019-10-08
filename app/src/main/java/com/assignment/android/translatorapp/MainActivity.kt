package com.assignment.android.translatorapp

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.assignment.android.translatorapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), AppEventListener {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.run {
            listener = this@MainActivity
        }
    }


    override fun onHindiSelected() {
        val locale = Locale("hi")
        setLocale(locale)
        this.recreate()
    }

    override fun onEnglishSelected() {
        val locale = Locale("en")
        setLocale(locale)
        this.recreate()
    }

    override fun onChineseSelected() {
        val locale = Locale("zh")
        setLocale(locale)
        this.recreate()
    }


    private fun setLocale(locale: Locale) {
        val resources = resources
        val configuration = resources.configuration
        val displayMetrics = resources.displayMetrics
        configuration.setLocale(locale)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            applicationContext.createConfigurationContext(configuration)
        } else {
            resources.updateConfiguration(configuration, displayMetrics)
        }
    }
}

interface AppEventListener {
    fun onHindiSelected()
    fun onEnglishSelected()
    fun onChineseSelected()
}
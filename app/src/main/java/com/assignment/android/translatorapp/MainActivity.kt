package com.assignment.android.translatorapp

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.assignment.android.translatorapp.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity(), AppEventListener {

    lateinit var binding: ActivityMainBinding
    lateinit var mLanguage: String


    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(BaseApp.localeManager.setLocale(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )

        binding.run {
            listener = this@MainActivity
        }

        mLanguage = Locale.getDefault().language
        showData()
    }

    private fun showData() {
        if (Utils.languageData != null) {
            binding.run {
                Utils.getViewText(tvMessage.getKey(), mLanguage)?.let { tvMessage.text = it }
            }
        }
    }


    override fun onHindiSelected() {
        BaseApp.localeManager.setNewLocale(this, LocaleManager.LANGUAGE_HINDI)
        recreate()
    }

    override fun onEnglishSelected() {
        BaseApp.localeManager.setNewLocale(this, LocaleManager.LANGUAGE_ENGLISH)
        recreate()
    }

    override fun onChineseSelected() {
        BaseApp.localeManager.setNewLocale(this, LocaleManager.LANGUAGE_CHINESE)
        recreate()
    }
}


interface AppEventListener {
    fun onHindiSelected()
    fun onEnglishSelected()
    fun onChineseSelected()
}
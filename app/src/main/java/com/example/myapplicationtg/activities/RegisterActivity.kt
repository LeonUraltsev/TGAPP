package com.example.myapplicationtg.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.example.myapplicationtg.R
import com.example.myapplicationtg.databinding.ActivityRegisterBinding
import com.example.myapplicationtg.ui.fragments.EnterPhoneFragment
import com.example.myapplicationtg.utilits.initFirebase
import com.example.myapplicationtg.utilits.replaceActivity
import com.example.myapplicationtg.utilits.replaceFragment

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFirebase()
    }

    override fun onStart() {
        super.onStart()
        toolbar = binding.registerToolbar
        setSupportActionBar(toolbar)
        title = getString(R.string.register_title_your_phone)
        replaceFragment(EnterPhoneFragment(),false)

    }
}
package com.example.myapplicationtg

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myapplicationtg.activities.RegisterActivity
import com.example.myapplicationtg.databinding.ActivityMainBinding
import com.example.myapplicationtg.ui.fragments.ChatsFragment
import com.example.myapplicationtg.ui.objects.AppDrawer
import com.example.myapplicationtg.utilits.AUTH
import com.example.myapplicationtg.utilits.initFirebase
import com.example.myapplicationtg.utilits.replaceActivity
import com.example.myapplicationtg.utilits.replaceFragment
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appDrawer: AppDrawer
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initFields()
        initFunc()
    }

    //функция отвечающая за функциональность
    private fun initFunc() {
        if(AUTH.currentUser != null){
            setSupportActionBar(toolbar)
            appDrawer.create()
            replaceFragment(ChatsFragment(),false)
        }else{
            replaceActivity(RegisterActivity())
        }

    }

    //функция отвечающая за инициализацию полей
    private fun initFields() {
        toolbar = binding.mainToolbar
        appDrawer = AppDrawer(this, this.toolbar)
        initFirebase()
    }
}
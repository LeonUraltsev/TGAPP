package com.example.myapplicationtg

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.myapplicationtg.activities.RegisterActivity
import com.example.myapplicationtg.databinding.ActivityMainBinding
import com.example.myapplicationtg.ui.fragments.ChatsFragment
import com.example.myapplicationtg.ui.objects.AppDrawer

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
        if(false){
            setSupportActionBar(toolbar)
            appDrawer.create()
            supportFragmentManager.beginTransaction()
                .replace(R.id.dataContainer, ChatsFragment()).commit()
        }else{
            val intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }

    }

    //функция отвечающая за инициализацию полей
    private fun initFields() {
        toolbar = binding.mainToolbar
        appDrawer = AppDrawer(this, this.toolbar)
    }
}
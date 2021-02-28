package com.example.myapplicationtg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.myapplicationtg.databinding.ActivityMainBinding
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: Toolbar
    private lateinit var drawer: Drawer
    private lateinit var header: AccountHeader


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
        setSupportActionBar(toolbar)
        createHeader()
        createDrawer()
    }

    //Создание Navigation Drawer
    private fun createDrawer() {
        drawer = DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withSelectedItem(-1)
                .withAccountHeader(header)
                .addDrawerItems(
                        PrimaryDrawerItem()
                                .withIdentifier(100)
                                .withIconTintingEnabled(true)
                                .withName("Create group")
                                .withIcon(R.drawable.ic_menu_create_groups)
                                .withSelectable(false),
                        PrimaryDrawerItem()
                                .withIdentifier(101)
                                .withIconTintingEnabled(true)
                                .withName("Create secret chat")
                                .withIcon(R.drawable.ic_menu_secret_chat)
                                .withSelectable(false),
                        PrimaryDrawerItem()
                                .withIdentifier(102)
                                .withIconTintingEnabled(true)
                                .withName("Create channel")
                                .withIcon(R.drawable.ic_menu_create_channel)
                                .withSelectable(false),
                        PrimaryDrawerItem()
                                .withIdentifier(103)
                                .withIconTintingEnabled(true)
                                .withName("Contacts")
                                .withIcon(R.drawable.ic_menu_contacts)
                                .withSelectable(false),
                        PrimaryDrawerItem()
                                .withIdentifier(104)
                                .withIconTintingEnabled(true)
                                .withName("Call")
                                .withIcon(R.drawable.ic_menu_phone)
                                .withSelectable(false),
                        PrimaryDrawerItem()
                                .withIdentifier(105)
                                .withIconTintingEnabled(true)
                                .withName("Favorites")
                                .withIcon(R.drawable.ic_menu_favorites)
                                .withSelectable(false),
                        PrimaryDrawerItem()
                                .withIdentifier(106)
                                .withIconTintingEnabled(true)
                                .withName("Settings")
                                .withIcon(R.drawable.ic_menu_settings)
                                .withSelectable(false),
                        DividerDrawerItem(),
                        PrimaryDrawerItem()
                                .withIdentifier(107)
                                .withIconTintingEnabled(true)
                                .withName("Invite friends")
                                .withIcon(R.drawable.ic_menu_invate)
                                .withSelectable(false),
                        PrimaryDrawerItem()
                                .withIdentifier(107)
                                .withIconTintingEnabled(true)
                                .withName("Help")
                                .withIcon(R.drawable.ic_menu_help)
                                .withSelectable(false)
                ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener {
                    override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*>): Boolean {
                        Toast.makeText(applicationContext,position.toString(),Toast.LENGTH_SHORT).show()
                        return false
                    }
                })
                .build()
    }

    //Создание заголовка для Navigation Drawer
    private fun createHeader() {
        header = AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .addProfiles(
                        ProfileDrawerItem()
                                .withName("Leonid Uraltsev")
                                .withEmail("uraltsev@gmail.com")

                ).build()
    }

    //функция отвечающая за инициализацию полей
    private fun initFields() {
        toolbar = binding.mainToolbar
    }
}
package com.dmi.lessontwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var menuList = ArrayList<String>(arrayListOf("Hamburger", "Pizza","Mexican", "American", "Chinese"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnAdd.setOnClickListener {addDinner()}
        btnDecide.setOnClickListener{decideDinner()}
    }

    private fun addDinner(){

        val name = foodNameTxt.text
        if(name.toString().isEmpty()){
           Toast.makeText(applicationContext,"please enter a name",Toast.LENGTH_LONG).show()
            foodNameTxt.requestFocus()
        }
        else{
            menuList.add(name.toString())
            dinnerText.setText(menuList.get(menuList.size-1))
            foodNameTxt.text.clear()
        }

    }
    private fun decideDinner( ){
        val random = (0 until menuList.size).random() //the last number will be excluded, No out of range exception
        dinnerText.setText(menuList.get(random))
    }

}
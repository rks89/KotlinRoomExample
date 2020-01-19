package com.rajnish.kotlinroomexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.rajnish.roomdbkotlin.AppDatabase
import com.rajnish.roomdbkotlin.User
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var db= Room.databaseBuilder(applicationContext, AppDatabase::class.java,"loginDB").allowMainThreadQueries().build()

        doAsync{

            val bill = User(uid = 6001, firstName = "qwasxeqeq" , lastName="qweq12wsc weqwe")

            AppDatabase.getInstance(this@MainActivity).userDao().insertAll(bill)


            val customers = AppDatabase.getInstance(this@MainActivity).userDao().all
            //Toast.makeText(this@MainActivity,"Hello"+customers.get(0),Toast.LENGTH_LONG).show()
            for(item in customers){
                println("Hello Information ${item.firstName}")
                println("Hello Information ${item.uid}")

            }
        }
    }
}

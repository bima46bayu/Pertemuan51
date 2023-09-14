package com.example.pertemuan51

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pertemuan51.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivityLifecycle"

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {
            btnToSecond.setOnClickListener{
                val intentSecondActivity = Intent(this@MainActivity,SecondActivity::class.java)

                startActivity(intentSecondActivity)
            }
        }
        Log.d(TAG, "onCreate dipanggil")
    }

    override fun onStart(){
        super.onStart()
        Log.d(TAG, "onStart dipangggil")
    }

    override fun onResume(){
        super.onResume()
        Log.d(TAG, "onResume dipangggil")
    }

    override fun onPause(){
        super.onPause()
        Log.d(TAG, "onPause dipangggil")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop dipanggil")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG, "onDestroy dipangggil")
    }
}
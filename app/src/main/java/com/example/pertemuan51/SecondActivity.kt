package com.example.pertemuan51

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.os.PersistableBundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan51.MainActivity.Companion.EXTRA_NAME
import com.example.pertemuan51.ThirdActivity.Companion.EXTRA_ADDRESS
import com.example.pertemuan51.databinding.ActivityMainBinding
import com.example.pertemuan51.databinding.ActivitySecondBinding

class SecondActivity() : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if (result.resultCode == RESULT_OK) {
            val data = result.data

            val name = data?.getStringExtra(EXTRA_NAME)
            val address = data?.getStringExtra(EXTRA_ADDRESS)

            binding.textName.text = "Hello $name di $address"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)
        with(binding) {
            textName.text = "Hello $name"

            btnToThird.setOnClickListener {
                val intentThirdActivity = Intent(this@SecondActivity, ThirdActivity::class.java)
                    .apply { putExtra(EXTRA_NAME, name) }



                startActivity(intentThirdActivity)
                launcher.launch(intentThirdActivity)
            }

        }
    }
}


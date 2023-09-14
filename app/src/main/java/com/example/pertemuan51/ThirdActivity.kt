package com.example.pertemuan51

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pertemuan51.MainActivity.Companion.EXTRA_NAME
import com.example.pertemuan51.databinding.ActivitySecondBinding
import com.example.pertemuan51.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding : ActivityThirdBinding
    companion object {
        const val EXTRA_ADDRESS = "extra_address"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(EXTRA_NAME)

        with(binding) {
            btnDismiss.setOnClickListener {
                val intent = Intent()
                intent.putExtra(EXTRA_NAME, name)

                val address = addRess.text.toString()
                intent.putExtra(EXTRA_ADDRESS, address)

                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}
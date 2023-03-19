package com.example.codelit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.codelit.databinding.ActivityIntroBinding
import com.example.codelit.databinding.ActivityMainBinding

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener{
            startActivity(Intent(this,LoginActivity::class.java ))
        }

        binding.button2.setOnClickListener{
            startActivity(Intent(this,SignupActivity::class.java ))
        }


    }
}
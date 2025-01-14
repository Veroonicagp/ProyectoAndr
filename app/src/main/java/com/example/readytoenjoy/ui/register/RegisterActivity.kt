package com.example.readytoenjoy.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.readytoenjoy.databinding.ActivityRegisterBinding
import com.example.readytoenjoy.ui.MainActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.regBttn.setOnClickListener(){
            val name = binding.registerName.text.toString()
            val surname = binding.registerSurname.text.toString()
            val email = binding.registerEmail.text.toString()
            val password = binding.registerPasword.text.toString()
            val rePasword = binding.registerRePasword.text.toString()
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
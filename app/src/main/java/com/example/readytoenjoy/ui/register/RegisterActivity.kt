package com.example.readytoenjoy.ui.register

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.readytoenjoy.databinding.ActivityRegisterBinding
import com.example.readytoenjoy.ui.MainActivity
import com.example.readytoenjoy.ui.login.LoginActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private val vm: RegisterViewModel by viewModels()
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                vm.user.collect{uiState ->
                    when(uiState){
                        is UiState.Started -> {}
                        is UiState.Error ->{

                        }
                        is UiState.Success->{
                            val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish()
                        }

                        is UiState.Loading -> {}
                    }
                }
            }
        }

        binding.regBttn.setOnClickListener(){
            val name = binding.registerName.text.toString()
            val surname = binding.registerSurname.text.toString()
            val email = binding.registerEmail.text.toString()
            val password = binding.registerPasword.text.toString()
            val rePasword = binding.registerRePasword.text.toString()
            if (email.isNullOrBlank()){
                binding.emailTF.error = "Introduzca email"
            }else {
                vm.register(name,surname,email,password)
            }
            }
            //val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            //startActivity(intent)
            //finish()
        }

    }

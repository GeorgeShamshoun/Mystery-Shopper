package com.example.mysteryshopper.Activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.mysteryshopper.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        WindowCompat.setDecorFitsSystemWindows( window, false)
        window.statusBarColor = Color.TRANSPARENT
        setContentView(binding.root)

        binding.edtUsername.setText(getSharedPreferences("LogInFile", Context.MODE_PRIVATE).getString("Key_UserName", ""))

        var ShowPassword = 0
        binding.imgShowPassword.setOnClickListener {
            if (ShowPassword == 0){
                binding.edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                ShowPassword = 1
            }else{
                binding.edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                ShowPassword = 0
            }
        }

        binding.btnLogin.setOnClickListener {
            if (binding.edtUsername.text.toString().equals("123") && binding.edtPassword.text.toString().equals(""))
            {
                val Ed = getSharedPreferences("LogInFile", Context.MODE_PRIVATE).edit()
                Ed.putString("Key_UserName", binding.edtUsername.text.toString())
                Ed.apply()

                startActivity(Intent(this, HomePageActivity ::class.java).putExtra("userName",binding.edtUsername.text.toString()))
                finish()


                binding.txtLoginError.visibility = View.INVISIBLE
            }else{
                binding.txtLoginError.visibility = View.VISIBLE
                binding.edtUsername.setText("")
                binding.edtPassword.setText("")
            }
        }


    }

}
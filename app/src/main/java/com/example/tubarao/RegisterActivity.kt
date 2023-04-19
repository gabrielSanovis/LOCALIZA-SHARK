package com.example.tubarao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tubarao.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.loginBtn.setOnClickListener {
            val password = binding.inputPassword.text.toString()
            val passwordConfirmation = binding.inputPasswordConfirmation.text.toString()
            val inputEmail = binding.inputEmail.text.toString()

            if (password == passwordConfirmation && password.isNotEmpty() && passwordConfirmation.isNotEmpty() && inputEmail.isNotEmpty()) {
                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
                finish()
            } else if(password != passwordConfirmation) {
                Toast.makeText(this, "${getString(R.string.passwords_are_not_the_same)}", Toast.LENGTH_SHORT).show()
            } else (
                Toast.makeText(this, "${getString(R.string.empty_field)}", Toast.LENGTH_SHORT).show()
            )
        }

        binding.goBackBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
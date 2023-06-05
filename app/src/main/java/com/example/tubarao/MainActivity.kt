package com.example.tubarao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tubarao.databinding.ActivityMainBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        binding.loginBtn.setOnClickListener {
            val email = binding.inputEmail.text.toString()
            val password = binding.inputPassword.text.toString()

            if (email == "admin@admin" && password == "123456") {
                val intent = Intent(this, FeedActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "${getString(R.string.login_failed)}", Toast.LENGTH_SHORT).show()
            }
        }
        binding.goRegisterBtn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
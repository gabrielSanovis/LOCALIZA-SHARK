package com.example.tubarao

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tubarao.databinding.ActivityRegisterBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.random.Random


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        database = Firebase.database.reference

        fun writeNewUser(userId: String, inputEmail: String, password: String) {
            val user = User(inputEmail, password)

            database.child("users").child(userId).setValue(user)
        }

        binding.loginBtn.setOnClickListener {
            val password = binding.inputPassword
            val passwordConfirmation = binding.inputPasswordConfirmation
            val inputEmail = binding.inputEmail

            if (password.text.toString() == passwordConfirmation.text.toString() && password.text.toString().isNotEmpty() && passwordConfirmation.text.toString().isNotEmpty() && inputEmail.text.toString().isNotEmpty()) {
                writeNewUser(Random.nextInt(0, 100).toString(), inputEmail.text.toString(), password.text.toString())
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
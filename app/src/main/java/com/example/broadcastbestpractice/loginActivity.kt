package com.example.broadcastbestpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.broadcastbestpractice.ui.theme.BroadcastBestPracticeTheme

class loginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        val login:Button = findViewById(R.id.login)
        val accountEdit:EditText = findViewById(R.id.editText)
        val passwordEdit:EditText = findViewById(R.id.passwordedit)

        login.setOnClickListener{
            val account = accountEdit.text.toString()
            val password = passwordEdit.text.toString()
            if(account == "admin" && password == "password"){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"username or password is wrong!",Toast.LENGTH_LONG).show()
            }

        }
    }
}
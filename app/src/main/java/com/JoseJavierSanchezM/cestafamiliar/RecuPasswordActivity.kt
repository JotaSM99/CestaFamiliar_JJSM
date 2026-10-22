package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.JoseJavierSanchezM.cestafamiliar.databinding.ActivityRecuPasswordBinding

class RecuPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecuPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecuPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.layoutRecuPassword) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnEnviarEnlace.setOnClickListener {
            val email = binding.etEmail.text?.toString()?.trim()
            if (email.isNullOrEmpty()) {
                binding.tilEmail.error = "Introduce tu correo electrónico"
            } else {
                binding.tilEmail.error = null
                Toast.makeText(this, "Enlace enviado a $email", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}

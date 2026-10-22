package com.JoseJavierSanchezM.cestafamiliar

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.JoseJavierSanchezM.cestafamiliar.databinding.ActivityCrearcuentaBinding

class CrearCuentaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCrearcuentaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCrearcuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.layoutCrearCuenta) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnRegistrarse.setOnClickListener {
            val nombre = binding.etNombre.text?.toString()?.trim()
            val email = binding.etEmail.text?.toString()?.trim()
            val password = binding.etPassword.text?.toString()?.trim()

            var hasError = false
            if (nombre.isNullOrEmpty()) {
                binding.tilNombre.error = "Campo obligatorio"
                hasError = true
            } else {
                binding.tilNombre.error = null
            }

            if (email.isNullOrEmpty()) {
                binding.tilEmail.error = "Campo obligatorio"
                hasError = true
            } else {
                binding.tilEmail.error = null
            }

            if (password.isNullOrEmpty()) {
                binding.tilPassword.error = "Campo obligatorio"
                hasError = true
            } else {
                binding.tilPassword.error = null
            }

            if (!hasError) {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}

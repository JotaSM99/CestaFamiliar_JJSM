package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.JoseJavierSanchezM.cestafamiliar.databinding.ActivityLoginBinding

// Pantalla para iniciar sesión con correo y contraseña
class LoginFragment : Fragment(R.layout.activity_login) {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ActivityLoginBinding.bind(view)

        // Enlace para ir a la pantalla de recuperar contraseña
        binding.tvRecuperarContrasena.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recuPasswordFragment)
        }

        // Botón para intentar acceder
        binding.btnAcceder.setOnClickListener {
            val email = binding.etEmail.text?.toString()?.trim()
            val password = binding.etPassword.text?.toString()?.trim()

            // Si los campos están vacíos mostramos la pantalla de error
            if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
                findNavController().navigate(R.id.action_loginFragment_to_loginErrorFragment)
            } else {
                // Si todoo está correcto entramos a la app
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

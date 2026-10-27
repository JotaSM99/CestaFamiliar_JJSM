package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.JoseJavierSanchezM.cestafamiliar.databinding.ActivityLoginErrorBinding

// Pantalla de login que muestra el mensaje de error en las credenciales
class LoginErrorFragment : Fragment(R.layout.activity_login_error) {

    private var _binding: ActivityLoginErrorBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ActivityLoginErrorBinding.bind(view)

        // Muestra el mensaje de error directamente en la caja de texto
        binding.tilEmail.error = getString(R.string.error_credenciales)

        binding.tvRecuperarContrasena.setOnClickListener {
            findNavController().navigate(R.id.action_loginErrorFragment_to_recuPasswordFragment)
        }

        binding.btnAcceder.setOnClickListener {
            val email = binding.etEmail.text?.toString()?.trim()
            val password = binding.etPassword.text?.toString()?.trim()

            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
                findNavController().navigate(R.id.action_loginErrorFragment_to_homeFragment)
            } else {
                binding.tilEmail.error = getString(R.string.error_credenciales)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

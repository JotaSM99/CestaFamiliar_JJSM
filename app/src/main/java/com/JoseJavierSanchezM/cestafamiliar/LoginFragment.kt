package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.JoseJavierSanchezM.cestafamiliar.databinding.ActivityLoginBinding

class LoginFragment : Fragment(R.layout.activity_login) {

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ActivityLoginBinding.bind(view)

        binding.tvRecuperarContrasena.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_recuPasswordFragment)
        }

        binding.btnAcceder.setOnClickListener {
            val email = binding.etEmail.text?.toString()?.trim()
            val password = binding.etPassword.text?.toString()?.trim()

            if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
                findNavController().navigate(R.id.action_loginFragment_to_loginErrorFragment)
            } else {
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

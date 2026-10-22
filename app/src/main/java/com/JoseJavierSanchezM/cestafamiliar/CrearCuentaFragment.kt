package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.JoseJavierSanchezM.cestafamiliar.databinding.ActivityCrearcuentaBinding

class CrearCuentaFragment : Fragment(R.layout.activity_crearcuenta) {

    private var _binding: ActivityCrearcuentaBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ActivityCrearcuentaBinding.bind(view)

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
                findNavController().navigate(R.id.action_crearCuentaFragment_to_homeFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

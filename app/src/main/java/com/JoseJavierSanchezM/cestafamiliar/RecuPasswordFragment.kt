package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.JoseJavierSanchezM.cestafamiliar.databinding.ActivityRecuPasswordBinding

class RecuPasswordFragment : Fragment(R.layout.activity_recu_password) {

    private var _binding: ActivityRecuPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ActivityRecuPasswordBinding.bind(view)

        binding.btnEnviarEnlace.setOnClickListener {
            val email = binding.etEmail.text?.toString()?.trim()
            if (email.isNullOrEmpty()) {
                binding.tilEmail.error = "Introduce tu correo electrónico"
            } else {
                binding.tilEmail.error = null
                Toast.makeText(requireContext(), "Enlace enviado a $email", Toast.LENGTH_SHORT).show()
                findNavController().navigateUp()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

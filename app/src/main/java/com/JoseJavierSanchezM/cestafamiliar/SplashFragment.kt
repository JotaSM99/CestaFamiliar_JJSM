package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.JoseJavierSanchezM.cestafamiliar.databinding.ActivitySplashBinding

class SplashFragment : Fragment(R.layout.activity_splash) {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ActivitySplashBinding.bind(view)

        binding.btnCrearCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_crearCuentaFragment)
        }

        binding.btnIniciarSesion.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }

        binding.tvModoInvitado.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

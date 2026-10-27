package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.JoseJavierSanchezM.cestafamiliar.databinding.ActivitySplashBinding

// Pantalla inicial de bienvenida con los botones principales
class SplashFragment : Fragment(R.layout.activity_splash) {

    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ActivitySplashBinding.bind(view)

        // Botón para ir al formulario de registro
        binding.btnCrearCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_crearCuentaFragment)
        }

        // Botón para ir a la pantalla de inicio de sesión
        binding.btnIniciarSesion.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }

        // Enlace para entrar directamente como invitado sin registrarse
        binding.tvModoInvitado.setOnClickListener {
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Liberamos el binding cuando se destruye la vista
        _binding = null
    }
}

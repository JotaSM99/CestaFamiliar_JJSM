package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.JoseJavierSanchezM.cestafamiliar.adapter.ProductoAdapter
import com.JoseJavierSanchezM.cestafamiliar.data.ProductoProvider
import com.JoseJavierSanchezM.cestafamiliar.databinding.FragmentHomeBinding

// Pantalla principal que muestra la lista de productos de la cesta mediante RecyclerView
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        // Inicializamos y configuramos el RecyclerView
        binding.rvProductos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProductos.adapter = ProductoAdapter(ProductoProvider.listaProductos) { producto ->
            Toast.makeText(requireContext(), "Seleccionado: ${producto.nombre}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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
            // Al hacer clic en un producto enviamos el objeto al DetalleProductoFragment
            val bundle = Bundle().apply {
                putSerializable("producto", producto)
            }
            findNavController().navigate(R.id.action_homeFragment_to_detalleProductoFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

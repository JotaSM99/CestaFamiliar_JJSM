package com.JoseJavierSanchezM.cestafamiliar

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.JoseJavierSanchezM.cestafamiliar.adapter.ProductoAdapter
import com.JoseJavierSanchezM.cestafamiliar.data.ProductoProvider
import com.JoseJavierSanchezM.cestafamiliar.databinding.FragmentHomeBinding

// Pantalla principal que muestra la lista de productos y gestiona el menú de opciones
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        // Configuración del menú de opciones mediante MenuHost
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.main_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_info -> {
                        Toast.makeText(requireContext(), "CestaFamiliar v1.0 - Aplicación de Compras", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_logout -> {
                        findNavController().navigate(R.id.splashFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        // Inicializamos y configuramos el RecyclerView
        binding.rvProductos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProductos.adapter = ProductoAdapter(ProductoProvider.listaProductos) { producto ->
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

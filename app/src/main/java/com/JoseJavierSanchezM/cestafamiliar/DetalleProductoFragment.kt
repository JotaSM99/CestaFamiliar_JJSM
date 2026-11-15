package com.JoseJavierSanchezM.cestafamiliar

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.JoseJavierSanchezM.cestafamiliar.databinding.FragmentDetalleProductoBinding
import com.JoseJavierSanchezM.cestafamiliar.model.Producto

// Fragmento que muestra el detalle completo de un producto seleccionado
class DetalleProductoFragment : Fragment(R.layout.fragment_detalle_producto) {

    private var _binding: FragmentDetalleProductoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetalleProductoBinding.bind(view)

        // Obtenemos el producto de forma compatible con distintas versiones de Android
        val producto = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("producto", Producto::class.java)
        } else {
            @Suppress("DEPRECATION")
            arguments?.getSerializable("producto") as? Producto
        }

        producto?.let { p ->
            binding.tvDetalleNombre.text = p.nombre
            binding.tvDetalleCategoria.text = "Categoría: ${p.categoria}"
            binding.tvDetalleCantidad.text = "Cantidad: ${p.cantidad}"
            binding.tvDetallePrecio.text = "${p.precio} €"
            binding.tvDetalleDescripcion.text = p.descripcion
            binding.ivDetalleImagen.setImageResource(p.imagenResId)
        }

        binding.btnVolver.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

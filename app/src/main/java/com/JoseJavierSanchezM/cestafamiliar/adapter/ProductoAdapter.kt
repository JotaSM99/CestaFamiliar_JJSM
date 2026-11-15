package com.JoseJavierSanchezM.cestafamiliar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.JoseJavierSanchezM.cestafamiliar.databinding.ItemProductoBinding
import com.JoseJavierSanchezM.cestafamiliar.model.Producto

// Adaptador para gestionar el llenado del RecyclerView de la cesta de la compra
class ProductoAdapter(
    private val listaProductos: List<Producto>,
    private val onClickListener: (Producto) -> Unit
) : RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(val binding: ItemProductoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(producto: Producto, onClickListener: (Producto) -> Unit) {
            binding.tvNombreProducto.text = producto.nombre
            binding.tvCategoriaProducto.text = producto.categoria
            binding.tvCantidadProducto.text = "Cantidad: ${producto.cantidad}"
            binding.tvPrecioProducto.text = "${producto.precio} €"
            binding.ivProducto.setImageResource(producto.imagenResId)

            itemView.setOnClickListener {
                onClickListener(producto)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val binding = ItemProductoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        holder.bind(listaProductos[position], onClickListener)
    }

    override fun getItemCount(): Int = listaProductos.size
}

package com.JoseJavierSanchezM.cestafamiliar.data

import com.JoseJavierSanchezM.cestafamiliar.R
import com.JoseJavierSanchezM.cestafamiliar.model.Producto

// Proveedor de datos de prueba para la lista de la cesta de la compra
object ProductoProvider {

    val listaProductos: List<Producto> = listOf(
        Producto(
            id = 1,
            nombre = "Leche Semidesnatada 1L",
            categoria = "Lácteos",
            cantidad = 2,
            precio = 0.95,
            descripcion = "Leche de vaca semidesnatada de origen local.",
            imagenResId = R.drawable.cesta_de_la_compra
        ),
        Producto(
            id = 2,
            nombre = "Pan de Molde Integral",
            categoria = "Panadería",
            cantidad = 1,
            precio = 1.25,
            descripcion = "Pan de molde con harina 100% integral y semillas.",
            imagenResId = R.drawable.cesta_de_la_compra
        ),
        Producto(
            id = 3,
            nombre = "Aceite de Oliva Virgen Extra 1L",
            categoria = "Aceites",
            cantidad = 1,
            precio = 6.90,
            descripcion = "Aceite de oliva virgen extra de extracción en frío.",
            imagenResId = R.drawable.cesta_de_la_compra
        ),
        Producto(
            id = 4,
            nombre = "Manzanas Golden 1kg",
            categoria = "Frutas y Verduras",
            cantidad = 1,
            precio = 1.80,
            descripcion = "Manzanas Golden crujientes y dulces.",
            imagenResId = R.drawable.cesta_de_la_compra
        ),
        Producto(
            id = 5,
            nombre = "Pechuga de Pollo 500g",
            categoria = "Carnicería",
            cantidad = 2,
            precio = 4.50,
            descripcion = "Filetes de pechuga de pollo limpia sin piel.",
            imagenResId = R.drawable.cesta_de_la_compra
        )
    )
}

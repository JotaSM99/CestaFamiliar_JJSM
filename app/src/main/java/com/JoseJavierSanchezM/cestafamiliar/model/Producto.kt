package com.JoseJavierSanchezM.cestafamiliar.model

import java.io.Serializable

// Modelo de datos que representa un producto de la cesta de la compra
data class Producto(
    val id: Int,
    val nombre: String,
    val categoria: String,
    val cantidad: Int,
    val precio: Double,
    val descripcion: String,
    val imagenResId: Int
) : Serializable

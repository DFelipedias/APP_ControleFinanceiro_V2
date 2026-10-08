package com.example.app_controlefinanceiro

data class Transacao(
    val id: Int,
    val descricao: String,
    val valor: Double,
    val categoriaId: Int,
    val data: String,
    val despesa: Boolean
)

data class Categoria(val id: Int, val nome: String, val descricao: String)

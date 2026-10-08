package com.example.app_controlefinanceiro

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class FinanceiroViewModel : ViewModel() {
    val categorias = mutableStateListOf(
        Categoria(1, "Alimentação", "Refeições e compras de mercado"),
        Categoria(2, "Transporte", "Combustível, ônibus e aplicativos"),
        Categoria(3, "Saúde", "Farmácia e cuidados pessoais"),
        Categoria(4, "Renda", "Salário e outras entradas")
    )
    val transacoes = mutableStateListOf(
        Transacao(1, "Salário", 3500.0, 4, "01/10/2026", false),
        Transacao(2, "Supermercado", 450.0, 1, "02/10/2026", true),
        Transacao(3, "Combustível", 180.0, 2, "03/10/2026", true),
        Transacao(4, "Almoço Restaurante", 38.50, 1, "04/10/2026", true),
        Transacao(5, "Farmácia", 27.90, 3, "04/10/2026", true)
    )
    private var proximaTransacao = 6
    private var proximaCategoria = 5

    fun adicionarTransacao(descricao: String, valor: Double, categoriaId: Int, data: String, despesa: Boolean) {
        transacoes.add(Transacao(proximaTransacao++, descricao, valor, categoriaId, data, despesa))
    }

    fun editarTransacao(item: Transacao, descricao: String, valor: Double, data: String) {
        val indice = transacoes.indexOf(item)
        if (indice >= 0) transacoes[indice] = item.copy(descricao = descricao, valor = valor, data = data)
    }

    fun removerTransacao(item: Transacao) { transacoes.remove(item) }

    fun adicionarCategoria(nome: String, descricao: String) {
        categorias.add(Categoria(proximaCategoria++, nome, descricao))
    }

    fun removerCategoria(item: Categoria): Boolean {
        if (transacoes.any { it.categoriaId == item.id }) return false
        categorias.remove(item)
        return true
    }

    fun nomeCategoria(id: Int) = categorias.find { it.id == id }?.nome ?: "Sem categoria"
    fun receitas() = transacoes.filter { !it.despesa }.sumOf { it.valor }
    fun despesas() = transacoes.filter { it.despesa }.sumOf { it.valor }
    fun saldo() = receitas() - despesas()
}

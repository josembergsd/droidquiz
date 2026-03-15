package br.com.capgemini.droidquiz.entities

data class Opcao(
    val id: Int,
    val texto: String,
    val perguntaId: Int,
    val explicacao: String
)

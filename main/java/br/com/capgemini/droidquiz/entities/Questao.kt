package br.com.capgemini.droidquiz.entities

data class Questao(
    val id: Int,
    val pergunta: String,
    val opcoes: List<Opcao>,
    val respostaCorreta: Int,
    val nivel: Int
)
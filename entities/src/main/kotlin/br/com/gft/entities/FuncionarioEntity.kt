package br.com.gft.entities

import br.com.gft.entities.enums.NivelDeEngajamentoEnum

data class FuncionarioEntity(
    val id: Long = 0,
    val nome: String,
    val idade: Short,
    val nivelDeEngajamento: NivelDeEngajamentoEnum
)

package br.com.gft.entities.request

import br.com.gft.entities.enums.NivelDeEngajamentoEnum

data class FuncionarioRequestBody(
    val nome: String,
    val idade: Short,
    val nivelDeEngajamento: NivelDeEngajamentoEnum
)
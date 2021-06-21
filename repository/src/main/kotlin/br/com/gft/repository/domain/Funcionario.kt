package br.com.gft.repository.domain

import br.com.gft.entities.enums.NivelDeEngajamentoEnum
import javax.persistence.*

@Entity
class Funcionario(

    @Id
    @GeneratedValue
    val id: Long = 0,

    val nome: String,

    val idade: Short,

    @Enumerated(EnumType.STRING)
    val nivelDeEngajamento: NivelDeEngajamentoEnum
)
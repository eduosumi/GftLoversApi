package br.com.gft.web.request

import br.com.gft.entities.enums.NivelDeEngajamentoEnum
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel("Dados do funcionario que ama trabalhar na GFT")
data class FuncionarioRequestBody(
    @ApiModelProperty("nome do funcionario", position = 1)
    val nome: String,
    @ApiModelProperty("idade do funcionario(pode ser a idade que se considera)", position = 2)
    val idade: Short,
    @ApiModelProperty("Qual é o nivel de engajamento do funcionario / O quão motivado esta", position = 3)
    val nivelDeEngajamento: NivelDeEngajamentoEnum
)
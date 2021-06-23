package br.com.gft.web.controller

import br.com.gft.web.request.FuncionarioRequestBody
import br.com.gft.repository.FuncionarioRepository
import br.com.gft.repository.domain.Funcionario
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/funcionarios")
class FuncionarioControllerImpl(
    private val funcionarioRepository: FuncionarioRepository
) {

    @PostMapping
    fun post(@RequestBody funcionarioRequest: FuncionarioRequestBody): Long {
        val funcionario = funcionarioRepository.save(
            Funcionario(
                nome = funcionarioRequest.nome,
                idade = funcionarioRequest.idade,
                nivelDeEngajamento = funcionarioRequest.nivelDeEngajamento
            )
        )

        return funcionario.id
    }
}
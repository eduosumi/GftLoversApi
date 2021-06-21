package br.com.gft.repository

import br.com.gft.repository.domain.Funcionario
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FuncionarioRepository : CrudRepository<Funcionario, Long>
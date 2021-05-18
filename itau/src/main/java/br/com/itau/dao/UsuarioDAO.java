package br.com.itau.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.usuario.modelo.Usuario;

/*
 * DAO -> É um pattern que sugestiona onde devem ficar os comandos SQL DML.
 *  Dentro das classes DAO's:
 *  - Montar o CRUD (Create - Read - Update - Delete)
 */
public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

	/*
	 * CrudRepository -> É a classe pai do UsuarioDAO e está informando
	 * ao SpringBoot que esta classe armazenará o CRUD para o usuário.
	 * O Integer é para especificar o tipo de dado da chave primária
	 * é Integer (int). Obs: Como estamos trabalhando com classe, não
	 * podemos abreviar ex: int.
	 */
	
	/*
	 * Métodos herdados do CrudRepository:
	 * - save(objeto): grava/altera uma linha no banco de dados;
	 * - findById(int): pesquisa um usuário pelo código identificador;
	 * - findAll(): retorna todos os usuários da tabela;
	 * - deleteById(int): deleta um usuário pelo Id;
	 * - deleteAll(): apaga todos os dados da tabela;
	 * - count(): retorna quantos usuários existem na tabela;
	 */
	
}

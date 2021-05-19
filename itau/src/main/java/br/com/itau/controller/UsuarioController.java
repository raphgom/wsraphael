package br.com.itau.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.dao.UsuarioDAO;
import br.com.itau.modelo.Usuario;

@RestController // Para Rest API, o SpringBoot entenderá que a classe responderá a requisições
				// HTTP
@CrossOrigin("*") // Para liberar o acesso fora do servidor a estes recursos
public class UsuarioController {

	@Autowired // Delega para o SpringBoot o gerenciamento deste atributo
	private UsuarioDAO udao;

	// Função de Login processando pelo FrontEnd consultando o banco
	@PostMapping("/login2")
	public ResponseEntity<Usuario> logar2(@RequestBody Usuario objeto){
		Usuario usuario = udao.findByEmailAndSenha(objeto.getEmail(), objeto.getSenha());
				if(usuario==null) {
					return ResponseEntity.status(404).build();
				}
		return ResponseEntity.ok(usuario);
	}
	
	// Função de Login processando pelo BackEnd consultando o banco
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> logar(@RequestBody Usuario objeto) {
		List<Usuario> lista = (List<Usuario>) udao.findAll();
		for (Usuario usuario : lista) {
			if (usuario.getEmail().equals(objeto.getEmail()) && usuario.getSenha().equals(objeto.getSenha())) {
				return ResponseEntity.ok(usuario);
			}
		}
		return ResponseEntity.status(404).build();
	}

	// POST para consultar usuários por ID, puxando o RequestBody(JSON) para
	// instanciar o objeto
	@PostMapping("/usuariospostbyid")
	public ResponseEntity<Usuario> getUserPostById(@RequestBody Usuario objeto) {
		try {
			Usuario resposta = udao.findById(objeto.getId()).orElse(new Usuario());
			resposta.setSenha("");
			if (resposta.getId() == 0) {
				return ResponseEntity.status(404).build();
			}
			return ResponseEntity.ok(resposta);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}

	// Respondendo o GET com retorno de resposta HTTP
	@GetMapping("/usuariosgetbyid/{cod}"/* /{proximavariavel}/{proximavariavel} */)
	public ResponseEntity<Usuario> getUserGetById(@PathVariable int cod) {

		try {
			Usuario resposta = udao.findById(cod).orElse(new Usuario());
			resposta.setSenha("");
			if (resposta.getId() == 0) {
				return ResponseEntity.status(404).build();
			}
			return ResponseEntity.ok(resposta);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}

	// POST para criar novo usuario, instanciando o objeto e usando o método Crud
	// save.
	@PostMapping("/novousuario")
	public ResponseEntity<Usuario> addUser(@RequestBody Usuario objeto) {
		try {
			udao.save(objeto);
			return ResponseEntity.ok(objeto);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}

	// GET simples para consultar todos os usuarios da tabela com o método CRUD
	// findAll()
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getAllUsers() {
		try {
			List<Usuario> listaUsuarios = (List<Usuario>) udao.findAll();
			if (listaUsuarios.size() == 0) {
				return ResponseEntity.status(404).build();
			}
			return ResponseEntity.ok(listaUsuarios);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}

}

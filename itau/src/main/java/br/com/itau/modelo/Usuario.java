package br.com.itau.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity // "Annotation" que fala para o SpringBoot que 
		// esta classe possui uma tabela 
		// correspondente no Banco de Dados
@Table(name="tb_usuario")  // "Annotation" para informar qual 
					       // tabela será consumida
public class Usuario {
	
	@Id // "Annotation" avisa ao SpringBoot que a coluna é a chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY) // "Annotation" para indicar que a coluna é auto incremental
	@Column(name="id") // "Annotation" para informar a coluna da tabela
	private int id;
	
	@Column(name="nome",length=50)
	private String nome;
	
	@Column(name="email",length=70)
	private String email;
	
	@Column(name="senha",length=20)
	private String senha;
	
	@Column(name="foto",length=100)
	private String foto;
	
	// Aplicar o DTO (Getters e Setters e Construtores Cheio e Vazio):
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", foto=" + foto
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Usuario(int id, String nome, String email, String senha, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.foto = foto;
	}
	public Usuario() {
		super();
	}
	
}

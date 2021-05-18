package br.com.colecoes.beans;

public class Cargo {

	private String nome;
	private String nivel;
	private double salario;
	
	// apliquem o DTO
	// (Criar Getters and Setters
	// e Construtor Cheio e Construtor Vazio)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Cargo(String nome, String nivel, double salario) {
		super();
		this.nome = nome;
		this.nivel = nivel;
		this.salario = salario;
	}
	public Cargo() {
		super();
	}
	
	
}

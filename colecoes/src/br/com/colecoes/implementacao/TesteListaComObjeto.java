package br.com.colecoes.implementacao;

import java.util.List;
import java.util.ArrayList;

import br.com.colecoes.beans.Cargo;

public class TesteListaComObjeto {

	public static void main(String[] args) {
		
		Cargo resposta = new Cargo();
		
		List<Cargo> lista = new ArrayList<Cargo>();
		
		lista.add(new Cargo("DBA","JR", 5000));
		lista.add(new Cargo("DEV","JR", 4000));
		lista.add(new Cargo("Gerente de Projetos","JR", 4500));
		lista.add(new Cargo("DBA","SR", 15000));
		
		System.out.println("Completa: "+lista);
		double totalSalarios = 0;
		float dbas = 0;
		float jrs = 0;
		double tempSalario = 0;
		double maiorSalario = 0;
		String maiorCargo = "";
		String maiorNivel = "";
		
		for(Cargo objeto:lista) {
			tempSalario = objeto.getSalario();
			if (maiorSalario<tempSalario) {
				maiorSalario = tempSalario;
				maiorCargo = objeto.getNome();
				maiorNivel = objeto.getNivel();
			}
	
			totalSalarios += objeto.getSalario();
			System.out.println("Cargo: "+objeto.getNome());
			System.out.println("Nível: "+objeto.getNivel());
			System.out.println("Salário: "+objeto.getSalario());
			System.out.println("=========================");
			
			if(objeto.getNome().equals("DBA")) {
				dbas+= objeto.getSalario();
			}
			if(objeto.getNivel().equalsIgnoreCase("JR")) {
				jrs++;
			}
			
			if(objeto.getSalario()>resposta.getSalario()) {
				resposta=objeto;
			}
		}
		
		double mediaSalarios = totalSalarios/lista.size();
		
		System.out.println("Total Folha: R$"+totalSalarios);
		System.out.println("Média dos Salários: R$"+mediaSalarios);
		System.out.println("Total Salário DBA's: R$"+dbas);
		System.out.println("Total JR's: "+jrs);
		System.out.println("Cargo e Nível com Maior Salário: "+maiorCargo+" "+maiorNivel);
		System.out.println("Maior Salário: R$"+maiorSalario);
		System.out.println("Cargo e Nível com Maior Salário Objeto: "+resposta.getNome()+" "+resposta.getNivel()	);
		System.out.println("Maior Salário Objeto: R$"+resposta.getSalario());
		
	}
}

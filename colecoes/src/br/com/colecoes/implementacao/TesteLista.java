package br.com.colecoes.implementacao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class TesteLista {

	public static void main(String[] args) {
		List <String> lista = new ArrayList <String>();
		
		do {
			lista.add(JOptionPane.showInputDialog("Digite um Cargo:"));
		}while(JOptionPane.showConfirmDialog(null,"?","",JOptionPane.YES_NO_OPTION)==1);
		
		System.out.println(lista);
		//lista.add(7); -> Adicionando um valor
		//lista.add(true); -> 
		//lista.add('a");
		System.out.println("Primeiro: "+lista.get(0)); //Exibindo o primeiro elemento da lista
		lista.remove(0); // Removendo o primeiro elemento da lista
		System.out.println("Depois de remover: \n"+lista);
	
		Collections.sort(lista);
		System.out.println("Ordenada: \n"+ lista);
		
		for(int contador=0;contador<lista.size();contador++) {
			System.out.println("Cargo: "+ lista.get(contador));
		}
	}
}

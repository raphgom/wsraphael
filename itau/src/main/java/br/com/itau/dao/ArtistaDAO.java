package br.com.itau.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.modelo.Artista;

public interface ArtistaDAO extends CrudRepository<Artista, Integer>{
	
	// posso criar novos filtros baseados nas definições da classes principais juntando os métodos nativos findBy{Propriedade}
	List<Artista> findByNacionalidade(String nac);
	List<Artista> findByNomeArtisticoLike(String nome);
}

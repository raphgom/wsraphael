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

import br.com.itau.dao.ArtistaDAO;
import br.com.itau.modelo.Artista;

@RestController
@CrossOrigin("*")

public class ArtistaController {

	@Autowired
	private ArtistaDAO adao;

	// Cadastrando o artista
	@PostMapping("/cadartista")
	public ResponseEntity<Artista> addArtista(@RequestBody Artista artista) {
		try {
			adao.save(artista);
			return ResponseEntity.ok(artista);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
	// Retornando artistas por ID
	@GetMapping("artista/{cod}")
	public ResponseEntity<Artista> getArtista(@PathVariable int cod){
		Artista resposta = adao.findById(cod).orElse(null);
		if(resposta==null) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(resposta);
	}
	
	// filtrando por nome
	@GetMapping("/nomeartistico/{nome}")
	public ResponseEntity<List<Artista>> getNomeArtistico(@PathVariable String nome){
		List<Artista> lista = adao.findByNomeArtisticoLike("%"+nome+"%");
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		
		return ResponseEntity.ok(lista);
	}

	// Retornando todos os artistas
	@GetMapping("/artistas")
	public ResponseEntity<List<Artista>> getAllArtistas() {
		try {
			List<Artista> listaArtistas = (List<Artista>) adao.findAll();
			if (listaArtistas.size() == 0) {
				return ResponseEntity.status(404).build();
			}
			return ResponseEntity.ok(listaArtistas);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}

	// Retornarndo artistas por nacionalidade
	@GetMapping("/nacionalidade/{nac}")
	public ResponseEntity<List<Artista>> getNacionalidade(@PathVariable String nac) {
		try {
			List<Artista> listaArtistas = (List<Artista>) adao.findByNacionalidade(nac);

			if (listaArtistas.isEmpty() == false) {
				return ResponseEntity.ok(listaArtistas);
			} else {
				return ResponseEntity.status(404).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
	@PostMapping("apagarartista")
	public ResponseEntity<Boolean> delete(@RequestBody Artista objeto){
		try{
			adao.deleteById(objeto.getId());
			return ResponseEntity.ok(true);
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
		
	}

}

package com.example.lojagames.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.example.lojagames.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll();
		
		usuarioRepository.save(new Usuario(0L, "Rodrigo Pereira", "Foto", "rodrigo@hotmail.com", "123456789"));
		
		usuarioRepository.save(new Usuario(0L, "José Pereira", "Foto", "jose@hotmail.com", "987654321"));
		
		usuarioRepository.save(new Usuario(0L, "Cristiane Pereira", "Foto", "cristiane@hotmail.com", "12365689"));
		
	}
	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("jose@hotmail.com");
		assertTrue(usuario.get().getUsuario().equals("jose@hotmail.com"));
	}
	
	
	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Pereira");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Rodrigo Pereira"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("José Pereira"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Cristiane Pereira"));
		
	}
	
}

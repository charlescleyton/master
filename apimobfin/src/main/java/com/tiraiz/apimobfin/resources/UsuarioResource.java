package com.tiraiz.apimobfin.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiraiz.apimobfin.models.Usuario;
import com.tiraiz.apimobfin.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/api")
public class UsuarioResource {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/usuario/{id}")
	public Usuario listaUsuarioUnico(@PathVariable(value = "id") long id) {
		return usuarioRepository.findByid(id);
	}

	@PostMapping("/usuario")
	public Usuario salvaUsuario(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping("/usuario/{id}")
	public void deletaUsuario(@PathVariable(value = "id") long id) {
		usuarioRepository.deleteById(id);
	}

	@PutMapping("/usuario")
	public Usuario atualizaProduto(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}

package com.tiraiz.apicontrollfin.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiraiz.apicontrollfin.models.Usuario;
import com.tiraiz.apicontrollfin.repository.UsuarioRepository;

@RestController
@RequestMapping (value="/api")
public class UsuarioResource {

	
	@Autowired 
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	public List<Usuario> listaUsuarios(){
		return usuarioRepository.findAll();
	}
	
}

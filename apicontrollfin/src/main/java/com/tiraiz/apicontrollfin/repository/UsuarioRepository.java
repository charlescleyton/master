package com.tiraiz.apicontrollfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tiraiz.apicontrollfin.models.Usuario;

public class UsuarioRepository {

	public interface ProdutoRepository extends JpaRepository<Usuario, Long> {
		Usuario findById(long id);

	}

}

package com.tiraiz.apimobfin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiraiz.apimobfin.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByid(long id);
}

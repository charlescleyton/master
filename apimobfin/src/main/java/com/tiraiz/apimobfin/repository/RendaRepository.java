package com.tiraiz.apimobfin.repository;

import com.tiraiz.apimobfin.models.Renda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendaRepository extends JpaRepository<Renda, Long> {
    Renda findByid(long id_Renda);

}

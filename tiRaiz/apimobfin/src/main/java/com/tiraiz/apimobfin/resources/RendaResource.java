package com.tiraiz.apimobfin.resources;

import java.util.List;

import com.tiraiz.apimobfin.models.Renda;
import com.tiraiz.apimobfin.repository.RendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RendaResource {

    @Autowired
    RendaRepository rendaRepository;

    @GetMapping("/rendas")
    public List<Renda> listaUsuarios() {
        return rendaRepository.findAll();
    }

    @GetMapping("/renda/{id}")
    public Renda listaUsuarioUnico(@PathVariable(value = "id") long id) {
        return rendaRepository.findByid(id);
    }

    @PostMapping("/renda")
    public Renda salvaUsuario(@RequestBody Renda renda) {
        return rendaRepository.save(renda);
    }

    @DeleteMapping("/renda/{id}")
    public void deletaRenda(@PathVariable(value = "id") long id) {
        rendaRepository.deleteById(id);
    }

    @PutMapping("/renda")
    public Renda atualizaRenda(@RequestBody Renda renda) {
        return rendaRepository.save(renda);
    }
}

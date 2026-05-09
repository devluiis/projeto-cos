package br.unitins.ms_disciplina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.unitins.ms_disciplina.model.Disciplina;
import br.unitins.ms_disciplina.service.DisciplinaService;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaResource {

    @Autowired
    DisciplinaService service;

    // GET /disciplinas — lista todas
    @GetMapping
    public List<Disciplina> listar() {
        return service.listar();
    }

    // GET /disciplinas/{id} — busca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /disciplinas — cria nova
    @PostMapping
    public ResponseEntity<Disciplina> criar(@RequestBody Disciplina d) {
        return ResponseEntity.status(201).body(service.salvar(d));
    }

    // PUT /disciplinas/{id} — atualiza existente
    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> atualizar(
            @PathVariable Long id,
            @RequestBody Disciplina dados) {
        return service.buscar(id).map(d -> {
            d.setNome(dados.getNome());
            d.setProfessor(dados.getProfessor());
            d.setCargaHoraria(dados.getCargaHoraria());
            return ResponseEntity.ok(service.salvar(d));
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /disciplinas/{id} — remove
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

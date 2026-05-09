package br.unitins.mstarefa.controller;

import br.unitins.mstarefa.model.Tarefa;
import br.unitins.mstarefa.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaResource {

    @Autowired
    TarefaService service;

    // GET /tarefas — lista todas
    @GetMapping
    public List<Tarefa> listar() {
        return service.listar();
    }

    // GET /tarefas/disciplina/{id} — tarefas de uma disciplina específica
    @GetMapping("/disciplina/{id}")
    public List<Tarefa> porDisciplina(@PathVariable Long id) {
        return service.porDisciplina(id);
    }

    // POST /tarefas — cria nova tarefa (valida disciplina via HTTP)
    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa t) {
        try {
            return ResponseEntity.status(201).body(service.salvar(t));
        } catch (RuntimeException e) {
            // Retorna 400 se a disciplina não existir no ms-disciplina
            return ResponseEntity.badRequest().build();
        }
    }

    // DELETE /tarefas/{id} — remove
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

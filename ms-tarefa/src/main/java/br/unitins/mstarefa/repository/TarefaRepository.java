package br.unitins.mstarefa.repository;

import br.unitins.mstarefa.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // Método derivado: busca todas as tarefas de uma disciplina pelo ID
    List<Tarefa> findByDisciplinaId(Long disciplinaId);
}

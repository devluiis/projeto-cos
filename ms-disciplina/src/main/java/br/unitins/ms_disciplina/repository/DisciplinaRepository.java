package br.unitins.ms_disciplina.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unitins.ms_disciplina.model.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
    // findAll(), findById(), save(), deleteById() — prontos!
}

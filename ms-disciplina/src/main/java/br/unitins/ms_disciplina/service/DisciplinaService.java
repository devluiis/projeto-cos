package br.unitins.ms_disciplina.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unitins.ms_disciplina.model.Disciplina;
import br.unitins.ms_disciplina.repository.DisciplinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repo;

    public List<Disciplina> listar() {
        return repo.findAll();
    }

    public Optional<Disciplina> buscar(Long id) {
        return repo.findById(id);
    }

    public Disciplina salvar(Disciplina d) {
        return repo.save(d);
    }

    public void excluir(Long id) {
        repo.deleteById(id);
    }
}

package br.unitins.mstarefa.service;

import br.unitins.mstarefa.model.Tarefa;
import br.unitins.mstarefa.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    TarefaRepository repo;

    // RestTemplate: faz chamadas HTTP para outros microsserviços
    private final RestTemplate restTemplate = new RestTemplate();

    // Lê a variável de ambiente; usa localhost como padrão fora do Compose
    @Value("${URL_DISCIPLINA:http://localhost:8081/disciplinas/}")
    private String urlDisciplina;

    public List<Tarefa> listar() {
        return repo.findAll();
    }

    public void excluir(Long id) {
        repo.deleteById(id);
    }

    public List<Tarefa> porDisciplina(Long id) {
        return repo.findByDisciplinaId(id);
    }

    public Tarefa salvar(Tarefa t) {
        try {
            restTemplate.getForObject(
                urlDisciplina + t.getDisciplinaId(), Object.class);
        } catch (Exception e) {
            throw new RuntimeException("Disciplina não encontrada!");
        }
        return repo.save(t);
    }
}
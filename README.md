# projeto-cos

Projeto da disciplina **Computação Orientada a Serviços** — TADS ToGraduado — UNITINS.
Período: 5º
Professor: Alysson Bruno
Aluno: Luís Paulo


Contém dois microsserviços Spring Boot orquestrados com Docker Compose.

## Microsserviços

| Serviço | Porta | Descrição |
|---|---|---|
| ms-disciplina | 8081 | Gerencia disciplinas |
| ms-tarefa | 8082 | Gerencia tarefas vinculadas a disciplinas |

## Pré-requisitos

- [Docker Desktop](https://www.docker.com/products/docker-desktop/)

## Como executar

```bash
docker compose up
```

Aguarde as mensagens:
```
ms-disciplina-1 | Started MsDisciplinaApplication in X seconds
ms-tarefa-1     | Started MsTarefaApplication in X seconds
```

## Endpoints

### ms-disciplina — `http://localhost:8081`

| Método | Rota | Descrição |
|---|---|---|
| GET | /disciplinas | Lista todas as disciplinas |
| POST | /disciplinas | Cria uma disciplina |

### ms-tarefa — `http://localhost:8082`

| Método | Rota | Descrição |
|---|---|---|
| GET | /tarefas | Lista todas as tarefas |
| POST | /tarefas | Cria uma tarefa |
| GET | /tarefas/disciplina/{id} | Lista tarefas de uma disciplina |

## Exemplo de uso

**Criar disciplina:**
```json
POST http://localhost:8081/disciplinas
{
  "nome": "Computação Orientada a Serviços",
  "professor": "Alysson",
  "cargaHoraria": 60
}
```

**Criar tarefa:**
```json
POST http://localhost:8082/tarefas
{
  "titulo": "Atividade A2",
  "prazo": "09/05/2026",
  "concluida": false,
  "disciplinaId": 1
}
```

## Parar o ambiente

```bash
docker compose down
```

## Estrutura do projeto

```
projeto-cos/
├── ms-disciplina/
│   ├── src/
│   ├── pom.xml
│   └── Dockerfile
├── ms-tarefa/
│   ├── src/
│   ├── pom.xml
│   └── Dockerfile
└── compose.yaml
```

📅 API de Agendamentos

API REST desenvolvida em Java para gerenciamento de agendamentos, permitindo criar, listar, atualizar e remover registros.

🚀 Tecnologias

 - Java

 - Spring Boot

 - Spring Web

 - Spring Data JPA

 - Banco de dados (H2)

📌 Funcionalidades

- Criar agendamento

- Listar todos os agendamentos

- Buscar agendamentos por dia

- Atualizar agendamento

- Remover agendamento

📂 Estrutura do Projeto
```
src/
 ├── controller/
 │    └── AgendamentoController.java
 ├── service/
 │    └── AgendamentoService.java
 ├── infrastructure/
 |    └── model/
 │    |     └── Agendamento.java
 |    └── repository/
 │          └── AgendamentoRepository.java 
```

▶️ Como executar o projeto
Pré-requisitos

- Java 17+

- Maven ou Gradle

# Passos
- Clonar o repositório
`git clone https://github.com/seu-usuario/seu-repo.git`

- Entrar na pasta
`cd seu-repo`

- Rodar o projeto
`./mvnw spring-boot:run`

A aplicação estará disponível em:

`http://localhost:8080`

# 🔗 Endpoints da API
📌 Criar Agendamento

POST /agendamentos
```json
{
  "servico": "assistencia",
  "profissional": "tecnico",
  "dataHoraAgendamento": "2026-02-03T15:10",
  "cliente": "hiago",
  "telefoneCliente": "11959559059"
}
```

📌 Listar todos os agendamentos

GET /agendamentos

📌 Buscar agendamentos por dia

GET /agendamentos?dia=YYYY-MM-DD

Exemplo:

`/agendamentos?dia=2026-02-03`

📌 Atualizar agendamento

PUT /agendamentos?cliente={cliente}&dataHoraAgendamento={dataHora}

Exemplo:

`/agendamentos?cliente=hiago&dataHoraAgendamento=2026-02-03T15:10`

Body:
```json
{
  "servico": "assistencia",
  "profissional": "tecnico",
  "dataHoraAgendamento": "2026-02-03T16:10",
  "cliente": "hiago",
  "telefoneCliente": "11959559059"
}
```
📌 Remover agendamento

DELETE /agendamentos?cliente={cliente}&dataHoraAgendamento={dataHora}

Exemplo:

/agendamentos?cliente=hiago&dataHoraAgendamento=2026-02-03T16:10

🧪 Testes com Postman

Você pode importar a collection disponível no projeto:

📄 agendamento.postman_collection.json 

agendamento.postman_collection

📄 Modelo de Dados

Agendamento

|  Campo              |     Tipo      |        Descrição           |
|---------------------|---------------|----------------------------|
| servico             | String        | Tipo de serviço            |
| profissional        | String        | Responsável pelo serviço   |
| dataHoraAgendamento | LocalDateTime | Data e hora do agendamento |
| cliente	            | String        | Nome do cliente            |
| telefoneCliente     | String        | Telefone do cliente        |

⚠️ Observações

Caso o parâmetro dia não seja informado na busca, todos os agendamentos são retornados.

A atualização e remoção utilizam cliente + dataHoraAgendamento como identificador.

👨‍💻 Autor

Desenvolvido por Hiago Jesus

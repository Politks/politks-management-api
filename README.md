# Politks Management API

API para gerenciamento de políticos, candidatos e eleições.

## Tecnologias Utilizadas

- Java 17
- Quarkus 3.x
- PostgreSQL
- Hibernate ORM
- RESTEasy
- JUnit 5
- Docker

## Pré-requisitos

- Java 17 ou superior
- Maven 3.8.x ou superior
- PostgreSQL 14 ou superior
- Docker (opcional)

## Configuração do Ambiente

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/politks-management-api.git
cd politks-management-api
```

2. Configure o banco de dados PostgreSQL:
```bash
# Usando Docker
docker run --name postgres-politks -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=politks -p 5432:5432 -d postgres:14

# Ou configure manualmente um banco PostgreSQL local
```

3. Configure as variáveis de ambiente no arquivo `application.properties`:
```properties
quarkus.datasource.username=seu_usuario
quarkus.datasource.password=sua_senha
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/politks
```

## Executando a Aplicação

### Modo de Desenvolvimento

```bash
./mvnw quarkus:dev
```

### Modo de Produção

```bash
./mvnw package
java -jar target/quarkus-app/quarkus-run.jar
```

## Endpoints da API

### Políticos

- `GET /api/politicians` - Lista todos os políticos
- `GET /api/politicians/{id}` - Obtém um político específico
- `POST /api/politicians` - Cria um novo político
- `PUT /api/politicians/{id}` - Atualiza um político
- `DELETE /api/politicians/{id}` - Remove um político

### Eleições

- `GET /api/elections` - Lista todas as eleições
- `GET /api/elections/{id}` - Obtém uma eleição específica
- `POST /api/elections` - Cria uma nova eleição
- `PUT /api/elections/{id}` - Atualiza uma eleição
- `DELETE /api/elections/{id}` - Remove uma eleição

### Candidatos

- `GET /api/candidates` - Lista todos os candidatos
- `GET /api/candidates/{id}` - Obtém um candidato específico
- `POST /api/candidates` - Cria um novo candidato
- `PUT /api/candidates/{id}` - Atualiza um candidato
- `DELETE /api/candidates/{id}` - Remove um candidato

## Testes

Para executar os testes:

```bash
./mvnw test
```

## Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Crie um Pull Request

## Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📚 Documentação

A documentação completa da API está disponível através do Swagger UI:
```
http://localhost:8080/swagger-ui
```

## 📦 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/
│   │       └── com/
│   │           └── politks/
│   │               ├── controller/
│   │               ├── service/
│   │               ├── repository/
│   │               ├── entity/
│   │               ├── dto/
│   │               └── mapper/
│   └── resources/
│       ├── db/
│       │   └── init/
│       └── application.properties
└── test/
    └── java/
        └── br/
            └── com/
                └── politks/
```

## 🔍 Monitoramento

- Health Check: `http://localhost:8080/health`
- Métricas: `http://localhost:8080/metrics`

## 🤝 Contribuindo

1. Faça o fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👥 Autores

- Seu Nome - [@seu-usuario](https://github.com/seu-usuario)

## 🙏 Agradecimentos

- Quarkus Team
- Hibernate Team
- PostgreSQL Team


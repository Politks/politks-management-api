# Politks Management API

API para gerenciamento de políticos, candidatos e eleições.

## Tecnologias Utilizadas

- Java 17
- Quarkus
- PostgreSQL
- Hibernate ORM
- Maven
- Docker

## Requisitos

- Java 17 ou superior
- Maven 3.8 ou superior
- Docker e Docker Compose
- PostgreSQL 14 ou superior

## Configuração do Ambiente

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/politks-management-api.git
cd politks-management-api
```

2. Configure as variáveis de ambiente:
```bash
cp .env.example .env
```

3. Inicie o banco de dados PostgreSQL usando Docker:
```bash
docker-compose up -d
```

4. Execute a aplicação em modo de desenvolvimento:
```bash
./mvnw quarkus:dev
```

## Endpoints da API

### Políticos
- `GET /api/politicians` - Lista todos os políticos
- `GET /api/politicians/{id}` - Obtém um político por ID
- `POST /api/politicians` - Cria um novo político
- `PUT /api/politicians/{id}` - Atualiza um político existente
- `DELETE /api/politicians/{id}` - Remove um político

### Candidatos
- `GET /api/candidates` - Lista todos os candidatos
- `GET /api/candidates/{id}` - Obtém um candidato por ID
- `POST /api/candidates` - Cria um novo candidato
- `PUT /api/candidates/{id}` - Atualiza um candidato existente
- `DELETE /api/candidates/{id}` - Remove um candidato

### Eleições
- `GET /api/elections` - Lista todas as eleições
- `GET /api/elections/{id}` - Obtém uma eleição por ID
- `POST /api/elections` - Cria uma nova eleição
- `PUT /api/elections/{id}` - Atualiza uma eleição existente
- `DELETE /api/elections/{id}` - Remove uma eleição

## Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

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

- Leonardo Freitas - [@leonardo.freitas](https://github.com/leo3965)

## 🙏 Agradecimentos

- Erick
- Thiago


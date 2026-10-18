# MovieFlix 🎬

API REST para gerenciamento de catálogo de filmes, desenvolvida com Java 17 e Spring Boot v4.1.1.

> Projeto de estudos para praticar desenvolvimento backend, segurança, persistência de dados e fluxo de colaboração com Git e GitHub.

## Tecnologias

- Java 17 e Spring Boot 3
- Spring Web, Spring Data JPA, Spring Security e Validation
- PostgreSQL e Flyway
- JWT (`com.auth0:java-jwt`)
- Lombok
- Springdoc OpenAPI / Swagger UI

## Funcionalidades planejadas

- [ ] Cadastro e consulta de categorias
- [ ] Cadastro e consulta de plataformas de streaming
- [ ] CRUD de filmes
- [ ] Consulta de filmes por categoria
- [ ] Cadastro e autenticação de usuários
- [ ] Autorização via JWT
- [ ] Validação de entrada e tratamento centralizado de erros
- [ ] Documentação OpenAPI e testes

## Como executar

**Pré-requisitos:** JDK 17, Maven (ou Maven Wrapper) e PostgreSQL.

1. Clone o repositório e abra a pasta no IntelliJ IDEA.
2. Crie o banco local `movieflix`.
3. Configure as credenciais do banco por variáveis de ambiente (consulte `application.yaml`).
4. Execute `./mvnw spring-boot:run` (Linux/macOS) ou `mvnw.cmd spring-boot:run` (Windows).

> As instruções de execução serão atualizadas conforme a implementação avançar. Nenhuma senha real deve ser enviada ao repositório.

## Estrutura planejada

```text
src/main/java/.../
  controller/
  service/
  repository/
  entity/
  dto/
  security/
  exception/
src/main/resources/
  application.yaml
  db/migration/
```

## Planejamento e contribuição

A evolução do projeto será organizada com **Issues**, **Milestones**, **branches** e **Pull Requests**. Consulte a aba Issues para acompanhar o andamento.

## Origem e créditos

Projeto desenvolvido para fins educacionais a partir de um roteiro de estudos de Java/Spring Boot. Material de referência: https://github.com/renanlessa/miniature-fortnight

## Licença

A definir. Caso seja adicionada uma licença, esta seção será atualizada.

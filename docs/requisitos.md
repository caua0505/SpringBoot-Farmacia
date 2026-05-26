# Requisitos do Projeto

## Requisitos Funcionais (RF)
* **RF01:** O sistema deve permitir a criação e autenticação de contas de usuário via token JWT.
* **RF02:** O sistema deve permitir o CRUD de usuários e manter suas credenciais seguras.
* **RF03:** O sistema deve permitir o CRUD de produtos (nome, categoria, preço, validade).
* **RF04:** O sistema deve controlar as quantidades de produtos em estoque de forma individualizada.
* **RF05:** O sistema deve registrar o histórico de movimentações, classificando o tipo da ação e a data do evento.

## Requisitos Não-Funcionais (RNF)
* **RNF01:** A aplicação deve ser desenvolvida em Java 17 com Spring Boot.
* **RNF02:** A arquitetura do sistema deve seguir o padrão de microsserviços.
* **RNF03:** A persistência dos dados deve ser feita no banco relacional MySQL utilizando Spring Data JPA.
* **RNF04:** A segurança da API deve ser garantida pelo Spring Security.
* **RNF05:** O projeto deve utilizar a biblioteca Lombok para manter o código-fonte enxuto e livre de verbosidade não essencial.
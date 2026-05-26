# Arquitetura do Sistema

O projeto foi estruturado utilizando a **Arquitetura de Microsserviços**, garantindo que diferentes domínios da farmácia funcionem de forma independente, modular e escalável. 

## Ecossistema de Serviços
A aplicação está dividida em 5 microsserviços principais:
1. **`auth-service`**: Responsável pela segurança, registro de credenciais e geração de tokens JWT.
2. **`usuario-service`**: Gerencia os dados e perfis dos usuários do sistema.
3. **`produto-service`**: Focado no catálogo e informações descritivas dos produtos.
4. **`estoque-service`**: Controla as quantidades disponíveis de cada produto.
5. **`movimentacao-service`**: Registra o histórico de entradas e saídas.

## Estrutura Interna (Padrão em Camadas)
Apesar de independentes, todos os microsserviços compartilham a mesma padronização interna de pastas para manter a consistência do código:
* **`/controller`**: Camada de interface que expõe os endpoints HTTP e recebe as requisições.
* **`/service`**: Camada que encapsula todas as validações e regras de negócio.
* **`/repository`**: Interfaces do Spring Data JPA responsáveis pelas consultas e persistência no banco.
* **`/entity`**: Modelos de domínio que mapeiam as tabelas do MySQL.
* **`/dto`**: Objetos de transferência de dados que definem os contratos de entrada e saída das APIs.

## Stack Tecnológica
* **Back-end:** Java 17, Spring Boot, Spring WebMVC.
* **Persistência:** MySQL e Spring Data JPA.
* **Segurança:** Spring Security com JWT (JSON Web Tokens).
* **Utilitários:** Lombok.
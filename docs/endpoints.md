# Endpoints da API

Abaixo estão as rotas mapeadas no sistema, divididas por microsserviço.

## Autenticação (`/auth`)
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/auth/register` | Registra um novo usuário com credenciais de acesso. |
| `POST` | `/auth/login` | Autentica o usuário e retorna o token JWT. |
| `GET` | `/teste/protegido` | Rota de teste para validação do token JWT. |

## Usuários (`/usuarios`)
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/usuarios` | Cadastra um novo usuário. |
| `GET` | `/usuarios` | Lista todos os usuários cadastrados. |
| `GET` | `/usuarios/{id}` | Busca um usuário específico pelo ID. |
| `PUT` | `/usuarios/{id}` | Atualiza os dados de um usuário. |
| `DELETE`| `/usuarios/{id}` | Deleta um usuário do sistema. |

## Produtos (`/produtos`)
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/produtos` | Cadastra um novo produto no catálogo. |
| `GET` | `/produtos` | Lista todos os produtos. |
| `GET` | `/produtos/{id}` | Busca um produto pelo ID. |
| `PUT` | `/produtos/{id}` | Atualiza as informações de um produto. |
| `DELETE`| `/produtos/{id}` | Remove um produto do banco. |

## Estoque (`/estoques`)
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/estoques` | Cria o registro inicial de estoque para um produto. |
| `GET` | `/estoques` | Lista os estoques de todos os produtos. |
| `GET` | `/estoques/{id}` | Busca o estoque pelo ID do registro. |
| `PUT` | `/estoques/{id}` | Atualiza a quantidade em estoque de um produto. |
| `DELETE`| `/estoques/{id}` | Deleta o registro de estoque. |

## Movimentações (`/movimentacao`)
| Método | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/movimentacao` | Registra uma nova entrada ou saída de produto. |
| `GET` | `/movimentacao` | Lista o histórico de movimentações. |
| `GET` | `/movimentacao/{id}` | Busca uma movimentação específica. |
| `PUT` | `/movimentacao/{id}` | Atualiza os dados de uma movimentação. |
| `DELETE`| `/movimentacao/{id}` | Apaga o registro de uma movimentação. |
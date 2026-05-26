# Regras de Negócio

Este documento descreve as validações e lógicas processadas pelo sistema.

## Autenticação e Segurança
1. **Unicidade de E-mail:** O sistema impede o registro de contas com e-mails já existentes.
2. **Criptografia:** Senhas são codificadas usando `PasswordEncoder` antes do armazenamento.
3. **Validação de Login:** O acesso só é liberado mediante a verificação da senha criptografada. Em caso de sucesso, a API gera e retorna um token JWT (Bearer).
4. **Preenchimento Automático:** Ao criar uma conta, o sistema define automaticamente a data de criação, marca o usuário como ativo e atribui o perfil padrão `USER`.

## Gerenciamento de Estoque e Movimentação
1. **Estoque Único por Produto:** Não é permitido criar mais de um registro de estoque para o mesmo `produtoId`. Caso o produto já tenha um estoque atrelado, o sistema lança uma `BusinessException`.
2. **Atualização Livre de Movimentações:** É possível editar os detalhes de uma movimentação (tipo, quantidade, data e produto vinculado) sobrescrevendo o registro anterior.

## Regras Gerais de Sistema (Usuários e Produtos)
1. **Integridade de Dados:** Campos essenciais como nome, e-mail, senha e ID de produtos não podem ser nulos no banco de dados.
2. **Validação de Existência:** Qualquer operação de busca, edição ou exclusão verifica se o ID alvo existe. Caso não exista, o sistema aborta a operação e retorna um erro de recurso não encontrado.
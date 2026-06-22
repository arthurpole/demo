# Sistema de Atendimento

Projeto JavaFX para atendimento em restaurantes, lancherias ou quiosques. O sistema permite que o usuario escolha entre acesso de cliente ou estabelecimento.

## Funcionalidades

### Cliente

- Visualizar opcoes de itens para pedido.
- Adicionar itens ao pedido.
- Remover itens do pedido.
- Visualizar resumo com quantidade de itens e valor total.
- Confirmar o pedido e gerar um numero de atendimento.

### Estabelecimento

- Visualizar atendimentos realizados.
- Acompanhar os itens de cada atendimento.
- Atualizar o status do atendimento.
- Status disponiveis: 'Em preparo', 'Pronto' e 'Entregue'.

## Estrutura principal

- src/main/java/br/feevale/helloworld/App.java: classe principal da aplicacao JavaFX.
- src/main/java/br/feevale/helloworld/MenuController.java: controla a tela inicial de escolha do perfil.
- src/main/java/br/feevale/helloworld/ClienteController.java: controla a tela do cliente.
- src/main/java/br/feevale/helloworld/EstabelecimentoController.java: controla a tela do estabelecimento.
- src/main/java/br/feevale/helloworld/model: classes de dados/modelo.
- src/main/java/br/feevale/helloworld/service: classe de servico responsavel pelos atendimentos.
- src/main/resources/br/feevale/helloworld: arquivos FXML das telas.

## Conceitos de POO usados

- Encapsulamento: atributos privados e acesso por metodos.
- Heranca: 'Lanche' e 'Bebida' herdam de 'ItemAtendimento'; 'PedidoRestaurante' herda de 'Atendimento'.
- Polimorfismo: itens diferentes sao tratados como 'ItemAtendimento'.
- Classes abstratas: 'ItemAtendimento' e 'Atendimento'.
- Interface: 'AtualizavelStatus'.
- Colecoes: uso de 'ArrayList' para armazenar itens e atendimentos.

## Como executar

### Opcao 1: pelo Maven

Requisitos:

- Java JDK instalado.
- Maven instalado e configurado no PATH.

Na raiz do projeto, onde esta o arquivo 'pom.xml', execute:

--- bash ---
mvn javafx:run
---

### Opcao 2: pela IDE

Abra o projeto pela pasta que contem o 'pom.xml', por exemplo:

--- text ---
PreProjetoProgI/demo
---

Depois execute a classe principal:

--- text ---
br.feevale.helloworld.App
---

Se a IDE pedir configuracao do JavaFX, use as dependencias indicadas no 'pom.xml'.

## Como testar manualmente

### Teste 1: acesso inicial

1. Execute o projeto.
2. Verifique se a primeira tela exibida é 'Sistema de Atendimento'.
3. Clique em 'Sou Cliente'.
4. Confirme que a tela 'Cliente - Pedido' foi aberta.
5. Clique em 'Voltar ao menu'.
6. Clique em 'Sou Estabelecimento'.
7. Confirme que a tela 'Estabelecimento - Atendimentos' foi aberta.

### Teste 2: criar pedido como cliente

1. Acesse a tela do cliente.
2. Selecione um item no combo de opcoes.
3. Clique em 'Adicionar'.
4. Confira se o item apareceu na lista.
5. Confira se o total foi atualizado.
6. Adicione mais um item.
7. Selecione um item da lista e clique em 'Remover item'.
8. Clique em 'Confirmar pedido'.
9. Verifique se apareceu uma mensagem com o numero do atendimento gerado.

### Teste 3: acompanhar pedido no estabelecimento

1. Depois de confirmar um pedido, volte ao menu.
2. Acesse 'Sou Estabelecimento'.
3. Confira se o atendimento aparece na lista.
4. Selecione o atendimento.
5. Confira se os itens e o total aparecem nos detalhes.
6. Escolha o status 'Pronto'.
7. Clique em 'Atualizar status'.
8. Confira se o status foi alterado.
9. Repita o processo com o status 'Entregue'.

### Teste 4: validacoes simples

1. Na tela do cliente, clique em 'Confirmar pedido' sem adicionar itens.
2. O sistema deve informar que e necessario adicionar pelo menos um item.
3. Na tela do cliente, clique em 'Remover item' sem selecionar nada.
4. O sistema deve informar que e necessario selecionar um item.
5. Na tela do estabelecimento, tente atualizar sem selecionar atendimento.
6. O sistema deve pedir a selecao de um atendimento e de um status.
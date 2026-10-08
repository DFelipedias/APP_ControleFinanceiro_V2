# Controle Financeiro V2

Trabalho 2 Mínimo Aplicativo Funcional

Integrantes: Daniel, Leonardo e Marcelo

Repositório: https://github.com/DFelipedias/APP_ControleFinanceiro_V2

## 1 Evolução da primeira entrega

Na primeira entrega, fizemos três telas: Visão Geral, Extrato e Nova Transação. Daniel ficou com a Visão Geral, Leonardo com o Extrato e Marcelo com Nova Transação. O objetivo era montar a interface usando os componentes vistos em aula.

Para o Trabalho 2, mantivemos o fundo claro, os botões azuis e o card escuro de saldo. A mudança principal foi conectar as telas e trocar os dados fixos por listas que podem ser alteradas durante o uso. O formulário passou a cadastrar transações, e o saldo passou a ser calculado a partir das receitas e despesas.

> **INSERIR PRINT:** Primeira entrega com Visão Geral Extrato e Nova Transação lado a lado

> **INSERIR PRINT:** Visão Geral da segunda entrega após cadastrar uma transação

## 2 Telas escolhidas e suas funções

Escolhemos Transação e Categoria como os dois tipos de item. Categoria já aparecia na primeira versão e ajuda a organizar os registros do usuário. Por isso, as novas telas continuam a proposta original do aplicativo.

| Tela | Função |
|---|---|
| Visão Geral | Mostra saldo, receitas, despesas e últimas transações. |
| Extrato | Lista transações, pesquisa, filtra por categoria e permite remover. |
| Nova Transação | Cadastra receita ou despesa com valor, descrição, categoria e data. |
| Detalhes da Transação | Abre o registro clicado e permite editar descrição, valor e data. |
| Categorias | Lista os grupos de transações e permite remover categorias sem registros vinculados. |
| Nova Categoria | Cadastra o nome e a descrição de uma categoria. |
| Detalhes da Categoria | Combina as listas para mostrar totais e registros daquela categoria. |

A barra inferior organiza Início, Extrato e Categorias. Os formulários e detalhes são acessados por botões e cards. As telas secundárias têm botão de voltar.

> **INSERIR PRINT:** Barra inferior funcionando e exemplos das novas telas

## 3 Organização do código e navegação

A MainActivity abre o AppNavigation. Nesse arquivo fica o NavHost central, que conecta as sete telas. O objeto Rotas guarda os nomes das rotas como constantes, evitando repetir textos diferentes em cada botão.

As duas listas ficam no FinanceiroViewModel, usando mutableStateListOf. O ViewModel é criado uma vez no AppNavigation e compartilhado entre as telas. Assim, a transação cadastrada aparece no Extrato e também altera os resumos da Visão Geral.

Cada tela tem seu próprio arquivo. A barra inferior, a barra superior, os campos e os cards compartilhados ficaram em Componentes.kt. Essa divisão facilita encontrar a parte que precisa ser ajustada e reaproveitar o mesmo visual.

> **INSERIR PRINT:** Navegação entre as três áreas principais e botão voltar nos detalhes

## 4 Complexidade extra nos detalhes

Nos Detalhes da Categoria, buscamos as transações que têm o ID daquela categoria e calculamos os totais de receitas e despesas. A tela também mostra os registros relacionados e permite abrir os detalhes de cada um. Escolhemos isso porque ajuda a entender para onde o dinheiro está indo.

Os Detalhes da Transação também permitem editar descrição, valor e data. A alteração atualiza o item na lista e muda os resumos. Os detalhes recebem o ID pela rota, então cada card abre as informações do registro correto.

> **INSERIR PRINT:** Detalhes de uma categoria mostrando totais e transações relacionadas

## 5 Ajustes e decisões durante a evolução

Um problema da primeira versão era que a MainActivity chamava Nova Transação e Extrato no mesmo conteúdo, sem uma navegação que escolhesse a tela. Na segunda versão, o NavHost passou a controlar qual tela aparece. A Visão Geral também passou a fazer parte desse fluxo.

Outro ponto foi evitar listas separadas em cada tela. Concentramos os dados no ViewModel para que cadastro, consulta, edição e remoção trabalhem com os mesmos registros. Para atualizar uma transação editada, substituímos o item na posição correspondente da lista reativa.

Também definimos que uma categoria com transações não pode ser removida. O aplicativo mostra uma mensagem nesse caso. Isso evita deixar registros ligados a uma categoria que deixou de existir.

Os formulários conferem campos obrigatórios, valores positivos e nomes de categoria repetidos. A data continua sendo digitada em texto e é conferida pelo formato dd/mm/aaaa. Os dados ficam só na memória, conforme permitido no enunciado.

## 6 Participação e dificuldades do trio

Sugestão de divisão para a segunda entrega: Daniel acompanha a Visão Geral e a navegação; Leonardo acompanha o Extrato, os filtros e os detalhes de transação; Marcelo acompanha os formulários e as categorias. O trio deve confirmar essa divisão conforme o trabalho realizado.

Para o relato de dificuldade, o grupo pode explicar como lidou com os pontos descritos acima: conectar as telas, compartilhar as listas e atualizar os resumos. Acrescentar aqui os nomes dos envolvidos e o que realmente ocorreu durante o teste no Android Studio.

> **INSERIR PRINT:** Etapa de desenvolvimento ou ajuste no Android Studio

## 7 Verificação e apresentação

Antes da entrega, precisamos rodar o projeto no Android Studio e registrar as imagens do app funcionando. A compilação no ambiente de preparação não pôde ser concluída porque o download do Gradle foi bloqueado pela rede. Não há ainda resultado de teste no emulador.

Na apresentação, o grupo deve demonstrar o cadastro e a remoção nas duas listas, abrir itens diferentes para mostrar os detalhes corretos, editar uma transação e navegar pela barra inferior. O roteiro abaixo serve para registrar a verificação final.

- [ ] Abrir o projeto e compilar sem erros.
- [ ] Cadastrar receita e despesa e conferir o saldo.
- [ ] Pesquisar e filtrar transações no Extrato.
- [ ] Abrir dois itens diferentes e conferir os detalhes.
- [ ] Editar uma transação e conferir os resumos.
- [ ] Cadastrar e remover uma categoria sem registros.
- [ ] Conferir o total calculado nos Detalhes da Categoria.
- [ ] Testar todos os botões e o retorno entre telas.
- [ ] Inserir os prints e finalizar a documentação antes do prazo.
> **INSERIR PRINT:** Cadastro e remoção de transações antes e depois

> **INSERIR PRINT:** Cadastro e remoção de categorias antes e depois

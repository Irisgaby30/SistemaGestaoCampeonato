# Sistema Gestão Campeonato 🏆 ⚽

 projeto desenvolvido para a disciplina de **Programção 2** na **UFRPE - Unidade Acadêmcia de Belo Jardim**

 # 📌 Sobre o Projeto 

  O sistema visa gerenciar partidas,times e estatísticas de uma campeonato esportivo,aplicando conceitos de Orientação a Objetos em java.

  # 🚀 Funcionalidades 
  - [x] Planejamento e modelagem 
  - [] Cadastro de times e jogadores
  - [] Registro de Partidas e Placares 
  - [] Cálculo automático de tabela de pontos 
  - [] Listagem de artilharia

 ## 🏗️ Modelagem do Sistema

### Classe: Jogador
* **Atributos:**
    * `String nome`
    * `String posicao`
    * `int golsMarcados`
* **Métodos:**
    * `registrarGol()`: Incrementa o contador de gols do jogador.

### Classe: Time
* **Atributos:**
    * `String nome`
    * `List<Jogador> jogadores`
    * `int pontos`
    * `int vitorias, empates, derrotas`
* **Métodos:**
    * `adicionarJogador(Jogador jogador)`: Vincula um novo atleta ao time.
    * `atualizarEstatisticas(int golsPro, int golsContra)`: Calcula a pontuação.

### Classe: Partida
* **Atributos:**
    * `Time mandante`
    * `Time visitante`
    * `int golsMandante`
    * `int golsVisitante`
    * `boolean finalizada`
* **Métodos:**
    * `encerrarPartida(int placarM, int placarV)`: Define o resultado final.

### Classe: Campeonato
* **Atributos:**
    * `String nome`
    * `List<Time> timesParticipantes`
    * `List<Partida> tabelaJogos`
* **Métodos:**
    * `gerarClassificacao()`: Ordena os times por pontos.
    * `listarArtilheiro()`: Identifica o jogador com mais gols.

  ## 🛠️ Tecnologias 
  - Java
  - Vs Code 
  - Git/Github

  ## 👩‍💻 Autora 
  - Nome: Iris Gabriely Rocha Soares Oliveira 
  - Instituição: UFRPE -UBAJ
  - Professor: Anderson Cavalcanti 
  - Curso: Engenharia de Computação 

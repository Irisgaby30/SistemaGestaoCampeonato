import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static ArrayList<Time> listaTimes = new ArrayList<>();
    private static Campeonato campeonatoAtivo = new Campeonato("Brasileirao Feminino");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        inicializarDadosFicticios();

        do {
            System.out.println("\n--- GESTÃO DE CAMPEONATO ---");
            System.out.println("1. Adicionar Time");
            System.out.println("2. Listar Times");
            System.out.println("3. Editar Nome do Time");
            System.out.println("4. Remover Time");
            System.out.println("5. Simular Partida com Gols (Atualiza Tabela/Artilharia)");
            System.out.println("6. Exibir Classificação e Artilharia");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Novo Time: ");
                    String nome = scanner.nextLine();
                    Time novo = new Time(nome);
                    listaTimes.add(novo);
                    campeonatoAtivo.getTimesParticipantes().add(novo);
                    System.out.println("Time adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- TIMES CADASTRADOS ---");
                    if (listaTimes.isEmpty()) {
                        System.out.println("Nenhum time disponível.");
                    } else {
                        for (int i = 0; i < listaTimes.size(); i++) {
                            System.out.println("[" + i + "] " + listaTimes.get(i).getNome());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Informe o índice do time que deseja editar: ");
                    int idxEditar = scanner.nextInt();
                    scanner.nextLine();
                    if (idxEditar >= 0 && idxEditar < listaTimes.size()) {
                        System.out.print("Novo nome: ");
                    listaTimes.get(idxEditar).setNome(scanner.nextLine());
                        System.out.println("Nome atualizado!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 4:
                    System.out.print("Informe o índice do time que deseja remover: ");
                    int idxRemover = scanner.nextInt();
                    if (idxRemover >= 0 && idxRemover < listaTimes.size()) {
                        Time removido = listaTimes.remove(idxRemover);
                        campeonatoAtivo.getTimesParticipantes().remove(removido);
                        System.out.println("Time removido!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 5:
                    rodarSimulacaoJogo(scanner);
                    break;

                case 6:
                    campeonatoAtivo.gerarClassificacao();
                    campeonatoAtivo.listarArtilheiro();
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void inicializarDadosFicticios() {
        Time t1 = new Time("Corinthians");
        Jogador j1 = new Jogador("Iris", "Atacante");
        t1.adicionarJogador(j1);
        
        Time t2 = new Time("Sport Recife");
        Jogador j2 = new Jogador("Mariana", "Meia");
        t2.adicionarJogador(j2);

        listaTimes.add(t1);
        listaTimes.add(t2);
        campeonatoAtivo.getTimesParticipantes().add(t1);
        campeonatoAtivo.getTimesParticipantes().add(t2);
    }

    private static void rodarSimulacaoJogo(Scanner sc) {
        if (listaTimes.size() < 2) {
            System.out.println("Cadastre pelo menos 2 times para simular uma partida.");
            return;
        }
        Time m = listaTimes.get(0);
        Time v = listaTimes.get(1);

        System.out.println("\nSimulando partida entre: " + m.getNome() + " x " + v.getNome());
        System.out.print("Gols do " + m.getNome() + ": ");
        int golsM = sc.nextInt();
        System.out.print("Gols do " + v.getNome() + ": ");
        int golsV = sc.nextInt();

        Partida p = new Partida(m, v);
        p.encerrarPartida(golsM, golsV);
        campeonatoAtivo.getTabelaJogos().add(p);

        // Simulando atribuição de gols para os artilheiros do time mandante
        if (golsM > 0 && !m.getJogadores().isEmpty()) {
            m.getJogadores().get(0).registrarGol();
            System.out.println("Gol registrado para o jogador: " + m.getJogadores().get(0).getNome());
        }

        System.out.println("Resultado processado e classificação atualizada!");
    }
}

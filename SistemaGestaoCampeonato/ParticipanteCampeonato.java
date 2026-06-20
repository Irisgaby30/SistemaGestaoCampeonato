package SistemaGestaoCampeonato;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class InscricaoInvalidaException extends Exception {
    public InscricaoInvalidaException(String mensagem) {
        super(mensagem);
    }
}
class Jogadora {
    private String nome;
    private String time;

    public Jogadora(String nome, String time) {
        this.nome = nome;
        this.time = time;
    }

    public String getNome() { return nome; }
    public String getTime() { return time; }

    // Método que será alvo do Polimorfismo
    public void exibirDadosContrato() {
        System.out.println("Atleta: " + nome + " | Clube: " + time);
    }
}
class JogadoraProfissional extends Jogadora {
    private double salario;

    public JogadoraProfissional(String nome, String time, double salario) {
        super(nome, time);
        this.salario = salario;
    }
    @Override
    public void exibirDadosContrato() {
        System.out.printf("[PROFISSIONAL] %s (%s) | Contrato Profissional | Salário: R$ %.2f\n", 
                getNome(), getTime(), salario);
    }
}
class JogadoraBase extends Jogadora {
    private int idade;

    public JogadoraBase(String nome, String time, int idade) {
        super(nome, time);
        this.idade = idade;
    }
    @Override
    public void exibirDadosContrato() {
        System.out.println("[BASE SUB-20] " + getNome() + " (" + getTime() + ") | Registro de Formação | Idade: " + idade + " anos");
    }
}
public class ParticipanteCampeonato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jogadora> bidCbf = new ArrayList<>();

        System.out.println("=== INSCRIÇÃO DE ATLETAS - BRASILEIRÃO FEMININO ===");

        try {
            System.out.println("\n[Inscricao 1 - Atleta Profissional]");
            System.out.print("Nome da Jogadora: ");
            String nomeProf = scanner.nextLine();
            System.out.print("Time: ");
            String timeProf = scanner.nextLine();
            System.out.print("Salário em Carteira: R$ ");
            double salario = scanner.nextDouble();
            scanner.nextLine(); 
            if (salario < 0) {
                throw new InscricaoInvalidaException("O salário de um contrato profissional não pode ser negativo!");
            }
            bidCbf.add(new JogadoraProfissional(nomeProf, timeProf, salario));

            System.out.println("--------------------------------------------------");
            System.out.println("\n[Inscricao 2 - Atleta da Base promovida]");
            System.out.print("Nome da Jogadora: ");
            String nomeBase = scanner.nextLine();
            System.out.print("Time: ");
            String timeBase = scanner.nextLine();
            System.out.print("Idade da Atleta: ");
            int idade = scanner.nextInt();
            if (idade < 14 || idade > 20) {
                throw new InscricaoInvalidaException("Idade incompatível para inscrição como atleta de formação (mínimo 14, máximo 20 anos)!");
            }
            bidCbf.add(new JogadoraBase(nomeBase, timeBase, idade));
            System.out.println("\n=== ATLETAS REGULARIZADAS NO BID (Polimorfismo) ===");
            for (Jogadora j : bidCbf) {
                j.exibirDadosContrato(); 
            }

        } catch (InputMismatchException e) {
            System.out.println("\n[ERRO DE FORMATAÇÃO]: Você inseriu texto onde o sistema esperava números!");
        } catch (InscricaoInvalidaException e) {
            System.out.println("\n[CONFLITO COM O REGULAMENTO]: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nProcesso encerrado.");
        }
    }
}
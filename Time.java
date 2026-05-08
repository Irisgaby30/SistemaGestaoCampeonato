import java.util.ArrayList;

public class Time {
    private String nome;
    private ArrayList<Jogador> jogadores;
    private int pontos;
    private int vitorias;
    private int empates;
    private int derrotas;
    public Time(String nome){
        this.nome=nome;
        this.jogadores=new ArrayList<>();
        this.pontos=0;
        this.vitorias=0;
        this.empates=0;
        this.derrotas=0;
    }
    public void
    adicionarJogador(Jogador jogador){
        this.jogadores.add(jogador);
    }
    public void registrarResultado(int golsPro, int golsContra){
        if (golsPro > golsContra){
            this.vitorias++;
            this.pontos +=3;
        } else if(golsPro == golsContra){
            this.empates++;
            this.pontos +=1;
        } else{
            this.derrotas++;
        }
    }
    public String getNome(){
        return nome;
    }
    public int getPontos(){
        return pontos;
    }
    public ArrayList<Jogador> getJogadores(){
        return jogadores;
    }
}

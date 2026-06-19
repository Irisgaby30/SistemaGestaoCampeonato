package SistemaGestaoCampeonato;
public class Jogador {
    private String nome;
    private String posicao;
    private int golsMarcados;
    public Jogador(String nome, String posicao){
        this.nome=nome;
        this.posicao=posicao;
        this.golsMarcados=0;
    }
    public void registrarGol(){
        this.golsMarcados++;
        System.out.println("GOOL de" + this.nome + "!");
    }
    public String getNome(){
        return nome;
    }
    public String getPosicao(){
        return posicao;
    }
    public int getgolsMarcados(){
        return golsMarcados;
    }
}

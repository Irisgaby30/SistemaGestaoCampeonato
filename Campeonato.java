import java.util.ArrayList;

public class Campeonato {
    private String nome;
    private ArrayList<Time> times;
    private ArrayList<Partida> partidas;
    public Campeonato (String nome){
        this.nome=nome;
        this.times = new ArrayList<>();
        this.partidas=new ArrayList<>();
    }
    public void adicionarTime(Time time){
        this.times.add(time);
    }
    public void registrarPartida (Partida partida){
        this.partidas.add(partida);
    }
    public void mostrarClassificacao(){
        System.out.println("\n--- tabela do Campeonato:"+ this.nome + "---");
        for (Time t: times){
            System.out.println(t.getNome()+"- Pontos:"+t.getPontos());
        }
    }
    public String getNome(){
        return nome;
    }
}

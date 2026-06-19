package SistemaGestaoCampeonato;
public class Partida {
    private Time mandante;
    private Time visitante;
    private int golsMandante;
    private int golsVisitante;
    private boolean finalizada;
    public Partida(Time mandante, Time visitante){
        this.mandante=mandante;
        this.visitante=visitante;
        this.finalizada=false;
    }
    public void encerrarPartida(int placarM , int placarV){
        this.golsMandante=placarM;
        this.golsVisitante=placarV;
        this.finalizada=true;
        mandante.registrarResultado(placarM,placarV);
        visitante.registrarResultado(placarV,placarM);
        System.out.println("Partida finalizada:"+ mandante.getNome()+ " "+ placarM + "x" + placarV + " " + visitante.getNome());
    }
    public Time getMandantes(){
        return mandante;
    }
    public Time getVisitante(){
        return visitante;
    }
}

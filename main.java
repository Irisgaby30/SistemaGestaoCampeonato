public class Main {
    public static void main(String[] args) {
        Campeonato copadoBrasil = new Campeonato("Copa do Brasil");
        Time sport = new Time("Sport Recife");
        Time Corinthians = new Time("Corinthians");
        Jogador j1= new Jogador("Iris Gabriely","Atacante");
        sport.adicionarJogador(j1);
        copadoBrasil.adicionarTime(sport);
        copadoBrasil.adicionarTime(Corinthians);
        Partida jogo1 = new Partida(sport,Corinthians);
        jogo1.encerrarPartida(1,2);
        copadoBrasil.mostrarClassificacao();
    }  
}
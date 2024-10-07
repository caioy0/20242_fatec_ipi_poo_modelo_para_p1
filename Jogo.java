import java.util.Random;

public class Jogo{
    public static void main(String[] args) throws InterruptedException {
        //inicializacao de variaveis
        var player1 = new Personagem(); //variavel de referencia
        player1.nome = "Robson";
        var gerador = new Random(); //variavel de referencia que faz as movimentacoes
        
        //loop infinito
        while (true) {
            var acaoDoPlayer1 = gerador.nextInt(3)+1; //movimentacao aleatoria/gera valor entre 1 e 3 == cacar, comer, dormir
            if (player1.energia <= 0){
                player1.morte();
                break;
            }
            switch(acaoDoPlayer1){
                case 1:
                    player1.cacar();
                    break;
                case 2:
                    player1.comer();
                    break;
                case 3:
                    player1.dormir();
                    break;
            }
            System.out.println(player1); //exibir estado do player1
            System.out.println("***********");
            Thread.sleep(5000); //"dormir" buffer para o terminal de 5s.
        }
    }   
}
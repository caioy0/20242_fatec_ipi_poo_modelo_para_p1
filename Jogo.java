import java.util.Random;

public class Jogo{
    public static void main(String[] args) throws InterruptedException {
        //inicializacao de variaveis
        var player1 = new Personagem(); //variavel de referencia
        player1.nome = "Robson";
        var player2 = new Personagem(2,10,10);
        player2.nome = "Zé Preguiça";
        var gerador = new Random(); //variavel de referencia que faz as movimentacoes
        
        //loop infinito
        while(true){
            var acaoDoPlayer1 = gerador.nextInt(3)+1; //movimentacao aleatoria/gera valor entre 1 e 3 == cacar, comer, dormir
            if (player1.energia <= 0){
                player1.morte();
            }else{
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
            }
            
            var acaoDoPlayer2 = gerador.nextInt(10)+1; //movimentacao aleatoria/gera valor entre 1 e 10 == 10%cacar, 30%comer, 60%dormir
            if (player2.energia <= 0){
                player2.morte();
            }
            else{
                if (acaoDoPlayer2 <= 6){ //60% 1 ate 6 ele dorme
                    player2.dormir();
                }else if (acaoDoPlayer2 <= 9){ //30% 7 ate 9 ele come
                    player2.comer();
                }else { //10% no n10 ele caca.
                    player2.cacar();
                }
                System.out.println(player2); //exibir estado do player2
                System.out.println("***********");
            }

            if (player1.energia <= 0 && player2.energia <= 0){
                System.out.println(
                    player1.nome + " e " + player2.nome + " morreram. \nFim de jogo."
                    );
                break;
            }
            Thread.sleep(5000); //"dormir" buffer para o terminal de 5s.
        }
    }   
}
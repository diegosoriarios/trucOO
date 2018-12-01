package teste;

import javax.swing.JOptionPane;

import Modelos.Basto;
import Modelos.Cartas;
import Modelos.Copas;
import Modelos.Espada;
import Modelos.Ouro;
import Modelos.Player;
import Modelos.Partida;

import java.util.Random;

public class Main{
    Object[] confirmacao = {"Sim", "Não"};
    
    public static void main(String[] args){
        
        int j = 0;
        Object[] confirmacao = {"Sim", "Não"};
        Partida p = new Partida();
        Player jogador1 = new Player("Paulo");
        Player jogador2 = new Player("Diego");
        Player player1 = null;
        Player player2 = null;
        
        Object[] players = {jogador1.getNome(), jogador2.getNome()};
        do{
            int o = JOptionPane.showOptionDialog(null, "Escolha o mão", "Escolha mão", JOptionPane.WARNING_MESSAGE, 1, null, players, players[0]);
            System.out.println(o);
            switch(o) {
                case 0:
                    jogador1.setMao(true);
                    player1 = jogador1;
                    player2 = jogador2;
                    break;
                case 1:
                    jogador2.setMao(true);
                    player1 = jogador2;
                    player2 = jogador1;
                    break;
            }
        }while(!(jogador1.isMao() || jogador2.isMao()));


            Object[] gritos = {"Envido", "Flor", "Truco", "Soltar Carta"};

            darCartas(player1, player2, p);

            String cartasPlayer1 = player1.listaCarta[0].toString() + player1.listaCarta[1].toString() + player1.listaCarta[2].toString();
            String cartasPlayer2 = player2.listaCarta[0].toString() + player2.listaCarta[1].toString() + player2.listaCarta[2].toString();
        
       int pontoRodada = 0;
        while(j < 3){
            System.out.println("j: " + j);    
            if(player1.isMao()){
                //começa o loop do Envido/Flor pra voltar a escolher o que fazer 
                //for(int x = 0; i < 3; i++)
                if(j != 0){
                    gritos[0] = "";
                    gritos[1] = "";
                } 
                if(pontoRodada == 0){
                    gritos[2] = "Truco";
                }else{
                    if(pontoRodada == 1){
                        gritos[2] = "Retruco";
                    }else{
                        if(pontoRodada == 2){
                            gritos[2] = "Vale Quatro";
                        }
                    }
                }
                
                int escolha = JOptionPane.showOptionDialog(null, cartasPlayer1 , player1.getNome(), JOptionPane.WARNING_MESSAGE, 0, null, gritos, gritos[0]);
                switch(escolha){
                    case 0:
                     if(j != 0){
                         JOptionPane.showMessageDialog(null, "Escolha uma opção valida!!");
                         j-=2;
                         break;
                     }
                     gritos[0] = "";
                     String[] envidoOpt = {"Não Quero", "Quero", "Real Envido", "Falta Envido"};
                     int envido = JOptionPane.showOptionDialog(null, cartasPlayer2, player2.getNome() + " aceita o envido?", JOptionPane.YES_NO_OPTION, 0, null, envidoOpt, envidoOpt[0]);
                        if(envido == 1){
                            int envP1 = p.calculaEnvido(player1.listaCarta);
                            int envP2 = p.calculaEnvido(player2.listaCarta);
                            System.out.println("Quero");
                            System.out.println(envP1);
                            System.out.println(envP2);
                            int g = p.venceChamada(player1.isMao(), envP1, envP2);
                            if(g == 1){
                                p.adicionaPontos(player1, p.verificaPontos("Envido"));
                            }else{
                                p.adicionaPontos(player2, p.verificaPontos("Envido"));
                            }
                        }else{
                            if(envido == 2){
                                int resposta_envido = JOptionPane.showOptionDialog(null, cartasPlayer1, player1.getNome() + " aceita o real envido?", JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                                if(resposta_envido == 1){
                                    int envP1 = p.calculaEnvido(player1.listaCarta);
                                    int envP2 = p.calculaEnvido(player2.listaCarta);
                                    int g = p.venceChamada(player1.isMao(), envP1, envP2);
                                    if(g == 1){
                                        p.adicionaPontos(player1, p.verificaPontos("RealEnvido"));
                                    }else{
                                        p.adicionaPontos(player2, p.verificaPontos("RealEnvido"));
                                    }
                                }else{
                                    p.adicionaPontos(player2, p.verificaPontos("Envido"));
                                }
                            }else{
                                if(envido == 3){
                                    int resposta_envido = JOptionPane.showOptionDialog(null, cartasPlayer1, player2.getNome() + " aceita a Falta Envido?", JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                                    if(resposta_envido == 1){
                                        int envP1 = p.calculaEnvido(player1.listaCarta);
                                        int envP2 = p.calculaEnvido(player2.listaCarta);
                                        int g = p.venceChamada(player1.isMao(), envP1, envP2);
                                        if(g == 1){
                                            p.adicionaPontos(player1, p.verificaPontos("FaltaEnvido"));
                                        }else{
                                            p.adicionaPontos(player2, p.verificaPontos("FaltaEnvido"));
                                        }
                                    }else{
                                        p.adicionaPontos(player2, p.verificaPontos("Envido"));
                                    }
                                }else{
                                    p.adicionaPontos(player2, p.verificaPontos("Nao"));
                                }    
                            }
                        }
                        break;
                    case 1:
                    if(j != 0){
                        JOptionPane.showMessageDialog(null, "Escolha uma opção valida!!");
                        j-=2;
                        break;
                    }
                    String[] florOpt = {"É bom...", "Contra Flor", "Flor ao Resto"};
                    int flor = JOptionPane.showOptionDialog(null, "FLOR", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, florOpt, florOpt[0]);
                        if(flor == 0){
                            p.adicionaPontos(player1, p.verificaPontos("Flor"));
                        }else{
                            if(flor == 1){
                                int resposta_flor = JOptionPane.showOptionDialog(null, "Aceita a Falta Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                                if(resposta_flor == 0){
                                    int florP1 = p.calculaFlor(player1.listaCarta);
                                    int florP2 = p.calculaFlor(player2.listaCarta);
                                    int g = p.venceChamada(player1.isMao(), florP1, florP2);
                                    if(g == 1){
                                        p.adicionaPontos(player1, p.verificaPontos("ContraFlor"));
                                    }else{
                                        p.adicionaPontos(player2, p.verificaPontos("ContraFlor"));
                                    }
                                }else{
                                    p.adicionaPontos(player2, p.verificaPontos("Flor"));
                                }
                            }else{
                                int resposta_flor = JOptionPane.showOptionDialog(null, "Aceita a Falta Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                                if(resposta_flor == 0){
                                    int florP1 = p.calculaFlor(player1.listaCarta);
                                    int florP2 = p.calculaFlor(player2.listaCarta);
                                    int g = p.venceChamada(player1.isMao(), florP1, florP2);
                                    if(g == 1){
                                        p.adicionaPontos(player1, p.verificaPontos("FlorEoResto"));
                                    }else{
                                        p.adicionaPontos(player2, p.verificaPontos("FlorEoResto"));
                                    }
                                }else{
                                    p.verificaPontos("Flor");
                                    p.adicionaPontos(player2, p.verificaPontos("Flor"));
                                }
                            }
                        }
                        gritos[1] = "";
                        break;
                    case 2:
                        if(pontoRodada == 0){
                            pontoRodada = chamaTruco(p, pontoRodada,player1, player2);   
                        }else{
                            if(pontoRodada == 1){
                                pontoRodada = chamaRetruco(p, pontoRodada, player1, player2);
                            }else{
                                if(pontoRodada == 2){
                                    pontoRodada = chamaRetruco(p, pontoRodada, player1, player2);
                                }
                            }
                        }
                        break;
                    case 3:
                        break;
                }
                Cartas jc1;
                Cartas jc2;
                do{
                    jc1 = jogarCartas(player1);
                }while(jc1 == null);
                String[] truco2 = {"Truco", "Soltar Carta"};
                if(pontoRodada == 0){
                    truco2[0] = "Truco";
                }else{
                    if(pontoRodada == 1){
                        truco2[0] = "Retruco"; 
                    }else{
                        if(pontoRodada == 2){
                            truco2[0] = "Vale Quatro";
                        }else{
                            truco2[0] = "";
                        }
                    }
                }
                int t2 = JOptionPane.showOptionDialog(null, cartasPlayer2, player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, truco2, truco2[0]);
                if(t2 == 0){
                    if(pontoRodada == 0){
                        pontoRodada = chamaTruco(p, pontoRodada, player2, player1);
                    }else{
                        if(pontoRodada == 1){
                            pontoRodada = chamaRetruco(p, pontoRodada, player2, player1);
                        }else{
                            if(pontoRodada == 2){
                                pontoRodada = chamaValeQuatro(p, pontoRodada, player2, player1);
                            }else{
                                JOptionPane.showMessageDialog(null, "Escolha uma opção valida!!");
                            }
                        }
                    } 
                }
                j--;
                do{
                    jc2 = jogarCartas(player2);
                }while(jc2 == null);
                int resultado = p.calculaForca(jc1, jc2);
                if(resultado == 1){
                    player1.setRodadaGanha(player1.getRodadaGanha() + 1);
                }else{
                    if(resultado == 2){
                        player2.setRodadaGanha(player2.getRodadaGanha() + 1);
                    }
                }
                
                if(player1.getRodadaGanha() == 2){
                    //player1ganhou
                }else{
                    if(player2.getRodadaGanha() == 2){
                        //player2ganhou
                    }else{
                        if(p.getTurno() == 2 && player1.getRodadaGanha() == 1 && player2.getRodadaGanha() == 0){
                            //player1ganhou
                        }else{
                            if(p.getTurno() == 2 && player1.getRodadaGanha() == 0 && player2.getRodadaGanha() == 1){
                                //player2ganhou
                            }
                        }
                    }
                }
            }
            p.setTurno(p.getTurno() + 1);
            if(player1.isMao()){
                player1.setMao(false);
                player2.setMao(true);
            }else{
                player1.setMao(true);
                player2.setMao(false);
            }
            j++;
        }
    }
    
    public static int chamaTruco(Partida p, int partidaRodada, Player player1, Player player2){
        String[] trucoOpt = {"Quero", "Não quero", "Retruco"};
            int truco = JOptionPane.showOptionDialog(null, "Aceita o Truco?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, trucoOpt, trucoOpt[0]);
            if(truco == 0){
                partidaRodada++;
            }else{
                if(truco == 2){
                    chamaRetruco(p, partidaRodada, player1, player2);
                }else{
                    return 0;
                }
            }
            return partidaRodada;
    }
    
    public static int chamaRetruco(Partida p, int partidaRodada, Player player1, Player player2){
        String[] trucoOpt = {"Quero", "Não quero", "Vale Quatro"};
            int truco = JOptionPane.showOptionDialog(null, "Aceita o Retruco?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, trucoOpt, trucoOpt[0]);
            if(truco == 0){
                partidaRodada++;
            }else{
                if(truco == 2){
                    chamaValeQuatro(p, partidaRodada, player1, player2);
                }else{
                    return 0;
                }
            }
            return partidaRodada;
    }
    
    public static int chamaValeQuatro(Partida p, int partidaRodada, Player player1, Player player2){
        Object[] confirmacao = {"Sim", "Não"};
            int truco = JOptionPane.showOptionDialog(null, "Aceita o Vale Quatro?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
            if(truco == 0){
                partidaRodada++;
            }else{
               return 0;
            }
            return partidaRodada;
    }
    
    public static Cartas jogarCartas(Player player){
        String[] jogarCarta = {player.listaCarta[0] != null ? player.listaCarta[0].toString() : "", 
                               player.listaCarta[1] != null ? player.listaCarta[1].toString() : "", 
                               player.listaCarta[2] != null ? player.listaCarta[2].toString() : ""};
        int escolheCarta = JOptionPane.showOptionDialog(null, "Qual carta jogar?", player.getNome(), JOptionPane.YES_NO_OPTION, 0, null, jogarCarta, jogarCarta[0]);;
        switch(escolheCarta){
            case 0:
                if(player.listaCarta[0] != null){
                    Cartas f1 = player.listaCarta[0];
                    player.listaCarta[0] = null;
                    return f1;
                }else{
                    JOptionPane.showMessageDialog(null, "Escolha uma opção valida!!");
                    return null;
                }
            case 1:
                if(player.listaCarta[1] != null){
                    Cartas f2 = player.listaCarta[1];
                    player.listaCarta[1] = null;
                    return f2;
                }else{
                    JOptionPane.showMessageDialog(null, "Escolha uma opção valida!!");
                    return null;
                }
            case 2:
                if(player.listaCarta[2] != null){
                    Cartas f3 = player.listaCarta[2];
                    player.listaCarta[2] = null;
                    return f3;
                }else{
                    JOptionPane.showMessageDialog(null, "Escolha uma opção valida!!");
                    return null;
                }
        }
        return null;
    }
    
    public static void darCartas(Player player1, Player player2, Partida p){
        Random rand = new Random();
        int numeroCarta;
        for(int i = 0; i < 3; i++){
            do{
                numeroCarta = rand.nextInt(12) + 1;
            }while(numeroCarta == 8 || numeroCarta == 9);
            int numeroNaipe = rand.nextInt(4) + 1;
            switch(numeroNaipe){
                case 1:
                    Basto basto = new Basto();
                    basto.setNumero(numeroCarta);
                    p.atribuiForca(basto, numeroCarta);
                    player1.listaCarta[i] = basto;
                    break;
                case 2:
                    Copas copa = new Copas();
                    copa.setNumero(numeroCarta);
                    p.atribuiForca(copa, numeroCarta);
                    player1.listaCarta[i] = copa;
                    break;
                case 3:
                    Espada espada = new Espada();
                    espada.setNumero(numeroCarta);
                    p.atribuiForca(espada, numeroCarta);
                    player1.listaCarta[i] = espada;
                    break;
                case 4:
                    Ouro ouro = new Ouro();
                    ouro.setNumero(numeroCarta);
                    p.atribuiForca(ouro, numeroCarta);
                    player1.listaCarta[i] = ouro;
                    break;
            }
        }
        
        for(int i = 0; i < 3; i++){
            do{
                numeroCarta = rand.nextInt(12) + 1;
            }while(numeroCarta == 8 || numeroCarta == 9);
            int numeroNaipe = rand.nextInt(4) + 1;
            switch(numeroNaipe){
                case 1:
                    Basto basto = new Basto();
                    basto.setNumero(numeroCarta);
                    p.atribuiForca(basto, numeroCarta);
                    player2.listaCarta[i] = basto;
                    break;
                case 2:
                    Copas copa = new Copas();
                    copa.setNumero(numeroCarta);
                    p.atribuiForca(copa, numeroCarta);
                    player2.listaCarta[i] = copa;
                    break;
                case 3:
                    Espada espada = new Espada();
                    espada.setNumero(numeroCarta);
                    p.atribuiForca(espada, numeroCarta);
                    player2.listaCarta[i] = espada;
                    break;
                case 4:
                    Ouro ouro = new Ouro();
                    ouro.setNumero(numeroCarta);
                    p.atribuiForca(ouro, numeroCarta);
                    player2.listaCarta[i] = ouro;
                    break;
            }
        }
    }
}

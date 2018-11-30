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
        Object[] confirmacao = {"Sim", "Não"};
        Partida p = new Partida();
        Player player1 = new Player("Paulo");
        Player player2 = new Player("Diego");
        
        Object[] players = {player1.getNome(), player2.getNome()};
        do{
            String o = (String) JOptionPane.showInputDialog(null, "Escola o mão", "Truco", JOptionPane.PLAIN_MESSAGE, null, players, player1.getNome());
            switch(o) {
                case "Paulo":
                    player1.setMao(true);
                    break;
                case "Diego":
                    player2.setMao(true);
                    break;
            }
        }while(player1.isMao() || player2.isMao());

        Object[] gritos = {"Envido", "Flor", "Truco", "Soltar Carta"};

        if(player1.isMao()){
            //String escolha = (String) JOptionPane.showInputDialog(null, "Escolha a jogada", player1.getNome(), JOptionPane.PLAIN_MESSAGE, null, gritos, "Escolha");
            int escolha = JOptionPane.showOptionDialog(null, "Escolha a jogada", player1.getNome(), JOptionPane.WARNING_MESSAGE, 0, null, gritos, gritos[0]);
            switch(escolha){
                case 0:
                 gritos[0] = "";
                 String[] envidoOpt = {"Quero", "Não quero", "Real Envido", "Falta Envido"};
                int envido = JOptionPane.showOptionDialog(null, "Aceita o Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, envidoOpt, envidoOpt[0]);
                    if(envido == 1){
                        int envP1 = p.calculaEnvido(player1.listaCarta);
                        int envP2 = p.calculaEnvido(player2.listaCarta);
                        int g = p.venceChamada(player1.isMao(), envP1, envP2);
                        int pontos = p.verificaPontos("Envido");
                        if(g == 1){
                            //atribui pontos para player1
                        }else{
                            //atribui pontos pra player2
                        }
                    }else{
                        if(envido == 2){
                            int resposta_envido = JOptionPane.showOptionDialog(null, "Aceita o Real Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                            if(resposta_envido == 1){
                                int envP1 = p.calculaEnvido(player1.listaCarta);
                                int envP2 = p.calculaEnvido(player2.listaCarta);
                                int g = p.venceChamada(player1.isMao(), envP1, envP2);
                                int pontos = p.verificaPontos("RealEnvido");
                                if(g == 1){
                                    //atribui pontos para player1
                                }else{
                                    //atribui pontos pra player2
                                }
                            }else{
                                int pontos = p.verificaPontos("Envido");
                                //player2 recebe um ponto;
                            }
                        }else{
                            if(envido == 3){
                                int resposta_envido = JOptionPane.showOptionDialog(null, "Aceita a Falta Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                                if(resposta_envido == 1){
                                    int envP1 = p.calculaEnvido(player1.listaCarta);
                                    int envP2 = p.calculaEnvido(player2.listaCarta);
                                    int g = p.venceChamada(player1.isMao(), envP1, envP2);
                                    int pontos = p.verificaPontos("FaltaEnvido");
                                    if(g == 1){
                                        //atribui para o player1
                                    }else{
                                        //atribui para o player2
                                    }
                                }else{
                                    int pontos = p.verificaPontos("Envido");
                                    //player2 recebe um ponto;
                                }
                            }else{
                                int pontos = p.verificaPontos("Nao");
                                //player1 recebe um ponto;
                            }    
                        }
                        //E DEPOIS RETIRAR ENVIDO A LISTA DE GRITOS... MAS NÃO SEI COMO FAZER ISSO
                    }
                    break;
                case 1:
                String[] florOpt = {"É bom...", "Contra Flor", "Flor ao Resto"};
                int flor = JOptionPane.showOptionDialog(null, "FLOR", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, florOpt, florOpt[0]);
                    if(flor == 0){
                        p.verificaPontos("Flor");
                        //atribuir pontos para player1
                    }else{
                        if(flor == 1){
                            int resposta_flor = JOptionPane.showOptionDialog(null, "Aceita a Falta Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                            if(resposta_flor == 0){
                                int florP1 = p.calculaFlor(player1.cartas);
                                int florP2 = p.calculaFlor(player2.cartas);
                                int g = p.venceChamada(player1.isMao(), florP1, florP2);
                                int pontos = p.verificaPontos("ContraFlor");
                                if(g == 1){
                                    //atribuir pontos player1
                                }else{
                                    //atribuir pontos player2
                                }
                            }else{
                                p.verificaPontos("Flor");
                                //atribuir pontos para player2
                            }
                        }else{
                            int resposta_flor = JOptionPane.showOptionDialog(null, "Aceita a Falta Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                            if(resposta_flor == 0){
                                int florP1 = p.calculaFlor(player1.cartas);
                                int florP2 = p.calculaFlor(player2.cartas);
                                int g = p.venceChamada(player1.isMao(), florP1, florP2);
                                int pontos = p.verificaPontos("FlorEoResto");
                                if(g == 1){
                                    //atribuir pontos player1
                                }else{
                                    //atribuir pontos player2
                                }
                            }else{
                                p.verificaPontos("Flor");
                                //atribuir pontos para o player2
                            }
                        }
                        //E DEPOIS RETIRAR FLOR A LISTA DE GRITOS... MAS NÃO SEI COMO FAZER ISSO
                    }
                    
                    break;
                case 2:
                    //chamatruco;
                    
                
            }
        }else{
            
        }
        
        if(player1.isMao()){
            player1.setMao(false);
            player2.setMao(true);
        }else{
            player1.setMao(true);
            player2.setMao(false);
        }
    }
    
    public void chamaTruco(Partida p, Player player1, Player player2){
        String[] trucoOpt = {"Quero", "Não quero", "Retruco"};
            int truco = JOptionPane.showOptionDialog(null, "Aceita o Truco?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, trucoOpt, trucoOpt[0]);
            if(truco == 0){
                Cartas trP1 = jogarCartas(player1);
                Cartas trP2 = jogarCartas(player2);
                int g = p.venceChamada(player1.isMao(), trP1.getForca(), trP2.getForca());
                int pontos = p.verificaPontos("Truco");
                if(g == 1){
                    //atribui pontos para player1
                }else{
                    p.verificaPontos("Nao");
                    //atribui pontos pra player2
                }
            }else{
                if(truco == 2){
                    String[] retrucoOpt = {"Quero", "Não quero", "ValeQuatro"};
                    int retruco = JOptionPane.showOptionDialog(null, "Aceita o Retruco?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, retrucoOpt, retrucoOpt[0]);
                    if(retruco == 0){
                        Cartas retrP1 = jogarCartas(player1);
                        Cartas retrP2 = jogarCartas(player2);
                        int g = p.venceChamada(player1.isMao(), retrP1.getForca(), retrP2.getForca());
                        int pontos = p.verificaPontos("Retruco");
                        if(g == 1){
                            //atribui pontos para player1
                        }else{
                            p.verificaPontos("Truco");
                            //atribui pontos pra player2
                        }
                    }else{
                        if(retruco == 2){
                            int valeq = JOptionPane.showOptionDialog(null, "Aceita o Vale Quatro?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                            if(valeq == 0){
                                Cartas vqP1 = jogarCartas(player1);
                                Cartas vqP2 = jogarCartas(player2);
                                int g = p.venceChamada(player1.isMao(), vqP1.getForca(), vqP2.getForca());
                                int pontos = p.verificaPontos("ValeQuatro");
                                if(g == 1){
                                    //atribui pontos para player1
                                }else{
                                    p.verificaPontos("Retruco");
                                    //atribui pontos pra player2
                                }
                            }else{
                                p.verificaPontos("Retruco");
                            }
                        }else{
                            //atribui pontos para o player 2
                        }
                    }
                }else{
                    //atribui pontos para o player 1
                }
            }
    }
    
    public Cartas jogarCartas(Player player){
        String[] jogarCarta = {player.listaCarta[0].toString(), player.listaCarta[1].toString(), player.listaCarta[2].toString()};
        int escolheCarta = JOptionPane.showOptionDialog(null, "Qual carta jogar?", player.getNome(), JOptionPane.YES_NO_OPTION, 0, null, jogarCarta, jogarCarta[0]);;
        switch(escolheCarta){
            case 0:
                Cartas f1 = player.listaCarta[0];
                player.listaCarta[0] = null;
                break;
            case 1:
                Cartas f2 = player.listaCarta[1];
                player.listaCarta[1] = null;
                break;
            case 2:
                Cartas f3 = player.listaCarta[2];
                player.listaCarta[2] = null;
                break;
        }
        return null;
    }
    
    public void darCartas(Player player1, Player player2){
        Random rand = new Random();
        for(int i = 0; i < 3; i++){
            int numeroCarta = rand.nextInt(13) + 1;
            int numeroNaipe = rand.nextInt(4) + 1;
            switch(numeroNaipe){
                case 1:
                    Basto basto = new Basto();
                    basto.setNumero(numeroCarta);
                    basto.atribuiForca(numeroCarta);
                    player1.listaCarta[i] = basto;
                    break;
                case 2:
                    Copas copa = new Copas();
                    copa.setNumero(numeroCarta);
                    copa.atribuiForca(numeroCarta);
                    player1.listaCarta[i] = copa;
                    break;
                case 3:
                    Espada espada = new Espada();
                    espada.setNumero(numeroCarta);
                    espada.atribuiForca(numeroCarta);
                    player1.listaCarta[i] = espada;
                    break;
                case 4:
                    Ouro ouro = new Ouro();
                    ouro.setNumero(numeroCarta);
                    ouro.atribuiForca(numeroCarta);
                    player1.listaCarta[i] = ouro;
                    break;
            }
        }
        
        for(int i = 0; i < 3; i++){
            int numeroCarta = rand.nextInt(13) + 1;
            int numeroNaipe = rand.nextInt(4) + 1;
            switch(numeroNaipe){
                case 1:
                    Basto basto = new Basto();
                    basto.setNumero(numeroCarta);
                    basto.atribuiForca(numeroCarta);
                    player2.listaCarta[i] = basto;
                    break;
                case 2:
                    Copas copa = new Copas();
                    copa.setNumero(numeroCarta);
                    copa.atribuiForca(numeroCarta);
                    player2.listaCarta[i] = copa;
                    break;
                case 3:
                    Espada espada = new Espada();
                    espada.setNumero(numeroCarta);
                    espada.atribuiForca(numeroCarta);
                    player2.listaCarta[i] = espada;
                    break;
                case 4:
                    Ouro ouro = new Ouro();
                    ouro.setNumero(numeroCarta);
                    ouro.atribuiForca(numeroCarta);
                    player2.listaCarta[i] = ouro;
                    break;
            }
        }
    }
}
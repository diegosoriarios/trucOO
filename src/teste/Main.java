package teste;

import javax.swing.JOptionPane;

import Modelos.Basto;
import Modelos.Player;

import java.util.Random;
import java.util.function.ObjIntConsumer;

import Partida;

public class Main{
    public static void main(String[] args){
        Random rand = new Random();
        Player jogador1 = new Player("Paulo");
        Player jogador2 = new Player("Diego");
        Player player1 = jogador1;
        Player player2 = jogador1;

        Object[] players = {jogador1.getNome(), jogador2.getNome()};
        do{
            String o = (String) JOptionPane.showInputDialog(null, "Escola o mão", "Truco", JOptionPane.PLAIN_MESSAGE, null, players, jogador1.getNome());
            switch(o) {
                case jogador1.getNome():
                    jogador1.setMao(true);
                    break;
                case jogador2.getNome():
                    jogador2.setMao(true);
                    break;
            }
        }while(player1.isMao() || player2.isMao());

        for(int i = 0; i < 3; i++){
            int numeroCarta = rand.nextInt(13) + 1;
            int numeroNaipe = rand.nextInt(4) + 1;
            switch(numeroNaipe){
                case 1:
                    Basto basto = new Basto();
                    basto.setNumero(numeroCarta);
                    basto.atribuiForca(numeroCarta);
                    player1.cartas.add(basto);
                    break;
                case 2:
                    Copas copas = new Copas();
                    copas.setNumero(numeroCarta);
                    copas.atribuiForca(numeroCarta);
                    player1.cartas.add(copas);
                    break;
                case 3:
                    Espada espada = new Espada();
                    espada.setNumero(numeroCarta);
                    espada.atribuiForca(numeroCarta);
                    player1.cartas.add(espada);
                    break;
                case 4:
                    Ouro ouro = new Ouro();
                    ouro.setNumero(numeroCarta);
                    ouro.atribuiForca(numeroCarta);
                    player1.cartas.add(ouro);
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
                    player2.cartas.add(basto);
                    break;
                case 2:
                    Copas copas = new Copas();
                    copas.setNumero(numeroCarta);
                    copas.atribuiForca(numeroCarta);
                    player2.cartas.add(copas);
                    break;
                case 3:
                    Espada espada = new Espada();
                    espada.setNumero(numeroCarta);
                    espada.atribuiForca(numeroCarta);
                    player2.cartas.add(espada);
                    break;
                case 4:
                    Ouro ouro = new Ouro();
                    ouro.setNumero(numeroCarta);
                    ouro.atribuiForca(numeroCarta);
                    player2.cartas.add(ouro);
                    break;
            }
        }
        
        Object[] confirmacao = {"Sim", "Não"};

        Object[] gritos = {"Envido", "Flor", "Truco", "Soltar Carta"};

        if(player1.isMao()){
            //String escolha = (String) JOptionPane.showInputDialog(null, "Escolha a jogada", player1.getNome(), JOptionPane.PLAIN_MESSAGE, null, gritos, "Escolha");
            String escolha = (String) JOptionPane.showOptionDialog(null, "Escolha a jogada", player1.getNome(), JOptionPane.WARNING_MESSAGE, 0, null, gritos, gritos[0]);
            switch(escola){
                case "Envido":
                String[] envidoOpt = {"Quero", "Não quero", "Real Envido", "Falta Envido"};
                String envido = (String) JOptionPane.showOptionDialog(null, "Aceita o Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, envidoOpt, envidoOpt[0]);
                    if(enviado == "Quero"){
                        int envP1 = calculaEnvido(player1.cartas);
                        int envP2 = calculaEnvido(player2.cartas);
                        int g = venceChamada(player1.isMao(), envP1, envP2);
                        int pontos = verificaPontos("Envido");
                        if(g == 1){
                            //atribui pontos para player1
                        }else{
                            //atribui pontos pra player2
                        }
                    }else{
                        if(envido == "Real Envido"){
                            String resposta_envido = (String) JOptionPane.showOptionDialog(null, "Aceita o Real Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                            if(resposta_envido == "Sim"){
                                int envP1 = calculaEnvido(player1.cartas);
                                int envP2 = calculaEnvido(player2.cartas);
                                int g = venceChamada(player1.isMao(), envP1, envP2);
                                int pontos = verificaPontos("RealEnvido");
                                if(g == 1){
                                    //atribui pontos para player1
                                }else{
                                    //atribui pontos pra player2
                                }
                            }else{
                                int pontos = verificaPontos("Envido");
                                //player2 recebe um ponto;
                            }
                        }else{
                            if(envido == "Falta Envido"){
                                String resposta_envido = (String) JOptionPane.showOptionDialog(null, "Aceita a Falta Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                                if(resposta_envido == "Sim"){
                                    int envP1 = calculaEnvido(player1.cartas);
                                    int envP2 = calculaEnvido(player2.cartas);
                                    int g = venceChamada(player1.isMao(), envP1, envP2);
                                    int pontos = verificaPontos("FaltaEnvido");
                                    if(g == 1){
                                        //atribui para o player1
                                    }else{
                                        //atribui para o player2
                                    }
                                }else{
                                    int pontos = verificaPontos("Envido");
                                    //player2 recebe um ponto;
                                }
                            }else{
                                int pontos = verificaPontos("Nao");
                                //player1 recebe um ponto;
                            }    
                        }
                        //E DEPOIS RETIRAR ENVIDO A LISTA DE GRITOS... MAS NÃO SEI COMO FAZER ISSO
                    }
                    break;
                case "Flor":
                String[] florOpt = {"É bom...", "Contra Flor", "Flor ao Resto"};
                String flor = (String) JOptionPane.showOptionDialog(null, "FLOR", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, florOpt, florOpt[0]);
                    if(flor == "É bom..."){
                        verificaPontos("Flor");
                        //atribuir pontos para player1
                    }else{
                        if(flor == "Contra Flor"){
                            String resposta_flor = (String) JOptionPane.showOptionDialog(null, "Aceita a Falta Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                            if(resposta_flor == "Sim"){
                                int florP1 = calculaFlor(player1.cartas);
                                int florP2 = calculaFlor(player2.cartas);
                                int g = venceChamada(player1.isMao(), florP1, florP2);
                                int pontos = verificaPontos("ContraFlor");
                                if(g == 1){
                                    //atribuir pontos player1
                                }else{
                                    //atribuir pontos player2
                                }
                            }else{
                                verificaPontos("Flor");
                                //atribuir pontos para player2
                            }
                        }else{
                            String resposta_flor = (String) JOptionPane.showOptionDialog(null, "Aceita a Falta Envido?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                            if(resposta_flor == "Sim"){
                                int florP1 = calculaFlor(player1.cartas);
                                int florP2 = calculaFlor(player2.cartas);
                                int g = venceChamada(player1.isMao(), florP1, florP2);
                                int pontos = verificaPontos("FlorEoResto");
                                if(g == 1){
                                    //atribuir pontos player1
                                }else{
                                    //atribuir pontos player2
                                }
                            }else{
                                verificarPontos("Flor");
                                //atribuir pontos para o player2
                            }
                        }
                        //E DEPOIS RETIRAR FLOR A LISTA DE GRITOS... MAS NÃO SEI COMO FAZER ISSO
                    }
                    
                    break;
                case "Truco":
                String[] trucoOpt = {"Quero", "Não quero", "Retruco"};
                String truco = (String) JOptionPane.showOptionDialog(null, "Aceita o Truco?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, trucoOpt, trucoOpt[0]);
                if(truco == "Quero"){
                    int trP1 = calculaForca(player1.cartas);
                    int trP2 = calculaForca(player2.cartas);
                    int g = venceChamada(player1.isMao(), envP1, envP2);
                    int pontos = verificaPontos("Truco");
                    if(g == 1){
                        //atribui pontos para player1
                    }else{
                        verificarPontos("Não");
                        //atribui pontos pra player2
                    }
                }else{
                    if(truco == "Retruco"){
                        String[] retrucoOpt = {"Quero", "Não quero", "ValeQuatro"};
                        String retruco = (String) JOptionPane.showOptionDialog(null, "Aceita o Retruco?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, retrucoOpt, retrucoOpt[0]);
                        if(retruco == "Quero"){
                            int retrP1 = calculaForca(player1.cartas);
                            int retrP2 = calculaForca(player2.cartas);
                            int g = venceChamada(player1.isMao(), envP1, envP2);
                            int pontos = verificaPontos("Retruco");
                            if(g == 1){
                                //atribui pontos para player1
                            }else{
                                verificarPontos("Truco");
                                //atribui pontos pra player2
                            }
                        }else{
                            if(retruco == "ValeQuatro"){
                                String valeq = (String) JOptionPane.showOptionDialog(null, "Aceita o Vale Quatro?", player2.getNome(), JOptionPane.YES_NO_OPTION, 0, null, confirmacao, confirmacao[0]);
                                if(valeq == "Sim"){
                                    int vqP1 = calculaForca(player1.cartas);
                                    int vqP2 = calculaForca(player2.cartas);
                                    int g = venceChamada(player1.isMao(), envP1, envP2);
                                    int pontos = verificaPontos("ValeQuatro");
                                    if(g == 1){
                                        //atribui pontos para player1
                                    }else{
                                        verificarPontos("Retruco");
                                        //atribui pontos pra player2
                                    }
                                }else{
                                    verificaPontos("Retruco");
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
        }else{
            
        }

        if(jogador1.isMao()){
            player1 = player2;
            player2 = player1;
            jogador1.setMao(false);
            jogador2.setMao(true);
          }else{
            player1 = player1;
            player2 = player2;
            jogador1.setMao(true);
            jogador2.setMao(false);
          }
    }
}
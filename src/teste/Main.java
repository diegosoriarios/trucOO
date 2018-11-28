package teste;

import javax.swing.JOptionPane;

import Modelos.Basto;
import Modelos.Player;

import java.util.Random;

import Partida;

public class Main{
    public static void main(String[] args){
        Random rand = new Random();
        Player player1 = new Player("Paulo");
        Player player2 = new Player("Diego");

        Object[] players = {player1.getNome(), player2.getNome()};
        do{
            String o = (String) JOptionPane.showInputDialog(null, "Escola o mão", "Truco", JOptionPane.PLAIN_MESSAGE, null, players, player1.getNome());
            switch(o) {
                case player1.getNome():
                    player1.setMao(true);
                    break;
                case player2.getNome():
                    player2.setMao(true);
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
        

        Object gritos = {"Envido", "Flor", "Truco", "Soltar Carta"};

        if(player1.isMao()){
            String escolha = (String) JOptionPane.showInputDialog(null, "Escolha a jogada", player1.getNome(), JOptionPane.PLAIN_MESSAGE, null, gritos, "Escolha");
            switch(escola){
                case "Envido":
                    int envP1 = calculaEnvido(player1.cartas);
                    int envP2 = calculaEnvido(player2.cartas);
                    /*falta implementar 
                        ganhaEnvido(envP1, envP2);
                        
                        E DEPOIS RETIRAR ENVIDO A LISTA DE GRITOS... MAS NÃO SEI COMO FAZER ISSO
                    */
                    break;
                case "Flor":
                    int florP1 = calculaFlor(player1.cartas);
                    int florP2 = calculaFlor(player1.cartas);
                    /*falta implementar 
                        ganhaFlor(envP1, envP2);
                        
                        E DEPOIS RETIRAR FLOR A LISTA DE GRITOS... MAS NÃO SEI COMO FAZER ISSO
                    */
            }
        }else{
            
        }
    }
}
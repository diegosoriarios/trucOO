/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author diego
 */
public class Partida {
    private int turno;

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }
    
    public int calculaForca(Cartas player1, Cartas player2){
        if(player1.getForca() > player2.getForca()){
            return 1; //1 ganhou
        }else{
            if(player2.getForca() > player1.getForca()){
                return 2;//2 ganhou
            }else{
                return 0;//empate
            }
        }
    }
    
    public int calculaEnvido(Cartas c){
        /*fazer loop no cartas
        if(carta1.naipe == carta2.naipe)
        soma 20 mais as cartas iguais
        senão
        */
        return 0;
    }
    
    public int calculaFlor(Cartas c){
        /*
        fazer loop nas cartas e checar se são iguais
        */
        return 0;
    }
    
    public int calculaTruco(Cartas c){
        //Não lembro o que era pra colocar aqui kkkkkkkkkkk
        return 0;
    }
}

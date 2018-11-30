/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

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
    
    public int calculaEnvido(Cartas[] c) {
        int envido=0;
        if (c[0].getNaipe().equals(c[1].getNaipe())){
            if (c[0].getNumero() >= 10){
                envido += 10;
            }else{
                envido += c[0].getNumero();
            }
            if (c[1].getNumero() >= 10){
                envido += 10;
            }else{
                envido += c[1].getNumero();
            }
            return envido;
        }
        else if (c[1].getNaipe().equals(c[2].getNaipe())){
            if (c[1].getNumero() >= 10){
                envido += 10;
            }else{
                envido += c[1].getNumero();
            }
            if (c[2].getNumero() >= 10){
                envido += 10;
            }else{
                envido += c[2].getNumero();
            }
            return envido;
        }
        else if (c[0].getNaipe().equals(c[2].getNaipe())) {
            if (c[0].getNumero() >= 10){
                envido += 10;
            }else{
                envido += c[0].getNumero();
            }
            if (c[2].getNumero() >= 10){
                envido += 10;
            }else{
                envido += c[2].getNumero();
            }
        }else{
            if (c[0].getNumero() < 10 && c[0].getNumero() >= c[1].getNumero()){
                if (c[0].getNumero() >= c[2].getNumero()){
                    envido += c[0].getNumero();
                }
            }else if (c[1].getNumero() < 10 && c[1].getNumero() >= c[0].getNumero()){
                if (c[1].getNumero() >= c[2].getNumero()){
                    envido += c[1].getNumero();
                }
            }else if (c[2].getNumero() < 10 && c[2].getNumero() >= c[0].getNumero()){
                if (c[2].getNumero() >= c[1].getNumero()){
                    envido += c[2].getNumero();
                }
            }else{
                envido += 10;
            }
        }
        return envido;
    }
    
    public int calculaFlor(Cartas[] c){
        int flor=0;
        if (c[0].getNaipe().equals(c[1].getNaipe()) && c[1].getNaipe().equals(c[2].getNaipe())){
            if (c[0].getNumero() >= 10){
                flor += 10;
            }else{
                flor += c[0].getNumero();
            }
            if (c[1].getNumero() >= 10){
                flor += 10;
            }else{
                flor += c[1].getNumero();
            }
            if (c[2].getNumero() >= 10){
                flor += 10;
            }else{
                flor += c[2].getNumero();
            }
        }else{
            return calculaEnvido(c);
        }
        return flor;
    }
    
    public int venceChamada(boolean player1Mao, int pontosP1, int pontosP2){
        if(pontosP1 > pontosP2){
            return 1;
        }else{
            if(pontosP2 > pontosP1){
                return 2;
            }else{
                if(player1Mao){
                    return 1;
                }else{
                    return 2;
                }
            }
        }
    }
    
    public int verificaPontos(String chamada){
        int pontos=0;
        switch (chamada) {
            case "Nao":
                pontos = 1;
                break;
            case "Truco":
                pontos = 2;
                break;
            case "Retruco":
                pontos = 3;
                break;
            case "ValeQuatro":
                pontos = 4;
                break;
            case "Envido":
                pontos = 2;
                break;
            case "RealEnvido":
                pontos = 3;
                break;
            case "FaltaEnvido":
                pontos = 12;
                break;
            case "Flor":
                pontos = 3;
                break;
            case "ContraFlor":
                pontos = 6;
                break;
            case "FlorEoResto":
                pontos = 12;
                break;
         }
        return pontos;
    }
    
    public void adicionaPontos(Player player, int pontos){
        //player.addPontos(pontos);
    }
}

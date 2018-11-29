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
public class Player {
    private String nome;
    private boolean mao;
    private ArrayList cartas = new ArrayList();

    public Player(String nome){
        this.nome = nome;
        this.mao = false;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMao() {
        return mao;
    }

    public void setMao(boolean mao) {
        this.mao = mao;
    }

    public ArrayList getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList cartas) {
        this.cartas = cartas;
    }

    @Override
    public String toString() {
        String aux = "";
        aux += "Nome: " + nome;
        aux += mao ? ", É mão" : "Não é mão";
        aux += ", Cartas: " + cartas;
        return aux;
    }
    
    
}

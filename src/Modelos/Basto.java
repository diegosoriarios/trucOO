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
public class Basto extends Cartas {
    public Basto() {
        naipe = "Basto";
    }

    @Override
    public void atribuiForca(int numero) {
        if(numero == 1){
            forca = 20;
        }
        if(numero > 1 && numero <= 3){
            forca = numero + 12;
        }else{
            if(numero >= 4 && numero <= 7){
                forca = numero;
            }else{
                if(numero >= 10 && numero <= 12){
                    forca = numero - 2;
                }
            }
        }
    }
    
    @Override
    public String toString() {
        String aux = "";
        aux += "Carta: " + numero + " ♣\n";
        return aux;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author JuanCaCha
 */
public class Barco {
    private int tamaño;
    private int numcoordenada = 0;
    private int[][] coordenadas = new int [2][3];
    
    public Barco(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public int getTamaño() {
        return tamaño;
    }

    public int[] getCoordenadas(int a) {
        int[] aux = new int[2];
        aux[0] = coordenadas [0][a];
        aux[1] = coordenadas [1][a];
        return aux;
    }

    public int getNumcoordenada() {
        return numcoordenada;
    }

    
    
    public void disparoAbarco(){
        this.tamaño--;
    }

    public void aumNumcoordenada() {
        this.numcoordenada ++;
    }
    
    public void setCoordenadas (int[] a){
        coordenadas[0][numcoordenada] = a[0];
        coordenadas[1][numcoordenada] = a[1];
        
    }
}

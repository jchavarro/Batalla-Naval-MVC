/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import static batalla.naval.Vista.Controlador.VistaNaval.barco;

/**
 *
 * @author JuanCaCha
 */
public class Tablero {
    private int numbarcos = 0, numdisparos = 10;
    
    public int[][] barcosAleatorios(int [][] a){
        int f, c, lado;
        
        for (int i = 0; i < 13; i++) {
            
            f = (int)(Math.random()*15);
            c = (int)(Math.random()*15);
            lado = (int)(Math.random()*2); //0 es horizontal 1 es vertical
            
            if (a[f][c] == 0 ) {
                if ( f <= 11 && c <= 11 && i == 0 ) {
                    if (lado == 0 && a[f][c+1] == 0 && a[f][c+2] == 0 && a[f][c+3] == 0) {
                        a[f][c] = i + 1;
                        a[f][c+1] = i + 1;
                        a[f][c+2] = i + 1;
                        a[f][c+3] = i + 1;
                    }else if (lado == 1 && a[f+1][c] == 0 && a[f+2][c] == 0 && a[f+3][c] == 0){
                        a[f][c] = i + 1;
                        a[f+1][c] = i + 1;
                        a[f+2][c] = i + 1;
                        a[f+3][c] = i + 1;
                    }
                }else if (f <= 12 && c <= 12 && (i == 1 || i == 2 ) ) {
                    if (lado == 0 && a[f][c+1] == 0 && a[f][c+2] == 0 ) {
                        a[f][c] = i + 1;
                        a[f][c+1] = i + 1;
                        a[f][c+2] = i + 1;
                    }else if (lado == 1 && a[f+1][c] == 0 && a[f+2][c] == 0 ) {
                        a[f][c] = i + 1;
                        a[f+1][c] = i + 1;
                        a[f+2][c] = i + 1;
                    }

                }else if (f <= 13 && c <= 13 && i >= 3 && i <= 6 ) {
                    if (lado == 0 && a[f][c+1] == 0) {
                        a[f][c] = i + 1;
                        a[f][c+1] = i + 1;
                    }else if (lado == 1 && a[f+1][c] == 0){
                        a[f][c] = i + 1;
                        a[f+1][c] = i + 1;
                    }
                }else if (i >= 7) {
                    a[f][c] = i + 1;
                }else i--;
            } else i--;
        }
        return  a;
    }

    public int getNumdisparos() {
        return numdisparos;
    }

    public void menosNumdisparos() {
        this.numdisparos--;
    }
    
    public int [][] disparosAleatorios (int [][] a){
        
        for (int i = 0; i < 1; i++) {
            int disparoPCx = (int)(Math.random()*15);
            int disparoPCy = (int)(Math.random()*15);
            if (a[disparoPCx][disparoPCy] > 0) {
                a = accionDisparar(disparoPCx, disparoPCy, a);
                        
            }if (a[disparoPCx][disparoPCy] == 0) {
                a[disparoPCx][disparoPCy] = -2;
            } else i--;
            
        }
        
        return a;
    }
        
    public int [][] accionDisparar (int x, int y, int [][] PCtablero){
        
        if (PCtablero[x][y] > 6) {
            barco[5].disparoAbarco();
            PCtablero[x][y] = -1;
            this.numbarcos--;
        }if (PCtablero[x][y] == 0) {
            PCtablero[x][y] = -2;
            
        }if (PCtablero[x][y] <= 7 && PCtablero[x][y] >= 1) {
            barco[PCtablero[x][y]].disparoAbarco();

            if (barco[PCtablero[x][y]].getTamaño()==0) {
                for (int i = 0; i < barco[PCtablero[x][y]].getNumcoordenada(); i++) {
                    int[] a = new int [2] ;
                    a = barco[PCtablero [x] [y]].getCoordenadas(i);
                    PCtablero[a[0]][a[1]] = -1;   
                }
                PCtablero[x][y] = -1;
                this.numbarcos--;
            }else if (barco[PCtablero[x][y]].getTamaño() > 0) {
                int[] a = new int [2] ;
                a[0] = x; 
                a[1] = y; 
                barco[PCtablero[x][y]].setCoordenadas(a);
                barco[PCtablero[x][y]].aumNumcoordenada();
                PCtablero[x][y] = -3;
            }
        }                
        return PCtablero;
    }
    
    public boolean yogano (int a, int b){
        return a > b;
    }
    public void setNumbarcos(int numbarcos) {
        this.numbarcos = numbarcos;
    }
    
    public int getNumbarcos() {
        return numbarcos;
    }
    
    public  void hundirBarco (){
        this.numbarcos--;
    }

    public boolean haydisparos() {
        return numdisparos>0;
    }
    public boolean victoria (){
        return numbarcos>0;
    }

    public void setNumdisparos(int numdisparos) {
        this.numdisparos = numdisparos;
    }

}    


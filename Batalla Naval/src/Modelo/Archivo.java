/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author JuanCaCha
 */
public class Archivo {
    File a = new File ("agenda.txt");
    
    /**
     *
     * @param puntajes
     */
    public void añadirArchivo(int [] puntajes ){
    
        try{
            
            FileOutputStream fos=new FileOutputStream(this.a);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(puntajes);
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public int[] Abrirpuntajes (){
        
        int[] backup = new int[10];
        try{
            if (this.a.exists()) {
                FileInputStream fos=new FileInputStream(this.a);
                ObjectInputStream ois=new ObjectInputStream(fos);
                backup = (int[]) ois.readObject();
            }else{
                añadirArchivo(backup);
            }
            
            
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return backup;
    }
    public String[] listar (int [] puntajes){
        String[] listado = new String[10];
        for (int i = 0; i < 10; i++) {
            listado[i] = i + ".Puesto =" + listado[i];
        }
        return listado;
    }
    public int[] añadiralalista (int puntaje, int [] lista){
        int aux;
        for (int i = 0; i < 10; i++) {
            if (lista[i] == 0) {
                lista[i] = puntaje;
                break;
            }if (puntaje > lista[i]) {
                aux = lista[i];
                lista[i] = puntaje;
                puntaje = aux;
            }
        }
        return lista;
    }
}

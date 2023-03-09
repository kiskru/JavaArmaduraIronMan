/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;


/**
 * @author Kidver
 */

public class Bota extends Dispositivo{

    public Bota(String nombre) {
        super(nombre);
    }
    
    
    
   @Override
    public String toString() {
        return "Bota consumo: " + consumo + " - " + estado;
    }

}//The end

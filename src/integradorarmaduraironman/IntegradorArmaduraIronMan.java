/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package integradorarmaduraironman;

import jarvis.JARVIS;
import Entity.Armadura;
import Entity.ObjetoX;
import java.util.Scanner;

/**
 * @author Kidver
 */
public class IntegradorArmaduraIronMan {
   
    public static Scanner scan = new Scanner(System.in).useDelimiter("\n");

    public static void main(String[] args) {
        JARVIS JARVIS = new JARVIS();
        
        Armadura prototipo = JARVIS.fabricarArmadura();
        JARVIS.mostrarInformacionArmadura(prototipo);
        JARVIS.caminar(prototipo, 10000);
        JARVIS.correr(prototipo, 20000);
        JARVIS.propulsarse(prototipo, 15000);
        JARVIS.volar(prototipo, 50000);
        JARVIS.disparar(prototipo, 5000);
        JARVIS.mostrarInformacionArmadura(prototipo);
        JARVIS.estadoBateria(prototipo);
        JARVIS.escanearArmadura(prototipo);
        JARVIS.mostrarInformacionArmadura(prototipo);
        
        ObjetoX e = new ObjetoX();
        System.out.println(e);
        
        
        
        
        
        
        
        
        
        // TODO code application logic here
    }

}//The end

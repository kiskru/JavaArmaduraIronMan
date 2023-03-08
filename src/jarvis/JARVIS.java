/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jarvis;

import Entity.Armadura;
import Enums.EstadoDispositivo;
import static integradorarmaduraironman.IntegradorArmaduraIronMan.scan;
import java.util.Random;

/**
 * @author Kidver
 */
public class JARVIS {

    Random rand = new Random();

    public void consumirEnergia(Armadura arm, int consumo) {
        Integer energia = arm.getGenerador().getEnergia();
        energia -= consumo;
        arm.getGenerador().setEnergia(energia);
    }

//Al caminar la armadura hará un uso básico de las botas y se consumirá la energía 
//establecida como consumo en la bota por el tiempo en el que se camine.
    public int caminar(Armadura arm, int tiempo) {

        arm.getBotaDer().getEstado();
        arm.getBotaIzq().getEstado();
        if (arm.getBotaDer().getEstado().equals(EstadoDispositivo.OPERATIVO) && arm.getBotaIzq().getEstado().equals(EstadoDispositivo.OPERATIVO)) {

            int numRand = rand.nextInt(100) + 1;
            if (numRand > 30) {
                int consumo = arm.getBotaDer().getConsumo() * tiempo;
                numRand = rand.nextInt(100) + 1;
                if (numRand > 30) {
                    consumo += arm.getBotaIzq().getConsumo() * tiempo;
                } else {
                    arm.getBotaIzq().setEstado(EstadoDispositivo.AVERIADO);
                    System.out.println("La bota izquierda se ha averiado durante la ejecucion");
                    return 0;
                }

                System.out.println("Caminando...        Energia consumida " + consumo);

                consumirEnergia(arm, consumo);
                return consumo;

            } else {
                arm.getBotaDer().setEstado(EstadoDispositivo.AVERIADO);
                System.out.println("La bota derecha se ha averiado durante la ejecucion");
                return 0;
            }
        }else{
            System.out.println("Una de las botas esta averiadas... no se puede caaminar");
        }
        return 0;
    }
//      Al correr la armadura hará un uso normal de las botas y se consumirá el doble de la 
//      energía establecida como consumo en la bota por el tiempo en el que se corra.

    public int correr(Armadura arm, int tiempo) {
        int consumo = (arm.getBotaDer().getConsumo() * 2) * tiempo;
        System.out.println("Corriendo...        Energia consumida " + consumo);
        consumirEnergia(arm, consumo);
        return consumo;
    }
//      Al propulsarse la armadura hará un uso intensivo de las botas utilizando el triple de la 
//      energía por el tiempo que dure la propulsión.

    public int propulsarse(Armadura arm, int tiempo) {
        int consumo = (arm.getBotaDer().getConsumo() * 3) * tiempo;
        System.out.println("Propulsor activado...        Energia consumida " + consumo);
        consumirEnergia(arm, consumo);
        return consumo;
    }

//    Al volar la armadura hará un uso intensivo de las botas y de los guantes un uso normal 
//    consumiendo el triple de la energía establecida para las botas y el doble para los guantes.
    public int volar(Armadura arm, int tiempo) {
        int consumo = ((arm.getBotaDer().getConsumo() * 3) + (arm.getGuanteDer().getConsumo() * 2)) * tiempo;
        System.out.println("Volando...          Energia consumida " + consumo);
        consumirEnergia(arm, consumo);
        return consumo;
    }

//    Al utilizar los guantes como armas el consumo se triplica durante el tiempo del disparo.
    public int disparar(Armadura arm, int tiempo) {
        int consumo = (arm.getGuanteDer().getConsumo() * 3) * tiempo;
        System.out.println("Disparando...       Energia consumida " + consumo);
        consumo = consumo * 2; //dispara con los dos guantes.
        consumirEnergia(arm, consumo);
        return consumo;
    }

    public void pintarArmadura(Armadura arm) {
        System.out.println("Sr. Elige el color principal para tu armadura");
        String colorP = scan.next();
        System.out.println("Sr. elige el color secundario para tu armadura");
        String colorS = scan.next();

        arm.setColorP(colorP);
        arm.setColorS(colorS);
        System.out.println("Ha sido una excelente elecion Sr.");
    }

    public Armadura fabricarArmadura() {
        return new Armadura();
    }

    public void mostrarInformacionArmadura(Armadura arm) {
        System.out.println(
                "\n Armadura " + "color Principal =" + arm.getColorP() + ", color Secundario=" + arm.getColorS() + ""
                + "\n resistencia=" + arm.getResistencia() + ", salud=" + arm.getSalud() + ""
                + "\n guanteIzq=" + arm.getGuanteIzq() + ", guanteDer=" + arm.getGuanteDer() + ""
                + "\n botaIzq=" + arm.getBotaIzq() + ", botaDer=" + arm.getBotaDer() + ""
                + "\n casco=" + arm.getCasco() + ""
                + "\n generador= " + arm.getGenerador() + '\n');
    }

    public void estadoBateria(Armadura arm) {
        double bateria = ((double) arm.getGenerador().getEnergia() / Integer.MAX_VALUE) * 100;
        System.out.println("Nivel de bateria: " + bateria + " %.");

    }
}//The end

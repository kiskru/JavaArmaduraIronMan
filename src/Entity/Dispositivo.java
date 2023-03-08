/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import Enums.EstadoDispositivo;


/**
 * @author Kidver
 */

public abstract class Dispositivo {

    int consumo;
    EstadoDispositivo estado;

    public Dispositivo() {
        this.consumo = 1000;
        this.estado = EstadoDispositivo.OPERATIVO;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public EstadoDispositivo getEstado() {
        return estado;
    }

    public void setEstado(EstadoDispositivo estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return " consumo: " + consumo + " - " + estado;
    }
    
    
}//The end

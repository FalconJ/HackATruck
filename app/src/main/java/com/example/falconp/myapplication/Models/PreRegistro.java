package com.example.falconp.myapplication.Models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by FalconP on 25/11/2017.
 */
@IgnoreExtraProperties
public class PreRegistro {

    String noCaja;
    String lineaCaja;
    String noTractor;
    String lineaTractor;
    String noRemolque;
    String placasCaja;
    String nombreOperador;
    String estado;
    String placas;
    String temperatura;
    String escala;
    Boolean motor;
    String motorObservacion;
    Boolean cabina;
    String cabinaObservacion;

    public PreRegistro(){}

    public PreRegistro(String noCaja, String lineaCaja,String  noTractor,String  lineaTractor,
                       String noRemolque,String placasCaja,String  nombreOperador,String  estado,
                       String placas,String temperatura,String escala,Boolean motor,String  motorObservacion,
                       Boolean cabina,String cabinaObservacion){
        this.noCaja = noCaja;
        this.lineaCaja = lineaCaja;
        this.noTractor = noTractor;
        this.lineaTractor = lineaTractor;
        this.noRemolque = noRemolque;
        this.placasCaja = placasCaja;
        this.nombreOperador = nombreOperador;
        this.estado = estado;
        this.placas = placas;
        this.temperatura = temperatura;
        this.escala = escala;
        this.motor = motor;
        this.motorObservacion = motorObservacion;
        this.cabina = cabina;
        this.cabinaObservacion = cabinaObservacion;
    }
}


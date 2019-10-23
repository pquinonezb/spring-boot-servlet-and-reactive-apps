package com.amx.infra.directorio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COLABORADOR")
public class Colaborador{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="NOMBRE")
    private String nombre="";
    
    @Column(name="A_PATERNO")
    private String apellidoP="";
    
    @Column(name="A_MATERNO")
    private String apellidoM="";
    
    @Column(name="PUESTO")
    private String puesto="";

    public Colaborador(){

    }

    public Colaborador(int id, String nombre, String apellidoP, String apellidoM, String puesto){
	this.id = id;
	this.nombre = nombre;
	this.apellidoP = apellidoP;
	this.apellidoM = apellidoM;
	this.puesto = puesto;
    }

    public int getId(){
	return this.id;
    }

    public void setId(int id){
	this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellidoP(){
        return this.apellidoP;
    }

    public void setApellidoP(String apellidoP){
        this.apellidoP = apellidoP;
    }

    public String getApellidoM(){
        return this.apellidoM;
    }

    public void setApellidoM(String apellidoM){
        this.apellidoM = apellidoM;
    }

    public String getPuesto(){
        return this.puesto;
    }

    public void setPuesto(String puesto){
        this.puesto = puesto;
    }

}

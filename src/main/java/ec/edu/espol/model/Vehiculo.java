/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author micha
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String tipo_de_motor;
    private int año;
    private double recorrido;
    private String color;
    private String tipo_combustible;
    private String vidrios;  //no aplica para motos
    private String transmision; //no aplica para motos
    private String traccion; //aplica para camionetas
    private double precio;
    
    //METODO CONSTRUCTOR PARA AUTOS Y CAMIONETAS
    if(tipo.toLowerCase() == "auto" || tipo.toLowerCase() == "camioneta")
    public Vehiculo(String placa, String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, String vidrios, String transmision, String traccion, double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_de_motor = tipo_de_motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.traccion = traccion;
        this.precio = precio;
    }
    
    //METODO CONSTRUCTOR PARA MOTOCICLETAS
    public Vehiculo(String placa, String marca, String modelo, String tipo_de_motor, int año, double recorrido, String color, String tipo_combustible, double precio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo_de_motor = tipo_de_motor;
        this.año = año;
        this.recorrido = recorrido;
        this.color = color;
        this.tipo_combustible = tipo_combustible;
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo_de_motor() {
        return tipo_de_motor;
    }

    public void setTipo_de_motor(String tipo_de_motor) {
        this.tipo_de_motor = tipo_de_motor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public double getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo_combustible() {
        return tipo_combustible;
    }

    public void setTipo_combustible(String tipo_combustible) {
        this.tipo_combustible = tipo_combustible;
    }

    public String getVidrios() {
        return vidrios;
    }

    public void setVidrios(String vidrios) {
        this.vidrios = vidrios;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import utilidad.Pila;

/**
 *
 * @author Andres
 */
public class Palabra implements Serializable{

    private String nombre;
    private Pila<String> traduccion;
    private String autor;
    private Pila<String> significadoOrigen;
    private Pila<String> significadoDestino;
    private ArrayList<String> traduccionesAlternas;

    public Palabra(String nombre, String autor) {
        this.nombre = nombre;
        traduccion = new Pila();
        this.autor = autor;
        significadoOrigen = new Pila();
        significadoDestino = new Pila();
        traduccionesAlternas = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pila<String> getTraduccion() {
        return traduccion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Pila<String> getSignificadoOrigen() {
        return significadoOrigen;
    }

    public Pila<String> getSignificadoDestino() {
        return significadoDestino;
    }

    public ArrayList<String> getTraduccionesAlternas() {
        return traduccionesAlternas;
    }

    public void agregarTraduccion(String tradu) {
        traduccion.agregar(tradu);
    }

    public void agregarSignificadoOrigen(String significado) {
        significadoOrigen.agregar(significado);
    }

    public void agregarSignificadoDestino(String significado) {
        significadoDestino.agregar(significado);
    }

    public void agregarTraduccionAlterna(String tradu) {
        traduccionesAlternas.add(tradu);
    }

    public ArrayList<String> traduccionAlterna() {
        ArrayList<String> lista = new ArrayList();
        for (int i = 0; i < traduccionesAlternas.size(); i++) {
            lista.add(traduccionesAlternas.get(i));
        }
        return lista;
    }

}

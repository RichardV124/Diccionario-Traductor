/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import utilidad.ListaDE;

/**
 *
 * @author Richard Vanegas - Andres Ciro
 */
public class Diccionario implements Serializable{

    private String idiomaOrigen;
    private String idiomaDestino;
    private ListaDE<Palabra> palabras;

    public Diccionario(String idiomaOrigen, String idiomaDestino) {
        this.idiomaOrigen = idiomaOrigen;
        this.idiomaDestino = idiomaDestino;
        palabras = new ListaDE();
    }

    public String getIdiomaOrigen() {
        return idiomaOrigen;
    }

    public void setIdiomaOrigen(String idiomaOrigen) {
        this.idiomaOrigen = idiomaOrigen;
    }

    public String getIdiomaDestino() {
        return idiomaDestino;
    }

    public void setIdiomaDestino(String idiomaDestino) {
        this.idiomaDestino = idiomaDestino;
    }

    public ListaDE<Palabra> getPalabras() {
        return palabras;
    }

    public void agregarPalabra(Palabra p) {
        palabras.add(p);
    }
    
    /**
     * Crea una lista con los nombres d elas palabras registradas
     * @return una lista de cadenas con todos las plabras
     */
    public ArrayList<String> listarPalabras() {
        ArrayList<String> lista = new ArrayList();
        for (int i = 0; i < palabras.size(); i++) {
            lista.add(palabras.get(i).getNombre());
        }
         Collections.sort(lista);
        return lista;
    }

    /**
     * Busca una palabra en la lista de palabras del diccionario
     * @param nombre nombre de la palabra que se buscara
     * @return el objeto palabra si la encuentra, en caso contrario null
     */
    public Palabra buscarPalabra(String nombre) {
        for (int i = 0; i < palabras.size(); i++) {
            if (palabras.get(i).getNombre().equalsIgnoreCase(nombre)) {
                return palabras.get(i);
            }
        }
        return null;
    }

    /**
     * Construye una lista con las palabras del diccionario que empiecen con 
     * una letra determinada
     * @param filtro caracter por el cual se filtrara
     * @return la lista con las palabras filtradas
     */
    public ArrayList<String> listarPalabrasFiltroInicial(String filtro) {

        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < palabras.size(); i++) {
            if (palabras.get(i).getNombre().startsWith(filtro)){
                lista.add(palabras.get(i).getNombre());
            }
        }
        Collections.sort(lista);
        return lista;
    }
     /**
     * Construye una lista con las palabras del diccionario que contengan 
     * unos determinados caracteres
     * @param filtro caracteres por los cuales se filtrara
     * @return la lista con las palabras filtradas
     */
    public ArrayList<String> listarPalabrasFiltroSubCadena(String filtro) {

        ArrayList<String> lista = new ArrayList<>();
        for (int i = 0; i < palabras.size(); i++) {
            if (palabras.get(i).getNombre().contains(filtro)){
                lista.add(palabras.get(i).getNombre());
            }
        }
        Collections.sort(lista);
        return lista;
    }
}

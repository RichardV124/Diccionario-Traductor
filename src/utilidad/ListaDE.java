/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.io.Serializable;

/**
 *
 * @author 416pc01
 */
public class ListaDE<G> implements Serializable {

    private Nodo<G> primero;
    private Nodo<G> ultimo;

    public ListaDE() {
        primero = null;
        ultimo = null;
    }

    /*
     * Agrega un nodo a la lista
     * @param obj; objeto que se guarda en el nodo agregado
     * return
     */
    public void add(G obj) {
        Nodo<G> nuevo = new Nodo(obj);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }

    }

    /**
     * cuenta los nodos que tiene la lista
     *
     * @return cantidad de nodos que tiene la lista
     */
    public int size() {
        int con = 0;
        Nodo<G> aux = null;
        if (primero != null) {
            con++;
            aux = primero;
            while (aux != ultimo) {
                aux = aux.siguiente;
                con++;
            }
        }
        return con;
    }

    /**
     * metodo que obtiene el objeto o informacion guardada en un nodo
     *
     * @param index el indice del nodo en el que se encuentra la informacion
     * @return la informacion contenida en el nodo
     */
    public G get(int index) {
        int con = 0;
        Nodo<G> aux = primero;
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Ha ingresado un valor por fuera del rango");
        } else if (index == 0) {
            return aux.dato;
        } else {
            while (con < index) {
                aux = aux.siguiente;
                con++;
            }
        }
        return aux.dato;
    }
}



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
public class Nodo<G> implements Serializable {

    G dato;
    Nodo<G> siguiente;
    Nodo<G> anterior;

 

    public Nodo(G dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
    
}

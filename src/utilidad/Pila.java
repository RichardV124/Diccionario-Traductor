/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 416pc01
 */
public class Pila <G> implements Serializable{

    ArrayList<G> pilas;
    
    /**
     *  Constructor de la pila
     */
    public Pila(){
        pilas= new ArrayList<>();
    }
    /**
     * Agrega un objeto al inicio de la pila
     * @param valor Objeto que sera agregado
     */
    public void agregar(G valor){
        pilas.add(valor);
    }
    
    /**
     * Elimina el ultimo objeto de la pila
     */
    public void remover(){
        pilas.remove(pilas.size()-1);
    }
    
    /**
     * Se obtiene el ultimo objeto de la pila
     * @return 
     */
    public G recuperar(){
        return pilas.get(pilas.size()-1);
    }
    
    /**
     * Determina si la pila esta vacia
     * @return true si esta vacia, en caso contrario false
     */
    public boolean vacio(){
        return pilas.isEmpty();
    }
    /**
     * Determina la dimension de la pila
     * @return la dimension de la cola
     */
    public int size(){
        return pilas.size();
    }

    public ArrayList<G> getPilas() {
        return pilas;
    }
    
    
}

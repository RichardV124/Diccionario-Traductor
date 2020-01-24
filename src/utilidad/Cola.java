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
public class Cola <G> implements Serializable{

    ArrayList<G> colas;
    
    /**
     *  Constructor de la cola
     */
    public Cola(){
        colas= new ArrayList<>();
    }
    /**
     * Agrega un objeto al inicio de la cola
     * @param valor Objeto que sera agregado
     */
    public void agregar(G valor){
        colas.add(0,valor);
    }
    
    /**
     * Elimina el ultimo objeto de la cola
     */
    public void remover(){
        colas.remove(colas.size()-1);
    }
    
    /**
     * Se obtiene el ultimo objeto de la cola
     * @return 
     */
    public G recuperar(){
        return colas.get(colas.size()-1);
    }
    
    /**
     * Determina si la cola esta vacia
     * @return true si esta vacia, en caso contrario false
     */
    public boolean vacio(){
        return colas.isEmpty();
    }
    /**
     * Determina la dimension de la cola
     * @return la dimension de la cola
     */
    public int size(){
        return colas.size();
    }

    public ArrayList<G> getColas() {
        return colas;
    }
    
    
}

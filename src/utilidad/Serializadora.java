/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidad;

import java.io.*;

/**
 *
 * @author 416pc01
 */
public class Serializadora {

    private ObjectInputStream lectorDeObjetos;
    private ObjectOutputStream escritorDeObjetos;

    /**
     * Escribe un objeto en bits que tenga implementado la clase Serializable
     * @param o objeto que sera serializado
     * @throws FileNotFoundException Excepcion que sera lanzada en caso que ocurra un error al leer el archio
     * @throws IOException Excepcion que sera lanzada en caso que no se pueda acceder al archio
     */
    public void escribirObjetos(Object o) throws FileNotFoundException,IOException {
        escritorDeObjetos = new ObjectOutputStream(new FileOutputStream("diccionarios.dat"));
        escritorDeObjetos.writeObject(o);                      
    }
    
    /**
     * Des-serializa un objeto
     * @param nombreDelArchivo
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public Object leerObjeto(String nombreDelArchivo) throws IOException, ClassNotFoundException{
       Object objeto= null;
       lectorDeObjetos = new ObjectInputStream(new FileInputStream(nombreDelArchivo));
       objeto = lectorDeObjetos.readObject();
        return objeto; 
    }
}

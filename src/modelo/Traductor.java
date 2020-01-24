/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import utilidad.Cola;
import utilidad.ListaDE;
import utilidad.Pila;

import utilidad.Serializadora;

/**
 *
 * @author Andres
 */
public class Traductor {

    private Cola<Palabra> ultimasPalabras;
    private ArrayList<Diccionario> diccionarios;
    private ArrayList<Usuario> usuarios;

    public Traductor() throws IOException {
        ultimasPalabras = new Cola<>();
        usuarios = new ArrayList();
        diccionarios = new ArrayList();
        desSerializarDiccionarios();
        inicializarLista();
    }

    public Cola<Palabra> getUltimasPalabras() {
        return ultimasPalabras;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Diccionario> getDiccionarios() {
        return diccionarios;
    }

    /**
     * Agrega un usuario a la lista de usuarios
     *
     * @param u usuario que se va a registrar
     * @return true si se registro correctamente, false si ya existe
     */
    public boolean registrarUsuario(Usuario u) {
        Usuario usu = buscarUsuario(u.getNombreUsuario());
        if (usu == null) {
            usuarios.add(u);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Busca un usuario por su nombre de usuario en la lista
     *
     * @param nomUsuario nombre de usuario el cual se buscara
     * @return el objeto usuario si lo encuentra, en caso contrario null
     */
    public Usuario buscarUsuario(String nomUsuario) {

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equalsIgnoreCase(nomUsuario)) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    /**
     * Valida el nombre de usuario y la contraseña del usuario que se logeara
     *
     * @param nomUsuario nombre de usuario de la persona que se logeara
     * @param contraseña contraseña de la persona que se logeara
     * @return el objeto usuario si el nombre de usuario y la contraseña
     * coinciden, en caso contrario null
     */
    public Usuario validarLogin(String nomUsuario, String contraseña) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getNombreUsuario().equalsIgnoreCase(nomUsuario)
                    && usuarios.get(i).getContraseña().equals(contraseña)) {
                return usuarios.get(i);
            }
        }
        return null;
    }

    /**
     * Lee un archivo de texto que contiene la informacion de las personas y las
     * guarda en la lista
     *
     * @throws IOException, en caso de no encontrar el archivo en la ruta
     * especificada, o no poder accederlo por encontrarse protegido.
     */
    public void inicializarLista() throws IOException {

        //Se crea el objeto FileReader que accedera al archivo
        FileReader entrada = new FileReader("../ProyectoFinal/src/archivos/usuarios.txt");
        //Se crea el objeto BufferedReader que leera el archivo
        BufferedReader archivo = new BufferedReader(entrada);
        //Se lee la primera linea del archivo y se guarda en la variable linea
        String linea = archivo.readLine();
        //En este ciclo se iran leyendo las lineas del archivo una a una
        while (linea != null) {

            String datos[] = linea.split("/ ");
            String nombre = datos[0];
            String apellido = datos[1];
            String email = datos[2];
            String genero = datos[3];
            String datosUsuario[] = datos[4].split(" - ");
            String nombreUsuario = datosUsuario[0];
            String contraseña = datosUsuario[1];
            String preguntaRespuesta = datos[5];
            String pregRes[] = preguntaRespuesta.split(" - ");
            String preguntaSeg = pregRes[0];
            String respuestaSeg = pregRes[1];
            Usuario usu = new Usuario(nombre, apellido, email, genero, nombreUsuario, contraseña, preguntaSeg, respuestaSeg);
            usuarios.add(usu);
            //Se lee la siguiente linea del archivo
            linea = archivo.readLine();
        }
        //Se cierra el archivo para liberar recursos de la memoria
        archivo.close();

    }

    /**
     * Serializa la lista diccionarios
     */
    public void serializarDiccionarios() {
        Serializadora serializado = new Serializadora();
        try {
            serializado.escribirObjetos(diccionarios);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error durante la"
                    + "lectura del archivo");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No ha sido posible acceder al archivo"
                    + " para leer la informacion");
        }
    }

    /**
     * Des-serializa la lista de diccionarios y los datos los carga en las
     * estrucuras de datos usadas
     */
    public void desSerializarDiccionarios() {
        Serializadora serializado = new Serializadora();
        try {
            Object objeto = serializado.leerObjeto("diccionarios.dat");
            diccionarios = (ArrayList<Diccionario>) objeto;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error durante la"
                    + "lectura del archivo");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No ha sido posible acceder al archivo"
                    + " para leer la informacion");
        }
    }

    /**
     * Construye una lista con todos los diccionarios que hay registrados
     *
     * @return lista con todos los diccionarios
     */
    public ArrayList<String> listarDiccionarios() {

        ArrayList<String> lista = new ArrayList();
        for (int i = 0; i < diccionarios.size(); i++) {
            lista.add(diccionarios.get(i).getIdiomaOrigen() + " - " + diccionarios.get(i).getIdiomaDestino());
        }
        return lista;
    }

    /**
     * Busca un diccionario en la lista de diccionarios
     *
     * @param origen lenguaje origen del diccionario que sera buscado
     * @param destino lenguaje destino del diccionario que sera buscado
     * @return el objeto diccionario si esta, en caso contrario null
     */
    public Diccionario buscarDiccionario(String origen, String destino) {

        for (int i = 0; i < diccionarios.size(); i++) {
            if (diccionarios.get(i).getIdiomaOrigen().equals(origen) && diccionarios.get(i).getIdiomaDestino().equals(destino)) {
                return diccionarios.get(i);
            }
        }
        return null;
    }

    /**
     * Crea un diccionario en la lista de diccionarios
     *
     * @param d diccionario que sera agregado a la lista
     * @return true en caso que se registre, false en caso que ya exista este
     * diccionario
     */
    public boolean crearDiccionario(Diccionario d) {
        Diccionario dic = buscarDiccionario(d.getIdiomaOrigen(), d.getIdiomaDestino());
        if (dic == null) {
            diccionarios.add(d);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Crea una lista con las ultimas 10 palabras agregadas al diccionario
     *
     * @param dicci diccionario al cual fue agregado la palabra
     * @return la lista con las palabras recientes
     */
    public ArrayList<String> listarRecientes(String dicci) {
        ArrayList<String> lista = new ArrayList();
        for (int i = 0; i < ultimasPalabras.size(); i++) {
            lista.add(ultimasPalabras.getColas().get(i).getNombre() + " / " + dicci);
        }
        return lista;
    }

    /**
     * Agrega una palabra a la cola de palabras recientes, teniendo en cuenta
     * que su dimension siempre sea 10
     *
     * @param p palabra que se agregara
     */
    public void agregarReciente(Palabra p) {
        if (ultimasPalabras.size() == 10) {
            ultimasPalabras.remover();
        }
        ultimasPalabras.agregar(p);
    }

    /**
     * Genera un archivo con todas las palabras que empiezen por una determinada
     * letra separandolas por el diccionario en el que se encuentran
     *
     * @param archivo, archivo creado y abierto para escritura
     * @param inicial, letra por la cual se construira el listado de palabras en
     * el archivo de texto
     * @throws IOException en caso que el archivo no se pueda generar
     */
    public void generarArchivoPorInicial(File archivo, String inicial) throws IOException {

        PrintWriter escritor = new PrintWriter(archivo);
        for (int i = 0; i < diccionarios.size(); i++) {
            ListaDE<Palabra> pala = diccionarios.get(i).getPalabras();
            escritor.println("Palabras en el diccionario " + diccionarios.get(i).getIdiomaOrigen() + " - "
                    + diccionarios.get(i).getIdiomaDestino() + " que empiezan por " + inicial);
            escritor.println();
            for (int j = 0; j < pala.size(); j++) {
                if (pala.get(j).getNombre().startsWith(inicial)) {
                    escritor.println(pala.get(j).getNombre());
                }
            }
            escritor.println();
            escritor.println("<--------------- o --------------->");
        }
        escritor.close();

    }

    /**
     * Genera un archivo con todas las palabras que hayan sido registradas por
     * un determinado autor separandolas por el diccionario en el que se
     * encuentran
     *
     * @param archivo, archivo creado y abierto para escritura
     * @param autor, autor por la cual se construira el listado de palabras en
     * el archivo de texto
     * @throws IOException en caso que el archivo no se pueda generar
     */
    public void generarArchivoPorAutor(File archivo, String autor) throws IOException {

        PrintWriter escritor = new PrintWriter(archivo);
        for (int i = 0; i < diccionarios.size(); i++) {
            ListaDE<Palabra> pala = diccionarios.get(i).getPalabras();
            escritor.println("Palabras en el diccionario " + diccionarios.get(i).getIdiomaOrigen() + " - "
                    + diccionarios.get(i).getIdiomaDestino() + " registradas por el usuario " + autor);
            escritor.println();
            for (int j = 0; j < pala.size(); j++) {
                if (pala.get(j).getAutor().equalsIgnoreCase(autor)) {
                    escritor.println(pala.get(j).getNombre());
                }
            }
            escritor.println();
            escritor.println("<--------------- o --------------->");
            escritor.println();
        }
        escritor.close();
    }

    /**
     * Genera un archivo con todas las palabras y sus datos, que esten
     * registradas en un determinado diccionario
     *
     * @param archivo, archivo creado y abierto para escritura
     * @throws IOException en caso que el archivo no se pueda generar
     */
    public void generarArchivoPorDiccionario(File archivo) throws IOException {

        PrintWriter escritor = new PrintWriter(archivo);
        for (int i = 0; i < diccionarios.size(); i++) {
            ListaDE<Palabra> pala = diccionarios.get(i).getPalabras();
            escritor.println("Palabras en el diccionario " + diccionarios.get(i).getIdiomaOrigen() + " - "
                    + diccionarios.get(i).getIdiomaDestino());
            escritor.println();
            for (int j = 0; j < pala.size(); j++) {
                escritor.println("Palabra: " + pala.get(j).getNombre());
                escritor.println("Traduccion: " + pala.get(j).getTraduccion().recuperar());
                escritor.println("Significado origen: " + pala.get(j).getSignificadoOrigen().recuperar());
                escritor.println("Significado destino: " + pala.get(j).getSignificadoDestino().recuperar());
                escritor.println("Autor: " + pala.get(j).getAutor());
                ArrayList<String> alternas = pala.get(j).getTraduccionesAlternas();
                escritor.println("Traducciones alternas: ");
                for (int k = 0; k < alternas.size(); k++) {
                    escritor.println(alternas.get(k));
                    escritor.println();
                }
                escritor.println("<--------------- o --------------->");
                escritor.println();
            }
        }
        escritor.close();

    }
}

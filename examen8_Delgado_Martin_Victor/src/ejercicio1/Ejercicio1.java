package ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author tu_nombre
 */
public class Ejercicio1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        //Implementa aquí tu ejercicio 1
        
        // Variables y objetos a usar en el desarrollo del codigo
        AgendaContactos agenda = new AgendaContactos();
        List<String> listaAficiones = new ArrayList();
        List<String> listaTemp;
        String[] tokensPersona, tokensNombre;
        String line;
        Persona personaActual;
        int numRandom;
        final int NUM_AFICIONES=3;
        
        // Creamos un reader que lea linea a linea el documento listadoAficiiones
        BufferedReader br = new BufferedReader(new FileReader("recursos/ListadoAficiones.txt"));
        while ((line = br.readLine()) != null) {
            // Añade a la lista de aficiones cada una de las lineas
            listaAficiones.add(line);
        }
        
        // Cerramos el flujo de datos y creamos otro al documento listadoContactos
        br.close();
        br = new BufferedReader(new FileReader("recursos/ListadoContactos.txt"));
        while ((line = br.readLine()) != null) {
            // Inicializamos la lista de aficiones y separamos la linea del documento en tokens con los que trabajar
            listaTemp = new ArrayList();
            tokensPersona = line.split(";");
            tokensNombre = tokensPersona[0].split(" ");
            
            // Creamos un objeto persona con los tokens extraidos del documento
            personaActual = new Persona(tokensNombre[0], tokensNombre[1], tokensNombre[2], tokensPersona[4], tokensPersona[1], tokensPersona[2], tokensPersona[3]);
            
            // Creamos un bucle que genere numeros aleatorios para añadir aficiones aleatorias a la lista
            for (int i = 0; i < NUM_AFICIONES; i++) {
                numRandom = generarNumeroAleatorio(listaAficiones.size());
                listaTemp.add(listaAficiones.get(numRandom));
            }
            
            // Añadimos la lista de aficiones a la persona y la persona a la agenda
            personaActual.setAficiones(listaTemp);
            agenda.aniadir(personaActual);
        }
        br.close();

        // Creamos un PrintStream para almacenar la informacion de la agenda en un documento
        PrintStream pr = new PrintStream("recursos/BDCAgendaContactos.txt");
        pr.println("ID. NOMBRE Y APELLIDOS\tDIRECCION\t\tTELEFONO\tFECHA NAC.\tTIPO CONTACTO\tAFICIONES");
        
        // El bucle recorre la agenda y almacena la informacion de las personas en el documento
        for (int i = 1; i < agenda.numContactos()+1; i++) {
            personaActual = agenda.buscarPorID(i);
            line = personaActual.getNombre() + " " + personaActual.getApellido1() + " " + personaActual.getApellido2();
            pr.printf("[%d] %s\t%s\t%s\t%s\t%s\t%s\n", i, line, personaActual.getDireccion(), personaActual.getTelefono(), personaActual.getFechaNacimiento(), personaActual.getTipoContacto(), personaActual.getAficiones());
        }
        pr.close();

    }

    //Utilidades que puedes necesitar
    public static int generarNumeroAleatorio(int maximoNumeroNoIncluido) {

        //Genera un numero aleatorio entre el 0 y el valor especificado, sin incluirlo.
        Random r = new Random();
        return r.nextInt(maximoNumeroNoIncluido);
    }

}//Prueba para commit
//Con merge
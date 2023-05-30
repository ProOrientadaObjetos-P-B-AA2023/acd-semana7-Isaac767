package Utilerias;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Formatter;
import java.util.Scanner;
import paquete1.Profesor;
public class ProbandoArchivos {
    public static void main(String[]args) throws FileNotFoundException, IOException, ClassNotFoundException {
        Profesor profesores[] = { new Profesor("Ivan", "Auxiliar"),
                new Profesor("David", "Principal"),
                new Profesor("Ruben", "Vago"),
                new Profesor("Anita", "Estrella") };
        Formatter archivoSalida = new Formatter("MiPrueba.txt");
        for (Profesor profeAux : profesores)
            archivoSalida.format("%s %s\n", profeAux.obtenerNombre(), profeAux.obtenerTipo());
        archivoSalida.close();
        Scanner archivoEntrada = new Scanner(new File("MiPrueba.txt"));
        Profesor profesores2[] = new Profesor[4];
        /*int i = 0;
        while (archivoEntrada.hasNext()) {
            Profesor profesor = new Profesor("", ""); // Crear una nueva instancia de Profesor
            profesor.establecerNombre(archivoEntrada.next()); // Llamar al método establecerNombre en el objeto profesor
            profesor.establecerTipo(archivoEntrada.next()); // Llamar al método establecerTipo en el objeto profesor
            profesores2[i] = profesor; // Asignar el objeto profesor al elemento correspondiente del arreglo profesores2
            i++;
}
        archivoEntrada.close();
        for (Profesor profeAux : profesores2) {
            System.out.println(profeAux);
        }*/
        Profes profes1[] = { new Profes("Ivan", "Auxiliar"),
                new Profes("David", "Principal"),
                new Profes("Ruben", "Vago"),
                new Profes("Anita", "Estrella") };
        //Flujo de SALIDA basada en bytes, para ecribir objetos en Archivos
        ObjectOutputStream archivoSalida2 = new ObjectOutputStream(new FileOutputStream("Profes.prof"));
        Profes p1 = new Profes("Isaac","Principal");
        Profes p2 = new Profes("Saul","Estrella");
        archivoSalida2.writeObject(p1);
        archivoSalida2.writeObject(p2);
        //Flujo de Entrada basada en bytes, para ecribir objetos en Archivos
    ObjectInputStream archivoEntrada2 = new ObjectInputStream(new FileInputStream("Profes.prof"));
    Profes prof1 = (Profes) archivoEntrada2.readObject();
    System.out.println(prof1);
        
    }
}

class Profes implements Serializable{
    private String  nombre,tipo;

    public Profes(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }  

    @Override
    public String toString() {
        return "Profes{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }
    
}
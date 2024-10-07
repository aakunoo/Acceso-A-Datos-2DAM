package practicas.practica9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Partidos {
/*
 Crea una clase llamada PartidoFutbol que guarde la información de cada uno de los partidos de una 
 eterminada liga. La clase debe guardar el nombre del equipo local, el nombre del equipo visitante, y los goles 
 que han metido cada uno de ellos durante el partido. La clase contendrá los siguientes métodos: 
  - Constructor por defecto.
  - Constructor con parámetros.
  - Métodos Setters/getters 

Escribe además un programa que lea desde un archivo .txt los partidos en el formato que podemos ver a continuación  y vaya creando objetos PartidoFutbol que se irán guardando en un ArrayList.

Real Madrid-2-Barcelona-1

Valladolid-1-Alavés-0

Sevilla-1-Betis-1
*/

	    public static void main(String[] args) {
	        // Creo un ArrayList para guardar los partidos
	        ArrayList<PartidoFutbol> listaPartidos = new ArrayList<>();

	        // Especifico la ruta del archivo
	        String rutaArchivo = "C:\\Users\\Manana\\Desktop\\Acceso-Datos-DAM2\\AAD-Tema1-File\\partidos.txt";

	        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
	            String linea;

	            // Leo el archivo línea por línea
	            while ((linea = br.readLine()) != null) {
	                // Separo los datos del partido usando el separador "-"
	                String[] datos = linea.split("-");

	                // Extraigo el equipo local, goles locals, equipo visitante, goles visitantes.
	                String equipoLocal = datos[0];
	                int golesLocal = Integer.parseInt(datos[1]);
	                String equipoVisitante = datos[3];
	                int golesVisitante = Integer.parseInt(datos[2]);

	                // Creo un nuevo objeto PartidoFutbol con los datos leídos
	                PartidoFutbol partido = new PartidoFutbol(equipoLocal, equipoVisitante, golesLocal, golesVisitante);

	                // Añado el objeto PartidoFutbol al ArrayList
	                listaPartidos.add(partido);
	            }

	        } catch (IOException e) {
	            System.out.println("Error al leer el archivo: " + e.getMessage());
	        }

	        // para mostrar partidos guardados del arraylist
	        System.out.println("Partidos leídos desde el archivo:");
	        for (PartidoFutbol partido : listaPartidos) {
	            System.out.println(partido);
	        }
	    }
	}

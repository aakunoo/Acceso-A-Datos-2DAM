package DatabaseMetaData.Practica2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Practica2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		System.out.println("Introduce el usuario con el que quieres realizar la consulta: ");
		String user = sc.nextLine();
		System.out.println("Introduce la contraseña del usuario '" + user + "':");
		String password = sc.nextLine(); 
		
		try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = conexion.getMetaData();
            
            mostrarInformacionBaseDatos(metaData);
            listarTablasYColumnas(metaData, user);
                 
		} catch (SQLException e) {
	        e.printStackTrace();
	        
		}finally {
			sc.close();
		}
	}
	
	private static void mostrarInformacionBaseDatos(DatabaseMetaData metaData) throws SQLException {
		    System.out.println("\n### Información de la Base de Datos ###");
		    System.out.println("Producto: " + metaData.getDatabaseProductName());
		    System.out.println("Versión del Producto: " + metaData.getDatabaseProductVersion());
		    System.out.println("Driver JDBC: " + metaData.getDriverName());
		    System.out.println("Versión del Driver: " + metaData.getDriverVersion());
		    System.out.println("URL de Conexión: " + metaData.getURL());
		    System.out.println("Usuario Actual: " + metaData.getUserName());
		    System.out.println("-------------------------------------------");
	}
            
	 private static void listarTablasYColumnas(DatabaseMetaData metaData, String user) throws SQLException {
            ResultSet tablas = metaData.getTables(null, user, "%", new String[]{"TABLE"});
            while(tablas.next()) {
            	String nombreTabla = tablas.getString("TABLE_NAME");
                String tipoTabla = tablas.getString("TABLE_TYPE");
                System.out.println("\nTabla: " + nombreTabla + " (Tipo: " + tipoTabla + ")");
                
                System.out.println("Columnas:");
                
                listarColumnasTabla(metaData, user, nombreTabla);
            }
	 }
                
	 private static void listarColumnasTabla(DatabaseMetaData metaData, String user, String nombreTabla) throws SQLException {
	        ResultSet columnas = metaData.getColumns(null, user, nombreTabla, null);
	        while (columnas.next()) {
	            String nombreColumna = columnas.getString("COLUMN_NAME");
	            String tipoColumna = columnas.getString("TYPE_NAME");
	            int sizeColumna = columnas.getInt("COLUMN_SIZE");
	            System.out.println("\t-" + nombreColumna + " (Tipo: " + tipoColumna + ", Tamaño: " + sizeColumna + ")");
	        }
	    }
	}
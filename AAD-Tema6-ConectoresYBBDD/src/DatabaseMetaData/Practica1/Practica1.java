package DatabaseMetaData.Practica1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Practica1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		System.out.println("Introduce el usuario con el que quieres realizar la consulta: ");
		String user = sc.nextLine();
		System.out.println("Introduce la contraseña del usuario '" + user + "':");
		String password = sc.nextLine(); 
		
		try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = conexion.getMetaData(); // para consultar información de la BBDD
            
            mostrarInformacionBaseDatos(metaData);
            listarTablas(metaData, user);
            listarColumnasTabla(metaData, user, "CUSTOMERS");
            listarClavesPrimarias(metaData, user, "CUSTOMERS");
            listarClavesForaneas(metaData, user, "ORDERS");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
	
	private static void mostrarInformacionBaseDatos(DatabaseMetaData metaData) throws SQLException {
            
            //------------------------ Pregunta Examen ------------------------
            System.out.println("### Información de la Base de Datos ###");
            System.out.println("Producto: " + metaData.getDatabaseProductName());
            System.out.println("Versión del Producto: " + metaData.getDatabaseProductVersion());
            System.out.println("Driver JDBC: " + metaData.getDriverName());
            System.out.println("Versión del Driver: " + metaData.getDriverVersion());
            System.out.println("URL de Conexión: " + metaData.getURL());
            System.out.println("Usuario Actual: " + metaData.getUserName());
            System.out.println("-------------------------------------------");
	}
	
	private static void listarTablas(DatabaseMetaData metaData, String user) throws SQLException {        
            System.out.println("\n### Listado de Tablas ###");
            ResultSet tablas = metaData.getTables(null, user, "%", new String[]{"TABLE"}); // Pongo user en vez de "OT", evito hardcoding.
            while (tablas.next()) {
            	
                String nombreTabla = tablas.getString("TABLE_NAME");
                String tipoTabla = tablas.getString("TABLE_TYPE");
                System.out.println("Tabla: " + nombreTabla + " (Tipo: " + tipoTabla + ")");
            }
            System.out.println("-------------------------------------------");
	}

	// Pongo user en todos los parametros para evitar hardcoding, para mas flexibilidad y mantenimiento
	 private static void listarColumnasTabla(DatabaseMetaData metaData, String user, String tabla) throws SQLException {  
            // Columnas tabla CUSTOMERS
            System.out.println("\n### Columnas de la Tabla: CUSTOMERS ###");
            ResultSet columnas = metaData.getColumns(null, user, "CUSTOMERS", null);
            while (columnas.next()) {
            	
                String nombreColumna = columnas.getString("COLUMN_NAME");
                String tipoColumna = columnas.getString("TYPE_NAME");
                int sizeColumna = columnas.getInt("COLUMN_SIZE");
                System.out.println("Columna: " + nombreColumna + " (Tipo: " + tipoColumna + ", Tamaño: " + sizeColumna + ")");
            }
            System.out.println("-------------------------------------------");
	 }

	 private static void listarClavesPrimarias(DatabaseMetaData metaData, String user, String tabla) throws SQLException {
            // Claves primarias CUSTOMERS
            System.out.println("\n### Claves Primarias de la Tabla: CUSTOMERS ###");
            ResultSet clavesPrimarias = metaData.getPrimaryKeys(null, user, "CUSTOMERS");
            while (clavesPrimarias.next()) {
            	
                String pkNombreColumn = clavesPrimarias.getString("COLUMN_NAME");
                String pkNombre = clavesPrimarias.getString("PK_NAME");
                System.out.println("Columna: " + pkNombreColumn + " (Clave Primaria: " + pkNombre + ")");
            }
            System.out.println("-------------------------------------------");
	 }
	 
	 private static void listarClavesForaneas(DatabaseMetaData metaData, String user, String tabla) throws SQLException {
            // Claves foráneas ORDERS
            System.out.println("\n### Claves Foráneas de la Tabla: ORDERS ###");
            ResultSet clavesForaneas = metaData.getImportedKeys(null, user, "ORDERS");
            while (clavesForaneas.next()) {
            	
                String fkNombreColumna = clavesForaneas.getString("FKCOLUMN_NAME");
                String pkNombreTabla = clavesForaneas.getString("PKTABLE_NAME");
                String pkColumnaNombre = clavesForaneas.getString("PKCOLUMN_NAME");
                System.out.println("Columna FK: " + fkNombreColumna + " = Tabla PK: " + pkNombreTabla + " (Columna PK: " + pkColumnaNombre + ")");
            }
            System.out.println("-------------------------------------------");
	 }
}

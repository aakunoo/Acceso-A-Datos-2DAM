package infoDataBaseMultas;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InfoDataBaseMultas {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        System.out.println("Introduce el usuario con el que quieres realizar la consulta: ");
        String user = sc.nextLine().toUpperCase(); 
        System.out.println("Introduce la contraseña del usuario '" + user + "':");
        String password = sc.nextLine();

        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = conexion.getMetaData();

            mostrarInformacionBaseDatos(metaData);
            listarTablasYVistas(metaData, user);
        
        
        
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void listarTablasYVistas(DatabaseMetaData metaData, String user) throws SQLException {
     
        String[] tipos = {"TABLE", "VIEW"};

        
        ResultSet rsTablas = metaData.getTables(null, user, "%", tipos);

        while (rsTablas.next()) {
            String nombreTabla = rsTablas.getString("TABLE_NAME");
            String tipoObjeto = rsTablas.getString("TABLE_TYPE"); // TABLE o VIEW
            System.out.println("\nTabla: " + nombreTabla + " (Tipo: " + tipoObjeto + ")");


            listarColumnas(metaData, user, nombreTabla);

            if ("TABLE".equals(tipoObjeto)) {
                listarClavesPrimarias(metaData, user, nombreTabla);
                listarClavesForaneas(metaData, user, nombreTabla);
            }
        }
        rsTablas.close();
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
	
	private static void listarColumnas(DatabaseMetaData metaData, String user, String nombreObjeto) throws SQLException {
        System.out.println("  - Columnas de " + nombreObjeto + ":");
        ResultSet rsColumnas = metaData.getColumns(null, user, nombreObjeto, null);
        while (rsColumnas.next()) {
            String nombreCol = rsColumnas.getString("COLUMN_NAME");
            String tipoCol = rsColumnas.getString("TYPE_NAME");
            int sizeCol = rsColumnas.getInt("COLUMN_SIZE");
            System.out.println("\t   * " + nombreCol + " (Tipo: " + tipoCol + ", Tamaño: " + sizeCol + ")");
        }
        rsColumnas.close();
    }
	
	private static void listarClavesPrimarias(DatabaseMetaData metaData, String user, String tabla) throws SQLException {
        ResultSet rsPK = metaData.getPrimaryKeys(null, user, tabla);
        System.out.println("  - Claves Primarias de la tabla " + tabla + ":");
        boolean foundPK = false;
        while (rsPK.next()) {
            foundPK = true;
            String colName = rsPK.getString("COLUMN_NAME");
            String pkName = rsPK.getString("PK_NAME"); // Nombre de la constraint
            short keySeq = rsPK.getShort("KEY_SEQ");   // Orden en la PK
            System.out.println("\t   * Columna PK: " + colName + " (constraint: " + pkName 
                                + ", secuencia en PK: " + keySeq + ")");
        }
        if(!foundPK) {
            System.out.println("\t   (No tiene clave primaria o no está definida en el diccionario)");
        }
        rsPK.close();
    }
	
	private static void listarClavesForaneas(DatabaseMetaData metaData, String user, String tabla) throws SQLException {
        ResultSet rsFK = metaData.getImportedKeys(null, user, tabla);
        System.out.println("  - Claves Foráneas (ImportedKeys) de la tabla " + tabla + ":");
        boolean foundFK = false;
        while (rsFK.next()) {
            foundFK = true;
            String fkColName = rsFK.getString("FKCOLUMN_NAME");   // Columna en esta tabla
            String pkTableName = rsFK.getString("PKTABLE_NAME");  // Tabla referenciada
            String pkColName = rsFK.getString("PKCOLUMN_NAME");   // Columna referenciada
            String fkName = rsFK.getString("FK_NAME");            // Nombre constraint FK
            System.out.println("\t   * FK " + fkName 
                                + ": " + fkColName + " -> " 
                                + pkTableName + "." + pkColName);
        }
        if(!foundFK) {
            System.out.println("\t   (No tiene claves foráneas)");
        }
        rsFK.close();
    }
	
	

}

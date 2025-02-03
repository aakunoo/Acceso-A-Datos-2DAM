package DatabaseMetaData.Practica3;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Practica3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) Pedir datos de conexión
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        System.out.println("Introduce el usuario con el que quieres realizar la consulta: ");
        String user = sc.nextLine().toUpperCase(); // Convertimos a mayúsculas por convención en Oracle
        System.out.println("Introduce la contraseña del usuario '" + user + "':");
        String password = sc.nextLine();

        // 2) try-with-resources para abrir y cerrar la conexión
        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            DatabaseMetaData metaData = conexion.getMetaData();

            mostrarInformacionBaseDatos(metaData);
            listarTablasYVistas(metaData, user);

            // 5) Listar procedimientos y funciones
//            listarProcedimientos(metaData, user);
//            listarFunciones(metaData, user);
//
//            // 6) Listar triggers (usando SQL en vistas del diccionario de Oracle)
//            listarTriggers(conexion, user);
//
//            // 7) Listar secuencias (también con SQL directo)
//            listarSecuencias(conexion, user);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }

    // ----------------------------------------------------------------
    // 1) Información general de la BD
    // ----------------------------------------------------------------
    private static void mostrarInformacionBaseDatos(DatabaseMetaData metaData) throws SQLException {
        System.out.println("\n### Información de la Base de Datos ###");
        System.out.println("Producto: " + metaData.getDatabaseProductName());
        System.out.println("Versión del Producto: " + metaData.getDatabaseProductVersion());
        System.out.println("Driver JDBC: " + metaData.getDriverName());
        System.out.println("Versión del Driver: " + metaData.getDriverVersion());
        System.out.println("URL de Conexión: " + metaData.getURL());
        System.out.println("Usuario Actual: " + metaData.getUserName()); // Puede devolver "USUARIO@SID"
        System.out.println("-------------------------------------------");
    }

    // ----------------------------------------------------------------
    // 2) Listar TABLAS y VISTAS del usuario
    // ----------------------------------------------------------------
    private static void listarTablasYVistas(DatabaseMetaData metaData, String user) throws SQLException {
        // Podemos buscar tanto "TABLE" como "VIEW"
        String[] tipos = {"TABLE", "VIEW"};

        // getTables(catalog, schemaPattern, tableNamePattern, types)
        ResultSet rsTablas = metaData.getTables(null, user, "%", tipos);

        while (rsTablas.next()) {
            String nombreTabla = rsTablas.getString("TABLE_NAME");
            String tipoObjeto = rsTablas.getString("TABLE_TYPE"); // TABLE o VIEW
            System.out.println("\nObjeto: " + nombreTabla + " (Tipo: " + tipoObjeto + ")");

            // Llamamos a métodos concretos cuando es una "TABLE"
            // (aunque para una VIEW también podríamos listar columnas, PK, FKs, etc.,
            //  pero a menudo las vistas no tienen PK ni FK definidas).
            listarColumnas(metaData, user, nombreTabla);

            if ("TABLE".equals(tipoObjeto)) {
                listarClavesPrimarias(metaData, user, nombreTabla);
                listarClavesForaneas(metaData, user, nombreTabla);
//                listarClavesExportadas(metaData, user, nombreTabla);
//                listarIndices(metaData, user, nombreTabla);
            }
        }
        rsTablas.close();
    }

    // ----------------------------------------------------------------
    // 3) Listar COLUMNAS de una tabla o vista
    // ----------------------------------------------------------------
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

    // ----------------------------------------------------------------
    // 4) Listar CLAVES PRIMARIAS
    // ----------------------------------------------------------------
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

    // ----------------------------------------------------------------
    // 5) Listar CLAVES FORÁNEAS (Imported Keys)
    // ----------------------------------------------------------------
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

    // ----------------------------------------------------------------
    // 6) Listar CLAVES EXPORTADAS (Exported Keys)
    //    - Tablas que dependen de la actual
    // ----------------------------------------------------------------
//    private static void listarClavesExportadas(DatabaseMetaData metaData, String user, String tabla) throws SQLException {
//        ResultSet rsEK = metaData.getExportedKeys(null, user, tabla);
//        System.out.println("  - Claves Exportadas (otras tablas con FK hacia " + tabla + "):");
//        boolean foundEK = false;
//        while (rsEK.next()) {
//            foundEK = true;
//            String pkColName = rsEK.getString("PKCOLUMN_NAME");   // Columna PK en esta tabla
//            String fkTableName = rsEK.getString("FKTABLE_NAME");  // Tabla que hace referencia
//            String fkColName = rsEK.getString("FKCOLUMN_NAME");   // Columna en la tabla foránea
//            String fkName = rsEK.getString("FK_NAME");
//            System.out.println("\t   * " + fkName + ": " 
//                                + tabla + "." + pkColName 
//                                + " -> " + fkTableName + "." + fkColName);
//        }
//        if(!foundEK) {
//            System.out.println("\t   (No hay tablas que dependan de esta)");
//        }
//        rsEK.close();
//    }

//    // ----------------------------------------------------------------
//    // 7) Listar ÍNDICES
//    // ----------------------------------------------------------------
//    private static void listarIndices(DatabaseMetaData metaData, String user, String tabla) throws SQLException {
//        ResultSet rsIndex = metaData.getIndexInfo(null, user, tabla, false, false);
//        System.out.println("  - Índices de la tabla " + tabla + ":");
//        boolean foundIndex = false;
//        while(rsIndex.next()) {
//            foundIndex = true;
//            String indexName = rsIndex.getString("INDEX_NAME");
//            boolean nonUnique = rsIndex.getBoolean("NON_UNIQUE");
//            String columnName = rsIndex.getString("COLUMN_NAME");
//            short position = rsIndex.getShort("ORDINAL_POSITION");
//            System.out.println("\t   * Índice: " + indexName 
//                                + (nonUnique ? " (no único) " : " (único) ")
//                                + " Columna: " + columnName 
//                                + " (posición en índice: " + position + ")");
//        }
//        if(!foundIndex) {
//            System.out.println("\t   (No se han encontrado índices o es una tabla vacía)");
//        }
//        rsIndex.close();
//    }

    // ----------------------------------------------------------------
    // 8) Listar PROCEDIMIENTOS (Stored Procedures)
    //    - En Oracle, muchas veces se definen como "PROCEDURE" en package.
    // ----------------------------------------------------------------
//    private static void listarProcedimientos(DatabaseMetaData metaData, String user) throws SQLException {
//        // getProcedures(catalog, schemaPattern, procedureNamePattern)
//        // Devolución en Oracle: a veces verás "PACKAGE_NAME.PROCEDURE_NAME" o similares
//        ResultSet rsProc = metaData.getProcedures(null, user, "%");
//        System.out.println("\n### Procedimientos almacenados (user: " + user + ") ###");
//        boolean foundProc = false;
//        while(rsProc.next()) {
//            foundProc = true;
//            String procName = rsProc.getString("PROCEDURE_NAME");
//            String remarks = rsProc.getString("REMARKS"); // Comentario o descripción
//            // En Oracle, la columna "PROCEDURE_TYPE" puede variar
//            System.out.println("   * " + procName + " - " + (remarks != null ? remarks : ""));
//        }
//        if(!foundProc) {
//            System.out.println("   (No se encontraron procedimientos o no tienes permisos para verlos)");
//        }
//        rsProc.close();
//    }

    // ----------------------------------------------------------------
    // 9) Listar FUNCIONES (Stored Functions)
    //    - Similar a Procedures, pero en la API moderna de JDBC.
    // ----------------------------------------------------------------
//    private static void listarFunciones(DatabaseMetaData metaData, String user) throws SQLException {
//        // getFunctions(catalog, schemaPattern, functionNamePattern)
//        // En Oracle puede que no aparezcan funciones de packages, etc.
//        ResultSet rsFunc = metaData.getFunctions(null, user, "%");
//        System.out.println("\n### Funciones almacenadas (user: " + user + ") ###");
//        boolean foundFunc = false;
//        while(rsFunc.next()) {
//            foundFunc = true;
//            String funcName = rsFunc.getString("FUNCTION_NAME");
//            String remarks = rsFunc.getString("REMARKS");
//            // "FUNCTION_TYPE" indica si es desconocida, si devuelve tabla, etc.
//            System.out.println("   * " + funcName + " - " + (remarks != null ? remarks : ""));
//        }
//        if(!foundFunc) {
//            System.out.println("   (No se encontraron funciones o no tienes permisos)");
//        }
//        rsFunc.close();
//    }

    // ----------------------------------------------------------------
    // 10) Listar TRIGGERS (Oracle)
    //    - Vía consulta SQL en la vista USER_TRIGGERS (DatabaseMetaData no incluye triggers)
    // ----------------------------------------------------------------
//    private static void listarTriggers(Connection conexion, String user) throws SQLException {
//        // En Oracle, USER_TRIGGERS contiene las definiciones de triggers del esquema actual.
//        // Cambiamos a mayúsculas el usuario para la condición (generalmente user se guarda en mayúsculas).
//        String sql = "SELECT TRIGGER_NAME, TABLE_NAME, TRIGGER_TYPE, TRIGGERING_EVENT, STATUS "
//                   + "FROM USER_TRIGGERS "
//                   + "ORDER BY TRIGGER_NAME";
//
//        try(PreparedStatement ps = conexion.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery()) {
//            System.out.println("\n### Triggers del usuario: " + user + " ###");
//            boolean found = false;
//            while(rs.next()) {
//                found = true;
//                String triggerName = rs.getString("TRIGGER_NAME");
//                String tableName = rs.getString("TABLE_NAME");
//                String triggerType = rs.getString("TRIGGER_TYPE");
//                String triggeringEvent = rs.getString("TRIGGERING_EVENT");
//                String status = rs.getString("STATUS");
//                // Oracle define TRIGGER_TYPE (BEFORE EACH ROW, AFTER STATEMENT, etc.) y TRIGGERING_EVENT (INSERT, UPDATE, DELETE...)
//                System.out.println("   * " + triggerName + " [Tabla: " + tableName 
//                                    + ", Tipo: " + triggerType 
//                                    + ", Evento: " + triggeringEvent 
//                                    + ", Estado: " + status + "]");
//            }
//            if(!found) {
//                System.out.println("   (No se han encontrado triggers)");
//            }
//        }
//    }

    // ----------------------------------------------------------------
    // 11) Listar SECUENCIAS (Oracle)
    //    - Vía consulta SQL en la vista USER_SEQUENCES
    // ----------------------------------------------------------------
//    private static void listarSecuencias(Connection conexion, String user) throws SQLException {
//        // En Oracle, USER_SEQUENCES contiene todas las secuencias del esquema actual.
//        String sql = "SELECT SEQUENCE_NAME, MIN_VALUE, MAX_VALUE, INCREMENT_BY, LAST_NUMBER "
//                   + "FROM USER_SEQUENCES ORDER BY SEQUENCE_NAME";
//
//        try(PreparedStatement ps = conexion.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery()) {
//            System.out.println("\n### Secuencias del usuario: " + user + " ###");
//            boolean found = false;
//            while(rs.next()) {
//                found = true;
//                String seqName = rs.getString("SEQUENCE_NAME");
//                long minVal = rs.getLong("MIN_VALUE");
//                long maxVal = rs.getLong("MAX_VALUE");
//                long increment = rs.getLong("INCREMENT_BY");
//                long lastNumber = rs.getLong("LAST_NUMBER");
//                System.out.println("   * " + seqName 
//                                    + " [MIN=" + minVal 
//                                    + ", MAX=" + maxVal 
//                                    + ", INC=" + increment 
//                                    + ", LAST=" + lastNumber + "]");
//            }
//            if(!found) {
//                System.out.println("   (No se han encontrado secuencias)");
//            }
//        }
//    }
}

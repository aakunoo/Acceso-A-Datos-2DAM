package ejercicios;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		/*
		 * Crea un programa Java que obtenga las siguientes propiedades específicas : versionJava, sistemaOperativo, directorioUsuario.
		 * Sube el .java y pantallazos que demuestren su ejecución.
		 */
		
		String versionJava = System.getProperty("java.version");
		String sistemaOperativo = System.getProperty("os.name");
		String directorioUsuario = System.clearProperty("user.home");
		
		System.out.println("Versión de Java: " + versionJava);
		System.out.println("Sistema operarivo: " + sistemaOperativo);
		System.out.println("Directorio del usuario: " + directorioUsuario);
		
	}

}

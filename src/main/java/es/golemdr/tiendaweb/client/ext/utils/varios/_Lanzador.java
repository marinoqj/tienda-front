package es.golemdr.tiendaweb.client.ext.utils.varios;

public class _Lanzador {

	private static String proyecto = "C:\\Desarrollo\\golem-box\\desarrollo\\codigo\\java\\proyectos\\inventapps"; 
	
	
	
	public static void main(String[] args) {
		
		InspectorProyectos.analizarProyecto(proyecto);
		
		System.out.println("Generando NIF...");
		for(int i= 0; i < 30; i++){
			System.out.println(GeneradorDocumentos.generarNIF());
		}

	}

}

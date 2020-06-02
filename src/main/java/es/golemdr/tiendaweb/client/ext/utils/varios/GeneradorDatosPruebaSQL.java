package es.golemdr.tiendaweb.client.ext.utils.varios;

import java.util.Random;



public class GeneradorDatosPruebaSQL {

    private static final String [] NOMBRE = {"Antonio", "Jose", "Manuel", "Francisco", "Juan", "David", "Jose Antonio", "Jose Luis", "Javier", "Francisco Javier", "Jesus", 
			"Daniel", "Carlos", "Miguel", "Alejandro", "Jose Manuel", "Rafael", "Pedro", "Angel", "Miguel Angel", "Jose Maria", "Fernando", 
			"Pablo", "Luis", "Sergio", "Jorge", "Alberto", "Juan Carlos", "Juan Jose", "Alvaro", "Diego", "Adrian", "Juan Antonio", "Raul", 
			"Enrique", "Ramon", "Vicente", "Ivan", "Ruben", "Oscar", "Andres", "Joaquin", "Juan Manuel", "Santiago", "Eduardo", "Victor", 
			"Roberto", "Jaime", "Francisco Jose", "Mario", "Ignacio", "Alfonso", "Salvador", "Ricardo", "Marcos", "Jordi", "Emilio", 
			"Julian", "Julio", "Guillermo", "Gabriel", "Tomas", "Agustin", "Jose Miguel", "Marc", "Gonzalo", "Felix", "Jose Ramon", 
			"Mohamed", "Hugo", "Joan", "Ismael", "Nicolas", "Cristian", "Samuel", "Mariano", "Josep", "Domingo", "Juan Francisco", "Aitor", 
			"Martin", "Alfredo", "Sebastian", "Jose Carlos", "Felipe", "Hector", "Cesar", "Jose Angel", "Jose Ignacio", "Victor Manuel", 
			"Iker", "Gregorio", "Luis Miguel", "Alex", "Jose Francisco", "Juan Luis", "Rodrigo", "Albert", "Xavier", "Lorenzo",
			"Maria del Carmen", "Maria", "Carmen", "Josefa", "Isabel", "Ana maria", "Maria Pilar", "Maria Dolores", "Maria Teresa", "Ana", 
			"Laura", "Francisca", "Maria de los Angeles", "Cristina", "Antonia", "Marta", "Dolores", "Maria Isabel", "Maria Jose", 
			"Lucia", "Maria Luisa", "Pilar", "Elena", "Concepcion", "Sara", "Paula", "Manuela", "Mercedes", "Rosa maria", "Raquel", 
			"Maria Jesus", "Juana", "Rosario", "Teresa", "Encarnacion", "Beatriz", "Nuria", "Silvia", "Julia", "Rosa", "Montserrat", 
			"Patricia", "Irene", "Andrea", "Rocio", "Monica", "Alba", "Maria del Mar", "Angela", "Sonia", "Alicia", "Sandra", "Susana", 
			"Margarita", "Marina", "Yolanda", "Maria Josefa", "Natalia", "Maria Rosario", "Inmaculada", "Eva", "Maria Mercedes", "Esther", 
			"Ana Isabel", "Angeles", "Noelia", "Claudia", "Veronica", "Amparo", "Maria Rosa", "Carolina", "Maria Victoria", "Carla", "Eva Maria", 
			"Maria Concepcion", "Nerea", "Lorena", "Ana Belen", "Victoria", "Miriam", "Maria Elena", "Sofia", "Catalina", "Ines", "Maria Antonia", 
			"Consuelo", "Emilia", "Maria Nieves", "Lidia", "Luisa", "Gloria", "Celia", "Olga", "Aurora", "Esperanza", "Josefina", "Maria Soledad", 
			"Milagros", "Maria Cristina", "Daniela"};



    private static final String [] APELLIDO1 = {"Garcia", "Gonzalez ", "Rodriguez", "Fernandez", "Lopez", "Martinez", "Sanchez", "Perez", "Gomez", "Martin", "Jimenez", "Ruiz", 
			"Hernandez", "Diaz", "Moreno", "Alvarez", "Muñoz", "Romero", "Alonso", "Gutierrez", "Navarro", "Torres", "Dominguez", "Vazquez", "Ramos", "Gil", 
			"Ramirez", "Serrano", "Blanco", "Molina", "Suarez", "Morales", "Ortega", "Delgado", "Castro", "Ortiz", "Rubio", "Marin", "Sanz", "Nuñez", "Iglesias", 
			"Medina", "Garrido", "Cortes", "Santos", "Castillo", "Lozano", "Guerrero", "Cano", "Prieto", "Mendez", "Calvo", "Cruz", "Gallego", "Vidal", "Leon", "Marquez", 
			"Herrera", "Peña", "Flores", "Cabrera", "Campos", "Vega", "Fuentes", "Diez", "Carrasco", "Caballero", "Nieto", "Reyes", "Aguilar", "Pascual", "Herrero", 
			"Santana", "Lorenzo", "Hidalgo", "Montero", "Gimenez", "Ibañez", "Ferrer", "Duran", "Santiago", "Vicente", "Benitez", "Mora", "Arias", "Vargas", "Carmona", 
			"Crespo", "Roman", "Pastor", "Soto", "Saez", "Velasco", "Moya", "Soler", "Esteban", "Parra", "Bravo", "Gallardo", "Rojas", "Pardo", "Merino", "Franco", 
			"Espinosa", "Lara", "Izquierdo", "Rivas", "Rivera", "Casado", "Arroyo", "Redondo", "Camacho", "Silva", "Rey", "Vera", "Galan", "Luque", "Otero", "Montes", 
			"Rios", "Sierra", "Segura", "Carrillo", "Marcos", "Marti", "Soriano", "Mendoza", "Bernal", "Robles", "Vila", "Valero", "Exposito", "Palacios", "Heredia", 
			"Macias", "Benito", "Varela", "Andres", "Guerra", "Bueno", "Roldan", "Mateo", "Contreras", "Villar", "Pereira", "Miranda", "Guillen", "Mateos", "Escudero", 
			"Aguilera", "Casas", "Menendez", "Aparicio", "Rivero", "Estevez", "Padilla", "Beltran", "Calderon", "Galvez", "Rico", "Gracia", "Abad", "Conde", "Jurado", 
			"Salas", "Plaza", "Quintana", "Aranda", "Acosta", "Bermudez", "Blazquez", "Roca", "Santamaria", "Salazar", "Guzman", "Miguel", "Costa", "Serra", "Manzano", 
			"Villanueva", "Cuesta", "Tomas", "Hurtado", "Rueda", "Trujillo", "Avila", "Pacheco", "Simon", "De la Fuente", "Pons", "Mesa", "Lazaro", "Sancho", "Del Rio", 
			"Escobar", "Millan", "Luna", "Alarcon", "Blasco", "Zamora"};
		
    private static final String [] APELLIDO2 = {"Llorente" ,"Moral" ,"Vela" ,"Salgado" ,"Carbonell" ,"Villegas" ,"Requena" ,"Arribas" ,"Alfonso" ,"Sevilla" ,"Ayala" ,"Pelaez" ,"Prado" ,
			"Barrios" ,"Font" ,"Olivares" ,"Carballo" ,"Piñeiro" ,"Ferreira" ,"Luis" ,"Esteve" ,"Solis" ,"Quintero" ,"Pineda" ,"Camara" ,"Salinas" ,"Grau" ,"Perea" ,
			"Bosch" ,"Marques" ,"Castilla" ,"Cid" ,"Pinto" ,"Cantero" ,"Marrero" ,"De la rosa" ,"Ballester" ,"Sanchis" ,"Palomo" ,"Arevalo" ,"Baena" ,"Nicolas" ,"Rincon" 
			,"Casanova" ,"Miralles" ,"Sala" ,"Porras" ,"Belmonte" ,"Lago" ,"Recio" ,"Pino" ,"Herranz" ,"Palma" ,"Cardona" ,"Barba" ,"Muñiz" ,"Arranz" ,"Ventura" ,"Cobos" 
			,"Singh" ,"Coll" ,"Cabezas" ,"Barreiro" ,"Cuadrado" ,"Madrid" ,"Angulo" ,"Cervera" ,"Vaquero" ,"Velez" ,"Puente" ,"Ocaña" ,"Da silva" ,"Navarrete" ,"Becerra" ,
			"Ochoa" ,"Granados" ,"Pujol" ,"Tapia" ,"Bello" ,"Alfaro" ,"Peralta" ,"Vergara" ,"Valls" ,"Gamez" ,"Latorre" ,"Alcantara" ,"Losada" ,"Castellanos" ,"Mejias" ,
			"Corrales" ,"Rovira" ,"Egea" ,"Sastre" ,"Campo" ,"Barragan" ,"Falcon" ,"Fraile" ,"Cebrian" ,"Estrada" ,"Godoy" ,"Zabala" ,"Moreira" ,"Mari" ,"Armas" ,"Ripoll" ,
			"De leon" ,"Ferrando" ,"Rocha" ,"Orellana" ,"Barea" ,"Moro" ,"Veiga" ,"Jara" ,"Baez" ,"Jordan" ,"Montiel" ,"Mayor" ,"Catala" ,"Barrero" ,"Del campo" ,"Sandoval" ,
			"Climent" ,"Fraga" ,"Tortosa" ,"San martin" ,"Taboada" ,"Lobo" ,"Prada" ,"Ayuso" ,"Prados" ,"Bejarano" ,"Arteaga" ,"Abril" ,"Tamayo" ,"Moron" ,"Amoros" ,"Maya" ,
			"Padron" ,"Dieguez" ,"Patiño" ,"Aleman" ,"Peñalver" ,"Alvaro" ,"Batista" ,"Almeida" ,"Manso" ,"Yuste" ,"Maroto" ,"Cerda" ,"Infante" ,"Barros" ,"Galera" ,"Berenguer"
			,"Albert" ,"Ye" ,"Nogales" ,"Atienza" ,"Pinilla" ,"Manrique" ,"Ribera" ,"Mota" ,"Machado" ,"Pedrosa" ,"Canales" ,"Miro" ,"Villaverde" ,"Del olmo" ,"Miguez" ,"Diego"
			,"Lucena" ,"Sampedro" ,"Viñas" ,"Echeverria" ,"Jaramillo" ,"Medrano" ,"Villena" ,"Dueñas" ,"Teruel" ,"Cifuentes" ,"Manzanares" ,"Mejia" ,"Ubeda" ,"Echevarria" 
			,"Almagro" ,"Raya" ,"Xu" ,"Sevillano" ,"Ortuño" ,"Novoa" ,"Li" ,"Merchan" ,"Checa" ,"Ares" ,"Trigo" ,"De las heras" ,"Lujan" ,"Robledo" ,"Perdomo" ,"Morillas" 
			,"Acedo" ,"España"};
	
	
	
	public static String generarInsertUsuarios(int numeroUsuarios) {
	    
		Random aleatorio = new Random();
		int nombre = 0;
		int apellido1 = 0;
		int apellido2 = 0;
		int secuencia = 1;
		StringBuffer sb = new StringBuffer();
		
		for(int i= 0; i < numeroUsuarios; i++){
		

			nombre = aleatorio.nextInt(NOMBRE.length);
			apellido1 = aleatorio.nextInt(APELLIDO1.length);
			apellido2 = aleatorio.nextInt(APELLIDO2.length);
			
			sb.append("INSERT INTO USUARIOS (ID_USUARIO, NOMBRE, APELLIDO1, APELLIDO2)" +
					"VALUES (");
			
			sb.append(secuencia +", '" + NOMBRE[nombre] + "', '" + APELLIDO1[apellido1] +"', '" + APELLIDO2[apellido2] +"');\n");
			
			secuencia++;
			
		}
	    
		sb.append("COMMIT;");
		
		
		
		return sb.toString();
		

	}
	
	public static String generarInsertUsuariosMejorada(int numeroUsuarios) {
	    
		Random aleatorio = new Random();
		int nombre = 0;
		int apellido1 = 0;
		int apellido2 = 0;
		int secuencia = 1;
		StringBuffer sb = new StringBuffer();
		
		for(int i= 0; i < numeroUsuarios; i++){
		

			nombre = aleatorio.nextInt(NOMBRE.length);
			apellido1 = aleatorio.nextInt(APELLIDO1.length);
			apellido2 = aleatorio.nextInt(APELLIDO2.length);
			
			sb.append("INSERT INTO USUARIOS (ID_USUARIO, NOMBRE, APELLIDO1, APELLIDO2, DNI)" +
					"VALUES (");
			
			sb.append(secuencia +", '" + NOMBRE[nombre] + "', '" + APELLIDO1[apellido1] +"', '" + APELLIDO2[apellido2] +"', '" + GeneradorDocumentos.generarNIF() +"');\n");
			
			secuencia++;
			
		}
	    
		sb.append("COMMIT;");
		
		
		
		return sb.toString();
		

	}
	

}


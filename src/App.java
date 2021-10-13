import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class App {

	private List<Mesada> mesadas = new ArrayList<Mesada>();
	private Integer pilas = 0;

	public static void main(String[] args) {

		App ejercicio = new App();

		ejercicio.leer("/home/nico/Facu/2021/2021 - 2C/Programacion_Avanzada"
				+ "/proyectos/OIA_MESADAS/OIA_MESADAS_2/src/in/01.in");

		ejercicio.resolver();

		ejercicio.escribir("/home/nico/Facu/2021/2021 - 2C/Programacion_Avanzada"
				+ "/proyectos/OIA_MESADAS/OIA_MESADAS_2/src/out/01.out");

	}

	public void leer(String nombre) {

		String[] vector_linea = new String[3];

		try {

			Scanner archivo = new Scanner(new File(nombre));

			int cantidadMesadas = Integer.parseInt(archivo.nextLine());

			for (int i = 0; i < cantidadMesadas; i++) {

				String linea = archivo.nextLine();
				vector_linea = linea.split(" ");

				mesadas.add(new Mesada(Integer.parseInt(vector_linea[0]), Integer.parseInt(vector_linea[1])));

			}

			archivo.close();

		} catch (FileNotFoundException ex) {
			System.out.println("El archivo " + nombre + " no existe en el directorio");
		}

	}

	public void escribir(String nombre) {

		FileWriter fichero = null;
		PrintWriter pw = null;

		try {

			fichero = new FileWriter(nombre);
			pw = new PrintWriter(fichero);

			pw.println(pilas);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}

	public void resolver() {

		// ROTACION
		for (Mesada mesada : mesadas) {
			if (mesada.getLargo() > mesada.getAncho()) {
				Integer aux = mesada.getAncho();
				mesada.setAncho(mesada.getLargo());
				mesada.setLargo(aux);
			}
		}

		// ORDENAMIENTO
		Collections.sort(mesadas, Mesada.Comparators.LARGOYANCHO);

		
		//CUENTO 
		Set<Mesada> set = new HashSet<Mesada>(mesadas);

		//ver como mejorar esto
		for (Mesada m : set) {
			pilas++;
		}	
		
		System.out.println("Cantidad de pilas: "+pilas);
		
	}

}

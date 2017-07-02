package matrixes;

public class Matriz {
	
	// método que suma dos matrices
	public static double[][] sumar(double[][] matriz1, double[][] matriz2){
		double[][] suma = null;
		int filas = matriz1.length;
		int columnas = matriz1[0].length;
		if(filas == matriz2.length && columnas == matriz2[0].length){// se comprueba que las dos matrices tengan las mismas dimensiones de lo contrario se devuelve null
			suma = new double[filas][columnas];// inicializa el arreglo que guarda el resultado
			for(int f = 0; f < filas; ++f)	//	filas
				for(int c = 0; c < columnas; ++c)	//	columnas
					suma[f][c] = matriz1[f][c] + matriz2[f][c];
		}
		return suma;
	}

}

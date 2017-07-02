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

	// método que resta dos matrices
	public static double[][] restar(double[][] matriz1, double[][] matriz2){
		double[][] diferencia = null;
		int filas = matriz1.length;
		int columnas = matriz1[0].length;
		if(filas == matriz2.length && columnas == matriz2[0].length){// se comprueba que las dos matrices tengan las mismas dimensiones de lo contrario se devuelve null
			diferencia = new double[filas][columnas];// inicializa el arreglo que guarda el resultado
			for(int f = 0; f < filas; ++f)	//	filas
				for(int c = 0; c < columnas; ++c)	//	columnas
					diferencia[f][c] = matriz1[f][c] - matriz2[f][c];
		}
		return diferencia;
	}
	
	// método que multiplica una matriz por un valor escalar
	public static double[][] multiplicar(double[][] matriz, double escalar){
		for(int f = 0; f < matriz.length; ++f)	//	filas
			for(int c = 0; c < matriz[0].length; ++c)	//	columnas
				matriz[f][c]*=escalar;
		return matriz;
	}
	
	// método para obtener la transpuesta de una matriz
	public static double[][] transpuesta(double[][] matriz){
		int filas = matriz.length;
		int columnas = matriz[0].length;
		double matrizTranspuesta[][] = new double[columnas][filas];
		for(int f = 0; f < filas; ++f)	//	filas
			for(int c = 0; c < columnas; ++c)	//	columnas
				matrizTranspuesta[c][f] = matriz[f][c];
		return matrizTranspuesta;
	}
		
}

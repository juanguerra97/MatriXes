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
	
	// método para multiplicar dos matrices
	public static double[][] multiplicar(double[][] matriz1, double[][] matriz2){
		double[][] producto = null;
		int filas1 = matriz1.length;// filas de la primer matriz
		int columnas1 = matriz1[0].length;// columnas de la primer matriz
		int filas2 = matriz2.length;// filas de la segunda matriz
		int columnas2 = matriz2[0].length;// columnas de la segunda matriz
		if(columnas1 == filas2){// comprueba que las dimensiones sean validas
			producto = new double[filas1][columnas2];
			double resultado = 0;
			for(int f1 = 0; f1 < filas1; ++f1)// filas de la primer matriz
				for(int c2 = 0; c2 < columnas2; ++c2){//	columnas de la segunda matriz
					resultado = 0;
					for(int c1 = 0; c1 < columnas1; ++c1)//	columnas de la primer matriz
						resultado+=(matriz1[f1][c1] * matriz2[c1][c2]);
					producto[f1][c2] = resultado;
				}
					
		}
		return producto;
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

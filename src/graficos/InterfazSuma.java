package graficos;

import matrixes.Matriz;

public class InterfazSuma extends BaseInterfazSumaResta {

	private static final long serialVersionUID = 1L;

	public InterfazSuma() {
		super("Sumar");		
	}

	@Override
	public void hacerOperacion() {
		
		double[][] matriz1 = gridMatriz1.getMatriz();
		double[][] matriz2 = gridMatriz2.getMatriz();
		double[][] suma = Matriz.sumar(matriz1, matriz2);
		gridMatrizResultado.setDimensiones(suma.length, suma[0].length);
		gridMatrizResultado.setMatriz(suma);
		
	}

}

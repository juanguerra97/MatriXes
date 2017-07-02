package graficos;

import matrixes.Matriz;

public class InterfazResta extends BaseInterfazSumaResta {

	private static final long serialVersionUID = 1L;

	public InterfazResta() {
		super("Restar");
		
	}

	@Override
	public void hacerOperacion() {

		double[][] matriz1 = gridMatriz1.getMatriz();
		double[][] matriz2 = gridMatriz2.getMatriz();
		double[][] diferencia = Matriz.restar(matriz1, matriz2);
		gridMatrizResultado.setDimensiones(diferencia.length, diferencia[0].length);
		gridMatrizResultado.setMatriz(diferencia);
		
	}

}

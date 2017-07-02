package graficos;

import matrixes.Matriz;

public class InterfazTranspuesta extends BaseInterfazOperacionUnaMatriz {

	private static final long serialVersionUID = 1L;

	public InterfazTranspuesta() {
		super("Transponer");
	}

	@Override
	public void hacerOperacion() {
		double[][] matriz = gridMatriz1.getMatriz();
		double[][] transpuesta = Matriz.transpuesta(matriz);
		gridMatrizResultado.setDimensiones(transpuesta.length, transpuesta[0].length);
		gridMatrizResultado.setMatriz(transpuesta);
	}

}

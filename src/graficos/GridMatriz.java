package graficos;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//	Clase que muestra un interfaz donde se puede ingresar/mostrar los valores de una matriz
public class GridMatriz extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Declaración de variables que son campos de clase
	private int filas;// filas de la matriz que se esta mostrando/ingresando
	private int columnas;// columnas de la matriz
	private JTextField fieldsMatriz[][];// arreglo de 4x4 con los campos de texto para ingresar/mostrar los valores de la matriz
	// --- TERMINA la declaración de variables
	
	// constructor
	public GridMatriz(int filas, int columnas){
		fieldsMatriz = new JTextField[4][4];// inicialización del arreglo(una matriz puede ser máximo de 4x4)
		for(int f = 0; f < 4; ++f)	//	filas
			for(int c = 0; c < 4; ++c){	//	columnas
				fieldsMatriz[f][c] = new JTextField(8);// inicialización del campo de texto
				fieldsMatriz[f][c].setHorizontalAlignment(SwingConstants.RIGHT);// alinea el texto de los campos a la derecha
			}
		setDimensiones(filas, columnas);// llamada a la funcion que establece las dimensiones
	}// termina el constructor
	
	// método para establecer las dimensiones de la matriz que se esta mostrando/ingresando
	public void setDimensiones(int filas, int columnas){
		if(filas > 0 && filas <= 4)
			this.filas = filas;
		else
			this.filas = 3;
		if(columnas > 0 && columnas <= 4)
			this.columnas = columnas;
		else
			this.columnas = 3;
		setFieldsEnable();// se establece qué campos son editables
	}
	
	// método que establece en cuáles campos de texto se puede introducir texto y en cuáles no de acuerdo con las dimensiones de la matriz
	private void setFieldsEnable(){
		for(int f = 0; f < 4; ++f)	//	filas
			for(int c = 0; c <4; ++c){	//	columnas
				if(f < filas && c < columnas)
					fieldsMatriz[f][c].setEditable(true);
				else
					fieldsMatriz[f][c].setEditable(false);
			}
	}
	
}

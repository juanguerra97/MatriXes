package graficos;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//	Clase que muestra un interfaz donde se puede ingresar/mostrar los valores de una matriz
public class GridMatriz extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Declaraci�n de variables que son campos de clase
	private int filas;// filas de la matriz que se esta mostrando/ingresando
	private int columnas;// columnas de la matriz
	private JTextField fieldsMatriz[][];// arreglo de 4x4 con los campos de texto para ingresar/mostrar los valores de la matriz
	// --- TERMINA la declaraci�n de variables
	
	// constructor
	public GridMatriz(int filas, int columnas){
		fieldsMatriz = new JTextField[4][4];// inicializaci�n del arreglo(una matriz puede ser m�ximo de 4x4)
		for(int f = 0; f < 4; ++f)	//	filas
			for(int c = 0; c < 4; ++c){	//	columnas
				fieldsMatriz[f][c] = new JTextField(8);// inicializaci�n del campo de texto
				fieldsMatriz[f][c].setHorizontalAlignment(SwingConstants.RIGHT);// alinea el texto de los campos a la derecha
				GridMatriz.setEventoTeclado(fieldsMatriz[f][c]);// establece el evento de teclado del campo de texto
			}
		setDimensiones(filas, columnas);// llamada a la funcion que establece las dimensiones
	}// termina el constructor
	
	// m�todo para establecer las dimensiones de la matriz que se esta mostrando/ingresando
	public void setDimensiones(int filas, int columnas){
		if(filas > 0 && filas <= 4)
			this.filas = filas;
		else
			this.filas = 3;
		if(columnas > 0 && columnas <= 4)
			this.columnas = columnas;
		else
			this.columnas = 3;
		setFieldsEnable();// se establece qu� campos son editables
	}
	
	// m�todo que establece en cu�les campos de texto se puede introducir texto y en cu�les no de acuerdo con las dimensiones de la matriz
	private void setFieldsEnable(){
		for(int f = 0; f < 4; ++f)	//	filas
			for(int c = 0; c <4; ++c){	//	columnas
				if(f < filas && c < columnas)
					fieldsMatriz[f][c].setEditable(true);
				else
					fieldsMatriz[f][c].setEditable(false);
			}
	}
	
	// m�todo para agregar un evento de teclado a un campo de tecto
	private static void setEventoTeclado(JTextField f){
		f.addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent key) {
				char k = key.getKeyChar();
				if(k == '.'){
					String textField = f.getText();
					for(int i = 0; i < textField.length(); ++i)
						if(textField.charAt(i) == k){
							key.consume();
							break;
						}
				}else if(!Character.isDigit(k))
					key.consume();
			}
		});
	}
	
}

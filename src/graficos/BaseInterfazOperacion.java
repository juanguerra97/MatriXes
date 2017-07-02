package graficos;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

// clase abstracta que es la base en la herencia para los paneles con la interfaz gráfica para cada 
public abstract class BaseInterfazOperacion extends JPanel {

	private static final long serialVersionUID = 1L;

	//	Variables
	protected JPanel pnlArriba;// panel que se coloca en la parte superior
	protected JPanel pnlAbajo;// panel que se coloca en la parte inferior
	protected GridMatriz gridMatriz1;// grid para ingresar los valores de una matriz
	protected JComboBox<String> comboFilas1;// combobox para seleccionar las filas de la matriz
	protected JComboBox<String> comboColumnas1;// para seleccionar las columnas
	protected final String FILAS[] = {"1 Fila","2 Filas","3 Filas","4 Filas"};// texto del combobox para seleccionar filas
	protected final String COLUMNAS[] = {"1 Columna","2 Columnas","3 Columnas","4 Columnas"};// texto del combobox para seleccionar columnas
	protected GridMatriz gridMatrizResultado;// grid para mostrar los valores de la matriz que se obtenga como resultado en la operación
	protected JButton btnOperar;// boton para realizar la operación correspondiente
	// termina declaración de variables
	
	// constructor
	public BaseInterfazOperacion(String operacion){
		setLayout(new GridLayout(2,1));
		comboFilas1 = new JComboBox<String>(FILAS);
		comboColumnas1 = new JComboBox<String>(COLUMNAS);
		Action evento = new Operar(operacion);
		btnOperar = new JButton(evento);
	}
	
	// métodos abstractos
	protected abstract void construirPanelArriba();
	protected abstract void construirPanelAbajo();
	public abstract void hacerOperacion();
	
	// método para restablecer el ingreso de valores en una matriz(borra el contenido del grid con el resultado y el de(o los) grid para ingresar valores)
	public void restablecer(){
		gridMatriz1.borrarTextoFields();
		gridMatrizResultado.borrarTextoFields();
		gridMatrizResultado.setDimensiones(0, 0);// evita que se pueda introducir texto en los campos
	}
	
	// evento para llevar a cabo la operación
	private class Operar extends AbstractAction{
		
		private static final long serialVersionUID = 1L;
		
		// constructor
		public Operar(String operacion){
			putValue(Action.NAME, operacion);
		}
		@Override
		public void actionPerformed(ActionEvent a) {
			hacerOperacion();			
		}		
	}
	

}

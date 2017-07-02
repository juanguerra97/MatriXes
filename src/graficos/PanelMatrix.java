package graficos;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

// panel principal de la aplicación
public class PanelMatrix extends JPanel {

	private static final long serialVersionUID = 1L;
	
	// Declaración de variables campos de clase
	private final String OPERACIONES[] = {"Suma","Resta","Multiplicación","Multiplicación por escalar","Transpuesta"};
	private JButton btnSeleccionOperacion[];// arreglo con los botones para seleccionar una operación
	private CardLayout layoutMatrix;// layout del panel
	private JPanel pnlVistaOperaciones;// panel con cardlayout que muestra la interfaz apropiada de acuerdo a la operación que quiera realizar el usuario
	// termina declaración de variables
	
	// constructor
	public PanelMatrix(){
		
		setLayout(new BorderLayout());
		
		JToolBar toolBar = new JToolBar(JToolBar.HORIZONTAL);// toolbar que contiene los botones
		toolBar.setFloatable(false);// el toolbar no se puede cambiar de posición
		
		btnSeleccionOperacion = new JButton[OPERACIONES.length];// arreglo que contiene un boton por cada operación que permite realizar la aplicación
		for (int i = 0; i < OPERACIONES.length; ++i){
			Action evento = new CambiarPanel(i);// evento del boton
			btnSeleccionOperacion[i] = new JButton(evento);// inicializa el boton
			btnSeleccionOperacion[i].setVerticalTextPosition(SwingConstants.BOTTOM);// situa el texto del boton en la parte inferior
			toolBar.add(btnSeleccionOperacion[i]);// agrega el boton inicializado al toolbar
		}
		
		add(toolBar, BorderLayout.NORTH);// el toolbar se coloca en la parte superior del panel principal
		
		layoutMatrix = new CardLayout();
		pnlVistaOperaciones = new JPanel(layoutMatrix);// panel con el cardlayout para cambiar entre distintas interfaces graficas
		
		add(pnlVistaOperaciones, BorderLayout.CENTER);// el panel con el cardlayout se coloca en el centro
		
	}
	
	// evento de los botones
	private class CambiarPanel extends AbstractAction{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int operacion;
		
		// constructor
		public CambiarPanel(int operacion){// las operaciones se numeran desde 0 hasta OPERACIONES.length - 1
			this.operacion = operacion;
			putValue(Action.NAME, OPERACIONES[operacion]);
		}

		@Override
		public void actionPerformed(ActionEvent ev) {
			layoutMatrix.show(pnlVistaOperaciones, OPERACIONES[operacion]);// cambia el panel que se esta mostrando
		}
		
	}// termina clase interna CambiarPanel

}

package graficos;

import java.awt.Dimension;

import javax.swing.JFrame;

// ventana principal de la aplicacion
public class VentanaMatrix extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// constructor
	public VentanaMatrix(){
		super("MatriXes");
		setSize(750, 600);
		setMinimumSize(new Dimension(750, 600));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		add(new PanelMatrix());
		pack();		
		
	}

}

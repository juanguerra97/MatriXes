package graficos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

// clase base para las interfaces que solo utilizan una matriz para operar(transpuesta, matriz por escalar, etc)
public abstract class BaseInterfazOperacionUnaMatriz extends BaseInterfazOperacion {

	private static final long serialVersionUID = 1L;

	public BaseInterfazOperacionUnaMatriz(String operacion) {
		super(operacion);
		comboFilas1.setSelectedIndex(2);
		comboColumnas1.setSelectedIndex(2);
		ItemListener evento = new CambioDimension();
		comboFilas1.addItemListener(evento);
		comboColumnas1.addItemListener(evento);
		construirPanelArriba();
		add(pnlArriba);
		add(pnlAbajo);
	}

	@Override
	protected void construirPanelArriba() {
		
		pnlArriba = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5,10,5,10);
		
		pnlArriba.add(gridMatriz1, c);
		
		c.gridx++;
		
		JPanel pnlCentro = new JPanel(new GridLayout(3,1,0,5));
		pnlCentro.add(comboFilas1);
		pnlCentro.add(comboColumnas1);
		pnlCentro.add(btnOperar);
		
		pnlArriba.add(pnlCentro, c);

	}

	@Override
	public abstract void hacerOperacion();
	
	// evento de los combobox
	private class CambioDimension implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent i) {
			int filas = comboFilas1.getSelectedIndex() + 1;
			int columnas = comboColumnas1.getSelectedIndex() + 1;
			gridMatriz1.setDimensiones(filas, columnas);
			restablecer();
		}
	}// termina clase interna CambioDimension

}

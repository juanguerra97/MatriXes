package graficos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

// clase que sirve de base para las interfaces de las operaciones de suma y resta
public abstract class BaseInterfazSumaResta extends BaseInterfazOperacion{

	private static final long serialVersionUID = 1L;
	protected GridMatriz gridMatriz2;// para ingresar los datos de la segunda matriz

	public BaseInterfazSumaResta(String operacion) {
		super(operacion);
		gridMatriz2 = new GridMatriz(3,3);
		ItemListener eventoItem = new CambioDimension();
		comboFilas1.addItemListener(eventoItem);
		comboColumnas1.addItemListener(eventoItem);
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
		c.gridheight = 3;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridwidth = 4;	
		c.weightx = 1.0;
		c.ipady = 35;
		pnlArriba.add(gridMatriz1, c);		
		
		JPanel pnlCentro = new JPanel(new GridLayout(3, 1,0,5));
		pnlCentro.add(comboFilas1);
		pnlCentro.add(comboColumnas1);
		pnlCentro.add(btnOperar);
		
		c.gridx+=4;
		c.gridy++;
		c.gridwidth = 1;
		c.weightx = 0.0;
		c.ipady = 0;
		c.gridheight = 1;
		pnlArriba.add(pnlCentro, c);
		
		c.gridx++;
		c.gridy = 0;
		c.weightx = 1.0;
		c.gridwidth = 4;
		c.ipady = 35;
		c.gridheight = 3;
		pnlArriba.add(gridMatriz2, c);
		
	}
	
	@Override
	public void restablecer(){
		super.restablecer();
		gridMatriz2.borrarTextoFields();
	}

	@Override
	public abstract void hacerOperacion();
	
	// evento de los combo box
	private class CambioDimension implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent i) {
			int filas = comboFilas1.getSelectedIndex() + 1;
			int columnas = comboColumnas1.getSelectedIndex() + 1;
			// en la suma y la resta las dos matrices deben tener las mismas dimensiones
			gridMatriz1.setDimensiones(filas, columnas);
			gridMatriz2.setDimensiones(filas, columnas);
			restablecer();
		}		
	}// termina clase interna CambioDimension

}

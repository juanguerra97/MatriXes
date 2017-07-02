package graficos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class InterfazMultiplicacion extends BaseInterfazOperacion {

	private static final long serialVersionUID = 1L;
	private GridMatriz gridMatriz2;// grid de la segunda matriz
	private JComboBox<String> comboFilas2;// para establecer las filas de la matriz 2
	private JComboBox<String> comboColumnas2;// establece las columnas de la matriz w
	private ItemListener eventoCombo;// evento de los comobbox
	

	public InterfazMultiplicacion() {
		super("Multiplicar");
		gridMatriz2 = new GridMatriz(3,3);
		comboFilas2 = new JComboBox<String>(FILAS);
		comboColumnas2 = new JComboBox<String>(COLUMNAS);
		eventoCombo = new CambioDimension();
		comboFilas1.addItemListener(eventoCombo);
		comboColumnas1.addItemListener(eventoCombo);
		comboFilas2.addItemListener(eventoCombo);
		comboColumnas2.addItemListener(eventoCombo);
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
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		
		c.gridwidth = 4;	
		c.weightx = 1.0;
		pnlArriba.add(gridMatriz1, c);		
		
		JPanel pnlCentro = new JPanel(new GridLayout(5, 1,0,5));
		pnlCentro.add(comboFilas1);
		pnlCentro.add(comboColumnas1);
		pnlCentro.add(btnOperar);
		pnlCentro.add(comboFilas2);
		pnlCentro.add(comboColumnas2);
		
		c.gridx+=4;
		c.gridwidth = 1;
		c.weightx = 0.0;
		pnlArriba.add(pnlCentro, c);
		
		c.gridx++;
		c.weightx = 1.0;
		c.gridwidth = 4;
		pnlArriba.add(gridMatriz2, c);
		
	}

	@Override
	public void hacerOperacion() {
		double[][] matriz1 = gridMatriz1.getMatriz();
		double[][] matriz2 = gridMatriz2.getMatriz();
		double[][] resultado;
	}
	
	@Override
	public void restablecer(){
		super.restablecer();
		gridMatriz2.borrarTextoFields();
	}
	
	// evento de los combobox
	private class CambioDimension implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent i) {
			int filas1 = comboFilas1.getSelectedIndex();
			int columnas1 = comboColumnas1.getSelectedIndex();
			int filas2 = comboFilas2.getSelectedIndex();
			int columnas2 = comboColumnas2.getSelectedIndex();
			if(i.getSource().equals(comboColumnas1)){
				comboFilas2.removeItemListener(eventoCombo);
				comboFilas2.setSelectedIndex(columnas1);
				filas2 = columnas1;
				comboFilas2.addItemListener(eventoCombo);
			}else if(i.getSource().equals(comboFilas2)){
				comboColumnas1.removeItemListener(eventoCombo);
				comboColumnas1.setSelectedIndex(filas2);
				columnas1 = filas2;
				comboColumnas1.addItemListener(eventoCombo);
			}
			gridMatriz1.setDimensiones(filas1 + 1, columnas1 + 1);
			gridMatriz2.setDimensiones(filas2 + 1, columnas2 + 1);
		}		
	}// termina clase interna CambioDimension

}

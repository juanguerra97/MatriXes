package graficos;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JPanel;

import matrixes.Matriz;

public class InterfazMultiplicacionEscalar extends BaseInterfazOperacion {

	private static final long serialVersionUID = 1L;
	private GridMatriz fieldEscalar;// matriz donde se ingresa el escalar

	public InterfazMultiplicacionEscalar() {
		super("Multiplicar");
		fieldEscalar = new GridMatriz(1,1);
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
		c.gridheight = 3;
		c.fill = GridBagConstraints.BOTH;
		c.ipady = 35;
		
		c.gridwidth = 4;	
		c.weightx = 1.0;
		pnlArriba.add(gridMatriz1, c);		
		
		JPanel pnlCentro = new JPanel(new GridLayout(3, 1,0,5));
		pnlCentro.add(comboFilas1);
		pnlCentro.add(comboColumnas1);
		pnlCentro.add(btnOperar);
		
		c.gridx+=4;
		c.gridy++;
		c.gridwidth = 1;
		c.weightx = 0.0;
		c.ipady = 18;
		c.gridheight = 1;
		pnlArriba.add(pnlCentro, c);
		
		c.gridx++;
		c.gridy = 0;
		c.weightx = 1.0;
		c.gridheight = 3;
		c.gridwidth = 4;
		c.ipady = 35;
		pnlArriba.add(fieldEscalar, c);
	}

	@Override
	public void hacerOperacion() {
		double[][] matriz = gridMatriz1.getMatriz();
		double[][] escalar = fieldEscalar.getMatriz();
		double producto[][] = Matriz.multiplicar(matriz, escalar[0][0]);
		gridMatrizResultado.setDimensiones(producto.length, producto[0].length);
		gridMatrizResultado.setMatriz(producto);
	}
	
	@Override
	public void restablecer(){
		super.restablecer();
		fieldEscalar.borrarTextoFields();
	}
	
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

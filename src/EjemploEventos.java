import javax.swing.*;
import javax.xml.bind.ParseConversionEvent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VentanaComboBox extends JFrame implements ActionListener {

	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	JButton btnConvertir;
	JComboBox<String> comboTemperaturas, comboTemperaturas2;
	JTextField cajaRes, cajaGrados;

	public VentanaComboBox() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Actividad");
		setSize(550, 550);
		setLocationRelativeTo(null);
		setVisible(true);

		JLabel lblTemperatura = new JLabel("Cantidad: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(lblTemperatura, gbc);
		add(lblTemperatura);

		String items[] = { "Centigrados", "Farenheit", "Kelvin", "Rankine" };
		comboTemperaturas = new JComboBox<String>(items);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(comboTemperaturas, gbc);
		add(comboTemperaturas);

		cajaGrados = new JTextField(10);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(cajaGrados, gbc);
		add(cajaGrados);

		comboTemperaturas2 = new JComboBox<String>(items);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(comboTemperaturas2, gbc);
		add(comboTemperaturas2);
		comboTemperaturas2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
				
				if (comboTemperaturas.getSelectedIndex() == 0) {
					
					if (comboTemperaturas2.getSelectedIndex() == 0) {
						cajaRes.setText(cajaGrados.getText());
						
					} else if (comboTemperaturas2.getSelectedIndex() == 1) {
						cajaRes.setText(String.valueOf((Double.parseDouble(cajaGrados.getText()) * 9/5) + 32));
					} else if (comboTemperaturas2.getSelectedIndex() == 2) {
						cajaRes.setText(String.valueOf(Double.parseDouble(cajaGrados.getText())+273.15));
					} else if (comboTemperaturas2.getSelectedIndex() == 3) {
						cajaRes.setText(String.valueOf(Double.parseDouble(cajaGrados.getText())* 9/5 + 491.67));
					}
				} else if (comboTemperaturas.getSelectedIndex() == 1) {
					
					if (comboTemperaturas2.getSelectedIndex() == 0) {
						cajaRes.setText(String.valueOf((Double.parseDouble(cajaGrados.getText()) - 32) * 5/9));
					} else if (comboTemperaturas2.getSelectedIndex() == 1) {
						cajaRes.setText(cajaGrados.getText());
					} else if (comboTemperaturas2.getSelectedIndex() == 2) {
						cajaRes.setText(String.valueOf((Double.parseDouble(cajaGrados.getText()) - 32) * 5/9 + 273.15));
					} else if (comboTemperaturas2.getSelectedIndex() == 3) {
						cajaRes.setText(String.valueOf(Double.parseDouble(cajaGrados.getText()) + 459.67));
					}
				} else if (comboTemperaturas.getSelectedIndex() == 2) {
					
					if (comboTemperaturas2.getSelectedIndex() == 0) {
						cajaRes.setText(String.valueOf(Double.parseDouble(cajaGrados.getText()) - 273.15));
					} else if (comboTemperaturas2.getSelectedIndex() == 1) {
						cajaRes.setText(String.valueOf(((Double.parseDouble(cajaGrados.getText())-273.15 ) * 9/5) + 32));
					} else if (comboTemperaturas2.getSelectedIndex() == 2) {
						cajaRes.setText(cajaGrados.getText());
					} else if (comboTemperaturas2.getSelectedIndex() == 3) {
						cajaRes.setText(String.valueOf(Double.parseDouble(cajaGrados.getText())*1.8));
					}
				} else if (comboTemperaturas.getSelectedIndex() == 3) {
					
					if (comboTemperaturas2.getSelectedIndex() == 0) {
						cajaRes.setText(String.valueOf(( Double.parseDouble(cajaGrados.getText()) -  491.67) * 5/9));
					} else if (comboTemperaturas2.getSelectedIndex() == 1) {
						cajaRes.setText(String.valueOf(Double.parseDouble(cajaGrados.getText()) - 459.67));
					} else if (comboTemperaturas2.getSelectedIndex() == 2) {
						cajaRes.setText(String.valueOf(Double.parseDouble(cajaGrados.getText())* 5/9));
					} else if (comboTemperaturas2.getSelectedIndex() == 3) {
						cajaRes.setText(cajaGrados.getText());
					}
				}
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(getParent(), "Solo Numeros");
				}
			}
		});

		JLabel lblRes = new JLabel("Resultado: ");
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(lblRes, gbc);
		add(lblRes);

		cajaRes = new JTextField(10);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(cajaRes, gbc);
		add(cajaRes);
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
class Convertidor{
	
	public void convertir() {
		
	}
	
}

public class EjemploEventos {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new VentanaComboBox();
			}
		});

	}

}

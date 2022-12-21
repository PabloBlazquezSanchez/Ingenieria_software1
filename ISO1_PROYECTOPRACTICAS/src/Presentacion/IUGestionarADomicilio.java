package Presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Dominio.Controladores.GestorAgenda;
import Dominio.Controladores.GestorCitas;
import Dominio.Entidades.Empleado;
import Dominio.Entidades.TipoAgenda;

public class IUGestionarADomicilio extends JFrame {

	private JPanel contentPane;


	public IUGestionarADomicilio(Empleado e) throws SQLException {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {

			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton buttonAceptar = new JButton("Aceptar");

		buttonAceptar.setBounds(358, 69, 148, 29);
		contentPane.add(buttonAceptar);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.RED);
		lblEstado.setBounds(6, 208, 61, 16);
		contentPane.add(lblEstado);

		JTextPane textPaneEstado = new JTextPane();
		textPaneEstado.setToolTipText(
				"Panel para mostrar el restultado de la comprobaci�n de login o las excepciones lanzadas");
		textPaneEstado.setEditable(false);
		textPaneEstado.setBounds(16, 235, 529, 102);
		contentPane.add(textPaneEstado);
		JButton buttonLimpiar = new JButton("Limpiar");
		buttonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPaneEstado.setText("");
			}
		});
		buttonLimpiar.setBounds(358, 117, 148, 29);
		contentPane.add(buttonLimpiar);

		JLabel lblNewLabel = new JLabel("Configurar agenda (Domicilio)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(125, 10, 324, 21);
		contentPane.add(lblNewLabel);

		JLabel lblSiAunNo = new JLabel("Introduzca la fecha y seleccione la hora a la que desea pasar consulta:");
		lblSiAunNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSiAunNo.setBounds(31, 31, 432, 27);
		contentPane.add(lblSiAunNo);

		JLabel texto_h = new JLabel("Horas diponibles");
		texto_h.setBounds(31, 123, 128, 16);
		contentPane.add(texto_h);

		JComboBox horas = new JComboBox();
		horas.setEnabled(false);
		horas.setModel(new DefaultComboBoxModel());
		horas.setBounds(185, 117, 134, 25);
		contentPane.add(horas);

		JComboBox fecha = new JComboBox();
		fecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println(fecha.getSelectedItem().toString());
					horas.setModel(new DefaultComboBoxModel(GestorCitas.huecossinasignar(fecha.getSelectedItem().toString())));
					horas.setEnabled(true);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});

		fecha.setModel(new DefaultComboBoxModel(GestorAgenda.obtenerDatosCalendarioLaborable()));

		fecha.setBounds(185, 71, 134, 25);
		contentPane.add(fecha);

		JLabel texto_f = new JLabel("Fecha");
		texto_f.setBounds(31, 75, 128, 16);
		contentPane.add(texto_f);

		JLabel lblAnotaciones = new JLabel("Anotaciones");
		lblAnotaciones.setBounds(31, 160, 128, 16);
		contentPane.add(lblAnotaciones);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(187, 161, 132, 21);
		contentPane.add(textPane);

	}
}

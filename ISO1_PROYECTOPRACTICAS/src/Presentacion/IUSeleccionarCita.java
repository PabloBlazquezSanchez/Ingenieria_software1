package Presentacion;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import Dominio.Controladores.GestorAgenda;
import Dominio.Controladores.GestorCitas;
import Dominio.Entidades.Paciente;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class IUSeleccionarCita extends JFrame {
	private JPanel contentPane;
	private JTextPane textPaneEstado;

	public IUSeleccionarCita(Paciente p) throws SQLException {
		String dia = null;
		String especialidad = null;
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

		textPaneEstado = new JTextPane();
		textPaneEstado.setToolTipText(
				"Panel para mostrar el restultado de la comprobaci�n de login o las excepciones lanzadas");
		textPaneEstado.setEditable(false);
		textPaneEstado.setBounds(16, 235, 529, 102);
		contentPane.add(textPaneEstado);
		JButton buttonLimpiar = new JButton("Limpiar");
		buttonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPaneEstado.setText("");
				/*
				 * Limpiaremos el panel de salida para visualizar nuevas operaciones
				 */
			}
		});
		buttonLimpiar.setBounds(358, 117, 148, 29);
		contentPane.add(buttonLimpiar);

		JLabel lblNewLabel = new JLabel("Seleccionar cita");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(224, 10, 239, 21);
		contentPane.add(lblNewLabel);

		JLabel lblSiAunNo = new JLabel("Introduzca la fecha y seleccione la hora y especialidad:");
		lblSiAunNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSiAunNo.setBounds(31, 31, 381, 27);
		contentPane.add(lblSiAunNo);

		JLabel lblNewLabel_1_1_1 = new JLabel("Fecha");
		lblNewLabel_1_1_1.setBounds(27, 75, 148, 13);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel id = new JLabel("Horas diponibles");
		id.setBounds(31, 177, 128, 16);
		contentPane.add(id);

		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);

		JComboBox comboBox_1 = new JComboBox();
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(true);
				String especialidad = null;
				if (comboBox_1.getSelectedItem().toString().equals("Médico de cabecera")) {
					especialidad = "MEDICO_CABECERA";
				} else if (comboBox_1.getSelectedItem().toString().equals("Fisioterapeuta")) {
					especialidad = "fisioterapeuta";
				} else {
					especialidad = "podologo";
				}
				try {
					comboBox.setModel(new DefaultComboBoxModel(
							GestorCitas.solicitarHoras(comboBox_1_1.getSelectedItem().toString(), especialidad, p)));
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println(e1);
				}

			}
		});

		comboBox_1.setModel(
				new DefaultComboBoxModel(new String[] { "Médico de cabecera", "Fisioterapeuta", "Podólogo" }));
		comboBox_1.setBounds(185, 123, 134, 25);
		contentPane.add(comboBox_1);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(31, 123, 128, 16);
		contentPane.add(lblEspecialidad);

		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setEnabled(true);

			}
		});
		comboBox_1_1.setModel(new DefaultComboBoxModel(GestorAgenda.obtenerDatosCalendarioLaborable()));
		comboBox_1_1.setBounds(185, 73, 134, 25);
		contentPane.add(comboBox_1_1);

		comboBox.setBounds(185, 173, 134, 25);
		contentPane.add(comboBox);

	}
}

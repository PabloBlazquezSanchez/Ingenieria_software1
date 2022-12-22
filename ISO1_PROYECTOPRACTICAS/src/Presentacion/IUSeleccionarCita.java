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
import Dominio.Controladores.GestorUsuarios;
import Dominio.Entidades.Paciente;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class IUSeleccionarCita extends JFrame {
	private JPanel contentPane;
	private JTextPane textPaneEstado;
	static boolean pulsar = false;
	static String finalespecialidad;

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

		JComboBox horasdisponibles = new JComboBox();
		horasdisponibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pulsar = true;
			}
		});
		horasdisponibles.setEnabled(false);

		JComboBox especialidad3 = new JComboBox();
		JComboBox fecha = new JComboBox();
		especialidad3.setEnabled(false);
		especialidad3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				horasdisponibles.setEnabled(true);
				String especialidad = null;
				if (especialidad3.getSelectedItem().toString().equals("Médico de cabecera")) {
					especialidad = "MEDICO_CABECERA";
				} else if (especialidad3.getSelectedItem().toString().equals("Fisioterapeuta")) {
					especialidad = "fisioterapeuta";
				} else {
					especialidad = "podologo";
				}
				try {
					finalespecialidad = especialidad;
					horasdisponibles.setModel(new DefaultComboBoxModel(
							GestorCitas.solicitarHoras(fecha.getSelectedItem().toString(), especialidad, p)));
					if (GestorCitas.solicitarHoras(fecha.getSelectedItem().toString(), especialidad, p).length == 0) {
						textPaneEstado.setText("No se ha podido encontrar ningún hueco para la especialidad y fecha seleccionada.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					System.out.println(e1);
				}

			}
		});

		especialidad3.setModel(
				new DefaultComboBoxModel(new String[] { "Médico de cabecera", "Fisioterapeuta", "Podólogo" }));
		especialidad3.setBounds(185, 123, 134, 25);
		contentPane.add(especialidad3);

		JLabel lblEspecialidad = new JLabel("Especialidad");
		lblEspecialidad.setBounds(31, 123, 128, 16);
		contentPane.add(lblEspecialidad);

		fecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				especialidad3.setEnabled(true);
				horasdisponibles.setEnabled(false);
				horasdisponibles.setModel(new DefaultComboBoxModel());

			}
		});
		fecha.setModel(new DefaultComboBoxModel(GestorAgenda.obtenerDatosCalendarioLaborable()));
		fecha.setBounds(185, 73, 134, 25);
		contentPane.add(fecha);

		horasdisponibles.setBounds(185, 173, 134, 25);
		contentPane.add(horasdisponibles);

		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					int resultado = GestorCitas.generarCita(fecha.getSelectedItem().toString(), finalespecialidad, p,
							horasdisponibles.getSelectedItem().toString());
					System.out.println(resultado);
					if (resultado == 2) {
						textPaneEstado.setText("Se ha creado la cita correctamente.");
					} else {
						textPaneEstado.setText("No se ha creado la cita correctamente.");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
					textPaneEstado.setText("Error");

				}

			}
		});

	}
}
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
import Dominio.Entidades.TipoAgenda;

public class IUGestionarADomicilio extends JFrame  {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IUGestionarADomicilio frame = new IUGestionarADomicilio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public IUGestionarADomicilio() throws SQLException {
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
		
		JLabel lblNewLabel = new JLabel("Configurar Agenda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(224, 10, 239, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblSiAunNo = new JLabel("Introduzca la fecha y seleccione la hora a la que desea pasar consulta:");
		lblSiAunNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSiAunNo.setBounds(31, 31, 432, 27);
		contentPane.add(lblSiAunNo);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tipo de agenda");
		lblNewLabel_1_1_1.setBounds(27, 75, 148, 13);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel id = new JLabel("Horas diponibles");
		id.setBounds(31, 165, 128, 16);
		contentPane.add(id);

		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"9:00-9:10", "9:10-9:20", "9:20-9:30", "9:30-9:40", "9:40-9:50"}));
		comboBox.setBounds(185, 161, 134, 25);
		contentPane.add(comboBox);
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setEnabled(true);
				try {
					System.out.println(comboBox_1.getSelectedItem().toString());

					GestorAgenda.obtenerDatosHorariosDia(comboBox_1.getSelectedItem().toString());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(GestorAgenda.obtenerDatosCalendarioLaborable()));

		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(185, 119, 134, 25);
		contentPane.add(comboBox_1);
		
		JLabel lblEspecialidad = new JLabel("Fecha");
		lblEspecialidad.setBounds(31, 123, 128, 16);
		contentPane.add(lblEspecialidad);
		
		JComboBox tipo = new JComboBox();
		tipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1.setEnabled(true);

			}
		});
		tipo.setModel(new DefaultComboBoxModel(TipoAgenda.values()));
		tipo.setBounds(185, 71, 134, 25);
		contentPane.add(tipo);
		

	}
}

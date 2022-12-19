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


import javax.swing.JScrollPane;
	import javax.swing.JComboBox;
	import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JList;

	public class IUGestionarAClinica extends JFrame {
		private JPanel contentPane;
		private JTextField textFieldFecha;
		private JTextPane textPaneEstado;
		private JTextField textField;
		private JTextField textField_1;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						IUGestionarAClinica frame = new IUGestionarAClinica();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the frame.
		 */
		public IUGestionarAClinica() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 576, 384);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			textFieldFecha = new JTextField();
			textFieldFecha.setBounds(185, 70, 134, 28);
			contentPane.add(textFieldFecha);
			textFieldFecha.setColumns(10);

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
			textPaneEstado.setBounds(6, 235, 529, 102);
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
			
			JLabel lblNewLabel = new JLabel("Añadir horas de consulta en la clínica");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel.setBounds(112, 10, 394, 21);
			contentPane.add(lblNewLabel);
			
			JLabel texto = new JLabel("Introduzca las fechas y horas que desea pasar consulta en la clínica");
			texto.setFont(new Font("Tahoma", Font.BOLD, 11));
			texto.setBounds(79, 33, 381, 27);
			contentPane.add(texto);
			
			JLabel fecha = new JLabel("Fecha (dd/mm/aaaa)");
			fecha.setBounds(27, 75, 148, 13);
			contentPane.add(fecha);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(185, 118, 134, 28);
			contentPane.add(textField);
			
			JLabel inicio = new JLabel("Hora de inicio (hh:mm)");
			inicio.setBounds(27, 125, 148, 13);
			contentPane.add(inicio);
			
			JLabel finalizacion = new JLabel("Hora de finalización (hh:mm)");
			finalizacion.setBounds(27, 178, 148, 13);
			contentPane.add(finalizacion);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(185, 171, 134, 28);
			contentPane.add(textField_1);

		}
	}
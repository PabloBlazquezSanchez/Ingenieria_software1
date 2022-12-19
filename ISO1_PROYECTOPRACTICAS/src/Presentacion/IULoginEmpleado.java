	package Presentacion;

	import java.awt.EventQueue;

import Dominio.Controladores.GestorUsuarios;
import Persistencia.BDConstantes;
import Persistencia.GestorBaseDatos;

import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

	import org.apache.derby.jdbc.EmbeddedDriver;

import javax.swing.JLabel;


	import javax.swing.JTextField;
	import javax.swing.JButton;

	import java.awt.Color;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.Driver;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.awt.event.ActionEvent;
	import javax.swing.JTextPane;
import java.awt.Font;

	public class IULoginEmpleado extends JFrame {

		private JPanel contentPane;
		private JTextField textFieldLogin;
		private JTextField textFieldPassword;
		private JTextPane textPaneEstado;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						IULoginEmpleado frame = new IULoginEmpleado();
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
		public IULoginEmpleado() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 438, 385);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			textFieldLogin = new JTextField();
			textFieldLogin.setBounds(144, 70, 134, 28);
			contentPane.add(textFieldLogin);
			textFieldLogin.setColumns(10);

			textFieldPassword = new JTextField();
			textFieldPassword.setColumns(10);
			textFieldPassword.setBounds(144, 118, 134, 28);
			contentPane.add(textFieldPassword);

			JButton buttonAceptar = new JButton("Aceptar");
			buttonAceptar.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					boolean existe = false;
					try {
						if (GestorUsuarios.loginEmpleado(textFieldLogin.getText(), textFieldPassword.getText())==true)
							existe = true;
						if (existe) {
							IUGestionarAgenda p = new IUGestionarAgenda();
							p.setVisible(true);
						} else {
							textPaneEstado.setText("El login ha sido incorrecto");
						}
					} catch (Exception e) {
						textPaneEstado.setText("El usuario introducido no existe.");
					}

				}
			});
			buttonAceptar.setBounds(310, 69, 102, 29);
			contentPane.add(buttonAceptar);

			JLabel lblEstado = new JLabel("Estado");
			lblEstado.setForeground(Color.RED);
			lblEstado.setBounds(10, 170, 61, 16);
			contentPane.add(lblEstado);

			textPaneEstado = new JTextPane();
			textPaneEstado.setToolTipText(
					"Panel para mostrar el restultado de la comprobaci�n de login o las excepciones lanzadas");
			textPaneEstado.setEditable(false);
			textPaneEstado.setBounds(10, 196, 402, 116);
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
			buttonLimpiar.setBounds(310, 117, 102, 29);
			contentPane.add(buttonLimpiar);
			
			JLabel lblNewLabel = new JLabel("Iniciar sesión (Empleado)");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel.setBounds(109, 10, 239, 21);
			contentPane.add(lblNewLabel);
			
			JLabel lblSiAunNo = new JLabel("Introduzca sus datos en los siguientes recuadros:");
			lblSiAunNo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblSiAunNo.setBounds(31, 31, 381, 27);
			contentPane.add(lblSiAunNo);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Nombre de usuario");
			lblNewLabel_1_1_1.setBounds(26, 77, 108, 13);
			contentPane.add(lblNewLabel_1_1_1);
			
			JLabel id = new JLabel("Contraseña");
			id.setBounds(28, 125, 93, 13);
			contentPane.add(id);

			/*
			 * JScrollPane scrollPaneSalida = new JScrollPane(); scrollPaneSalida.
			 * setToolTipText("Este panel mostrar\u00E1 el resultado de la consulta, las excepciones o cualquier otro resultado"
			 * ); scrollPaneSalida.setBounds(6, 193, 407, 108); scrollPaneSalida.
			 * contentPane.add(scrollPaneSalida);
			 */
		}
	}

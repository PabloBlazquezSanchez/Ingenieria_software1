
package Presentacion;

import java.awt.EventQueue;

import Dominio.Controladores.GestorUsuarios;
import Persistencia.BDConstantes;
import Persistencia.GestorBaseDatos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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

public class IULoginPaciente extends JFrame {

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
					IULoginPaciente frame = new IULoginPaciente();
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
	public IULoginPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldLogin = new JTextField();
		textFieldLogin.setBounds(86, 68, 134, 28);
		contentPane.add(textFieldLogin);
		textFieldLogin.setColumns(10);

		textFieldPassword = new JPasswordField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(86, 116, 134, 28);
		contentPane.add(textFieldPassword);

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				boolean existe = false;
				try {
					if (GestorUsuarios.loginPaciente(textFieldLogin.getText(), textFieldPassword.getText()) == true)
						existe = true;
					if (existe) {
						IUSeleccionarCita p = new IUSeleccionarCita(GestorUsuarios
								.ObtenerDatosPaciente(textFieldLogin.getText(), textFieldPassword.getText()));
						p.setVisible(true);
					} else {
						textPaneEstado.setText("El login ha sido incorrecto");
					}
				} catch (Exception e) {
					textPaneEstado.setText("El usuario introducido no existe.");
				}

			}
		});
		buttonAceptar.setBounds(264, 69, 148, 29);
		contentPane.add(buttonAceptar);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setForeground(Color.RED);
		lblEstado.setBounds(6, 208, 61, 16);
		contentPane.add(lblEstado);

		textPaneEstado = new JTextPane();
		textPaneEstado.setToolTipText(
				"Panel para mostrar el restultado de la comprobaci�n de login o las excepciones lanzadas");
		textPaneEstado.setEditable(false);
		textPaneEstado.setBounds(6, 235, 406, 102);
		contentPane.add(textPaneEstado);

		JButton buttonLimpiar = new JButton("Limpiar");
		buttonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPaneEstado.setText("");

			}
		});
		buttonLimpiar.setBounds(264, 117, 148, 29);
		contentPane.add(buttonLimpiar);

		JLabel lblNewLabel = new JLabel("Iniciar sesión (Paciente)");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(109, 10, 239, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("En esta clínica puedes encontrar:");
		lblNewLabel_1.setBounds(31, 175, 370, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("- Podólogos  - Médicos de cabecera  - Especialistas");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_1_1.setBounds(54, 188, 370, 23);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblSiAunNo = new JLabel("Introduzca sus datos en los siguientes recuadros:");
		lblSiAunNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSiAunNo.setBounds(31, 31, 381, 27);
		contentPane.add(lblSiAunNo);

		JLabel lblNewLabel_1_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1_1.setBounds(27, 75, 63, 13);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel id = new JLabel("ID");
		id.setBounds(31, 123, 63, 13);
		contentPane.add(id);

	}
}

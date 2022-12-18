
	import java.awt.BorderLayout;
	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

	import Capa_Dominio.GestorUsuario;
	import Capa_Dominio.Usuario;

	import java.awt.FlowLayout;

	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.JButton;

	import java.awt.Color;

	import javax.swing.JTextPane;

	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;

	public class JFrameNuevoUsuario extends JFrame {

		private JPanel contentPane;
		private JTextField textFieldLogin;
		private JTextField textFieldPassword;
		private JTextPane textPaneEstado;

		
		public JFrameNuevoUsuario() {
			setTitle("Dar de alta a un nuevo usuario");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 420, 285);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblLogin = new JLabel("DNI:");
			lblLogin.setBounds(6, 81, 69, 16);
			contentPane.add(lblLogin);
			
			JLabel label = new JLabel("Nombre y apellidos:");
			label.setBounds(6, 37, 69, 16);
			contentPane.add(label);
			
			textFieldLogin = new JTextField();
			textFieldLogin.setBounds(87, 31, 134, 28);
			contentPane.add(textFieldLogin);
			textFieldLogin.setColumns(10);
			
			textFieldPassword = new JTextField();
			textFieldPassword.setColumns(10);
			textFieldPassword.setBounds(87, 75, 134, 28);
			contentPane.add(textFieldPassword);
			
			JButton btnAltaUsuario = new JButton("Alta usuario");
			btnAltaUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean insertado = false;
					try {
						if(GestorUsuario.nuevoUsuario(u.getmLogin(), u.getmPassword()) == true)
							insertado = true;
						
						if(insertado){
							textPaneEstado.setText("Usuario creado correctamente");
						} else {
							textPaneEstado.setText("No se ha podido insertar el usuario");
						}
						
					} catch (Exception e) {
						textPaneEstado.setText("No se ha podido crear  el usuario.�Tal vez ya existe?");
					}
					
				}
			});
			btnAltaUsuario.setBounds(253, 76, 117, 29);
			contentPane.add(btnAltaUsuario);
			
			JLabel label_1 = new JLabel("Estado");
			label_1.setForeground(Color.RED);
			label_1.setBounds(6, 126, 61, 16);
			contentPane.add(label_1);
			
			textPaneEstado = new JTextPane();
			textPaneEstado.setToolTipText("Panel para mostrar el restultado de la comprobaci\u00F3n de login o las excepciones lanzadas");
			textPaneEstado.setEditable(false);
			textPaneEstado.setBounds(6, 154, 407, 102);
			contentPane.add(textPaneEstado);
		}
	}

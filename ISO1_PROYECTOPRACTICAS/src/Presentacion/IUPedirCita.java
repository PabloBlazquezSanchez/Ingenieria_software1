package Presentacion;

	import java.awt.EventQueue;
	import Capa_Persistencia.AgenteBD;
	import Persistencia.BDConstantes;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

	import org.apache.derby.jdbc.EmbeddedDriver;

	import Capa_Dominio.GestorUsuario;
	import Capa_Dominio.Usuario;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JList;

	public class IUPedirCita extends JFrame {

		private JPanel contentPane;
		private JTextPane textPaneEstado;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						IUPedirCita frame = new IUPedirCita();
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
		public IUPedirCita() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 438, 385);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

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
			
			JLabel lblNewLabel = new JLabel("Seleccionar especialidad");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
			lblNewLabel.setBounds(109, 10, 239, 21);
			contentPane.add(lblNewLabel);
			
			JLabel lblSiAunNo = new JLabel("Selecciona una de las especialidades disponibles en esta clínica:");
			lblSiAunNo.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblSiAunNo.setBounds(31, 31, 381, 27);
			contentPane.add(lblSiAunNo);
			
			JButton btnDermatologa = new JButton("Dermatología");
			btnDermatologa.setBounds(31, 68, 340, 21);
			contentPane.add(btnDermatologa);
			
			JButton btnGinecologa = new JButton("Ginecología");
			btnGinecologa.setBounds(31, 99, 340, 21);
			contentPane.add(btnGinecologa);
			
			JButton btnTraumatologa = new JButton("Traumatología");
			btnTraumatologa.setBounds(31, 130, 340, 21);
			contentPane.add(btnTraumatologa);
			
			JButton btnReumatologa = new JButton("Reumatología");
			btnReumatologa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnReumatologa.setBounds(31, 161, 340, 21);
			contentPane.add(btnReumatologa);

			/*
			 * JScrollPane scrollPaneSalida = new JScrollPane(); scrollPaneSalida.
			 * setToolTipText("Este panel mostrar\u00E1 el resultado de la consulta, las excepciones o cualquier otro resultado"
			 * ); scrollPaneSalida.setBounds(6, 193, 407, 108); scrollPaneSalida.
			 * contentPane.add(scrollPaneSalida);
			 */
		}
	}

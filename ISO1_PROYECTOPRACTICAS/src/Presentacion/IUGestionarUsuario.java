package Presentacion;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Presentacion.IULoginEmpleado;
import Presentacion.IULoginPaciente;
import Presentacion.IURegistrarPaciente;


public class IUGestionarUsuario extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IUGestionarUsuario dialog = new IUGestionarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	
	public IUGestionarUsuario() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Iniciar sesión como paciente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IULoginPaciente p = new IULoginPaciente();
				p.setVisible(true);
			}
			
		});
		

		
		JLabel lblNewLabel = new JLabel("Operaciones del usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JButton btnNewButton_1 = new JButton("Registrar paciente");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IURegistrarPaciente p = new IURegistrarPaciente();
				p.setVisible(true);
			
			}});	
		
		
		JLabel lblSiAunNo = new JLabel("Si aún no estas registrado, pulsa el botón que hay abajo");
		lblSiAunNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton_1_1 = new JButton("Iniciar sesión como empleado");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IULoginEmpleado p = new IULoginEmpleado();
				p.setVisible(true);
			
			}});	
		{
			cancelButton = new JButton("Cancelar");
			cancelButton.setActionCommand("Cancel");
			cancelButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                System.exit(0);
		            }});
		}
	
			
			
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(62)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
						.addComponent(btnNewButton_1_1, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
					.addGap(74))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(152)
					.addComponent(btnNewButton_1)
					.addContainerGap(159, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addGap(82))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addComponent(lblSiAunNo, GroupLayout.PREFERRED_SIZE, 354, GroupLayout.PREFERRED_SIZE)
					.addGap(24))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap(343, Short.MAX_VALUE)
					.addComponent(cancelButton)
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSiAunNo, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addGap(18)
					.addComponent(cancelButton)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
}
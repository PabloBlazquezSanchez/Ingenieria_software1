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
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import Dominio.Entidades.Paciente;
import Persistencia.PacienteDAO;
 
public class IUOperaciones extends JFrame {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IUOperaciones dialog = new IUOperaciones();
			dialog.setDefaultCloseOperation
			(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IUOperaciones() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);

		JLabel titulo = new JLabel("Seleccionar operación");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 17));

		JButton cita = new JButton("Pedir cita");
		cita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IULoginPaciente p = new IULoginPaciente();
				p.setVisible(true);
			}
		});

		JLabel texto2 = new JLabel("Selecciona la operación que deseas realizar:");
		texto2.setFont(new Font("Tahoma", Font.BOLD, 11));

		JButton agenda = new JButton("Configurar agenda mensual");
		agenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IULoginEmpleado p = new IULoginEmpleado();
				p.setVisible(true);
				
			}
		});

		JButton registro = new JButton("Registrar paciente");
		registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IURegistrarPaciente p = new IURegistrarPaciente();
				p.setVisible(true);

			}
		});

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(registro, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(cita, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(agenda, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(62, Short.MAX_VALUE))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(26)
					.addComponent(texto2, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(121, Short.MAX_VALUE)
					.addComponent(titulo, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addGap(72))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(25)
					.addComponent(titulo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(texto2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(cita)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(agenda)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(registro)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
			}
		}
	}
}

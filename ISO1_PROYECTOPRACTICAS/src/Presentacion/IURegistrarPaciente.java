package Presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IURegistrarPaciente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IURegistrarPaciente dialog = new IURegistrarPaciente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public IURegistrarPaciente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel("Registrar paciente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));

		JButton btnNewButton_1 = new JButton("Enviar datos");

		JLabel lblSiAunNo = new JLabel("Introduzca sus datos en los siguientes recuadros:");
		lblSiAunNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		JLabel lblNewLabel_1_1 = new JLabel("Apellidos");

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Nombre");

		JLabel lblNewLabel_1_1_1_1 = new JLabel("DNI");

		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING).addGroup(
				gl_contentPanel.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE).addGroup(gl_contentPanel
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 239,
												GroupLayout.PREFERRED_SIZE)
										.addGap(48))
								.addGroup(gl_contentPanel.createSequentialGroup().addGroup(gl_contentPanel
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lblSiAunNo, GroupLayout.PREFERRED_SIZE, 381,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPanel.createSequentialGroup().addGap(6)
												.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addComponent(lblNewLabel_1_1_1,
																		GroupLayout.PREFERRED_SIZE, 63,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(textField, GroupLayout.PREFERRED_SIZE,
																		316, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addComponent(lblNewLabel_1_1,
																		GroupLayout.PREFERRED_SIZE, 63,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
																		316, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPanel.createSequentialGroup()
																.addComponent(lblNewLabel_1_1_1_1,
																		GroupLayout.PREFERRED_SIZE, 63,
																		GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(ComponentPlacement.RELATED)
																.addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
																		316, GroupLayout.PREFERRED_SIZE)))))
										.addGap(25)))
						.addGroup(Alignment.TRAILING,
								gl_contentPanel.createSequentialGroup().addComponent(btnNewButton_1).addGap(159)))));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblSiAunNo, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1))
				.addGap(16)
				.addGroup(gl_contentPanel
						.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1_1).addComponent(textField_1,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1_1_1))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnNewButton_1).addGap(28)));
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

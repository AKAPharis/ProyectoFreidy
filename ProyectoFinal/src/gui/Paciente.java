package gui;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Identidades.Documentacion;
import Identidades.Medico;
import db.dao.PacienteDAO;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;

public class Paciente extends JFrame {
	
	Medico medicoUsuario;
	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField noDocumento;

	
	public Paciente(Medico medico) {
		medicoUsuario = medico;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setBounds(100, 100, 351, 267);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 10, 96, 24);
		this.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(10, 33, 96, 19);
		this.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel Apellido = new JLabel("Apellido:");
		Apellido.setBounds(158, 16, 96, 18);
		this.getContentPane().add(Apellido);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(158, 33, 96, 19);
		this.getContentPane().add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel estado = new JLabel("Estado: ");
		estado.setBounds(10, 76, 96, 24);
		this.getContentPane().add(estado);
		
		JRadioButton rbtnAvtivo = new JRadioButton("Activo");
		rbtnAvtivo.setBounds(56, 78, 86, 21);
		this.getContentPane().add(rbtnAvtivo);
		
		JRadioButton rbtnInactivo = new JRadioButton("Inactivo");
		rbtnInactivo.setBounds(151, 78, 86, 21);
		this.getContentPane().add(rbtnInactivo);
		
		JRadioButton muelto = new JRadioButton("RIP");
		muelto.setBounds(239, 78, 103, 21);
		this.getContentPane().add(muelto);
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rbtnInactivo);
		bGroup.add(rbtnAvtivo);
		bGroup.add(muelto);
		
		JLabel lblNewLabel = new JLabel("Tipo Documento");
		lblNewLabel.setBounds(10, 110, 96, 24);
		this.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Cedula");
		comboBox.addItem("Pasaporte");
		comboBox.setBounds(10, 131, 96, 21);
		this.getContentPane().add(comboBox);
		
		JLabel lblNumeroDeDocumento = new JLabel("Numero de documento");
		lblNumeroDeDocumento.setBounds(158, 110, 155, 24);
		this.getContentPane().add(lblNumeroDeDocumento);
		
		noDocumento = new JTextField();
		noDocumento.setBounds(158, 132, 127, 19);
		this.getContentPane().add(noDocumento);
		noDocumento.setColumns(10);
		
		JButton btn = new JButton("Agregar paciente");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String estado;
				//public Paciente(int idPaciente,Documentacion documento,String nombre,String apellido,String estado,boolean interno,Medico medicoEncargago)

				if (rbtnAvtivo.isSelected()) {
			           estado = "Activo";
			        } else if (rbtnInactivo.isSelected()) {
			            estado = "Inactivo";
			        } else if (muelto.isSelected()) {
			            estado = "Muelto";
			        }else {
						estado = "Desconocido";
					}
				
				Identidades.Paciente paciente = new Identidades.Paciente(Builder.generateRandomID(), new Documentacion(comboBox.getSelectedItem().toString(), noDocumento.getText()), txtNombre.getText(), txtApellido.getText(), estado, false, medicoUsuario);
				
				new PacienteDAO().agregarPaciente(paciente);
				
				dispose();
			}
		});
		btn.setBounds(56, 181, 181, 21);
		this.getContentPane().add(btn);
		
		
	}
}

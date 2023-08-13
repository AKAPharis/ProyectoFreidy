package gui;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.List;

import db.dao.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Identidades.Medico;
import Identidades.Paciente;


public class Consulta extends JFrame{
	private Medico medicoUsuario;
	private JPanel panelVentana,panelComboBox;
	private JComboBox<Object> pacientes,cie10;
	
	public Consulta(Medico medicoUsuario) {
		this.medicoUsuario = medicoUsuario;
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setBounds(0, 0, 400, 400);
		
		panelVentana();
		this.add(panelVentana);
		
		
		
		
		
	}
	
	
	private void panelVentana() {
		panelVentana = new JPanel();
		panelVentana.setBackground(Color.blue);
		panelVentana.setLayout(new GridBagLayout());
		
		GridBagConstraints gbcCB = new GridBagConstraints();
		gbcCB.gridx = 0;
		gbcCB.gridy = 0;
		gbcCB.weightx = 0;
		gbcCB.weighty = 0;
		gbcCB.fill = GridBagConstraints.HORIZONTAL;
		panelComboBox();
		panelVentana.add(panelComboBox,gbcCB);
		
	}
	
	private void panelComboBox() {
		
		panelComboBox = new JPanel();
		panelComboBox.setLayout(new GridBagLayout());
		
		pacientes = new JComboBox<Object>();
		PacienteDAO pDAO = new PacienteDAO();
		List<Paciente> listaPacientes = pDAO.listaPacientes(medicoUsuario);
		
		for(Paciente p : listaPacientes) {
			pacientes.addItem(p.getNombre() + " " + p.getApellido());
		}
		GridBagConstraints gbcP = new GridBagConstraints();
		gbcP.gridx = 0;
		gbcP.gridy = 0;
		gbcP.weightx = 0;
		gbcP.weighty = 0;
		gbcP.fill = GridBagConstraints.HORIZONTAL;
		panelComboBox.add(pacientes);
		
		
		
		
	}
	
	
}

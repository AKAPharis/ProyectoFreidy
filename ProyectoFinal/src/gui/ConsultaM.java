package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import Identidades.Medicamento;
import Identidades.Medico;
import Identidades.Paciente;
import Identidades.Receta;
import db.dao.Cie10DAO;
import db.dao.ConsultaDAO;
import db.dao.PacienteDAO;
import db.dao.MedicamentoDAO;

public class ConsultaM extends JFrame{

	private Medico medicoUsuario;
	private JPanel panelVentana,panelComboBox,panelReceta,panelBotones;
	private JButton btnGuardar,btnAtras;
	private JTable medicamentos;
	private JComboBox<Object> pacientes;
	JComboCheckBox cie10;
	
	public ConsultaM(Medico medicoUsuario) {
		this.medicoUsuario = medicoUsuario;
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	//	this.setExtendedState(MAXIMIZED_BOTH);
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
		gbcCB.weightx = 1;
		gbcCB.weighty = 0.2;
		gbcCB.fill = GridBagConstraints.BOTH;
		panelComboBox();
		panelVentana.add(panelComboBox,gbcCB);
		
		GridBagConstraints gbcB = new GridBagConstraints();
		gbcB.gridx = 0;
		gbcB.gridy = 1;
		gbcB.weightx = 1;
		gbcB.weighty = 0.002;
		gbcB.fill = GridBagConstraints.HORIZONTAL;
		panelBotones();
		panelVentana.add(panelBotones,gbcB);
		
		GridBagConstraints gbcR = new GridBagConstraints();
		gbcR.gridx = 0;
		gbcR.gridy = 2;
		gbcR.weightx = 1;
		gbcR.weighty = 1;
		gbcR.fill = GridBagConstraints.BOTH;
		panelReceta();
		panelVentana.add(panelReceta,gbcR);
		
		
		
	}
	
	private void panelComboBox() {
		
		panelComboBox = new JPanel();
		panelComboBox.setLayout(new GridBagLayout());
		panelComboBox.setBackground(Color.DARK_GRAY);
		
		pacientes = new JComboBox<Object>();
		PacienteDAO pDAO = new PacienteDAO();
		List<Paciente> listaPacientes = pDAO.listaPacientes(medicoUsuario);
		
		for(Paciente p : listaPacientes) {
			pacientes.addItem(p.getNombre() + " " + p.getApellido());
		}
		GridBagConstraints gbcP = new GridBagConstraints();
		gbcP.gridx = 0;
		gbcP.gridy = 0;
		gbcP.weightx = 1;
		gbcP.weighty = 1;
		gbcP.fill = GridBagConstraints.HORIZONTAL;
		panelComboBox.add(pacientes,gbcP);
		
		cie10 = new JComboCheckBox();
		Cie10DAO cDAO = new Cie10DAO();
		List<String> listaCodigos = cDAO.listaCodigos();
		for(String c : listaCodigos) {
			cie10.addItem(new JCheckBox(c));
		}
		GridBagConstraints gbcC = new GridBagConstraints();
		gbcC.gridx = 1;
		gbcC.gridy = 0;
		gbcC.weightx = 1;
		gbcC.weighty = 1;
		gbcC.fill = GridBagConstraints.HORIZONTAL;
		panelComboBox.add(cie10,gbcC);
		
		
		
		
	}
	
	private void panelBotones() {
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.RED);
		panelBotones.setLayout(new FlowLayout());
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				agregarConsulta();
				
			
			}
		});
		panelBotones.add(btnGuardar);
		btnAtras = new JButton("Atras");
		panelBotones.add(btnAtras);
		
	}
	
	private void agregarConsulta() {

		LocalDate ld = LocalDate.now();
		Date date = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		PacienteDAO pDAO = new PacienteDAO();
		Cie10DAO c10DAO = new Cie10DAO();
		Receta receta;
		List<Medicamento> listaMedicamentos =  new ArrayList<>();
		//	public Receta(int idReceta,Medicamento[] listaMedicamentos) {
		//	public Medicamento(int idMedicamento,String nombreMedicamento,String principioActivo,String marca,String fabricante,int cantidad) {
		DefaultTableModel md = (DefaultTableModel) medicamentos.getModel();
		for(int i = 0 ; i < medicamentos.getModel().getRowCount() ; i++) {
			boolean eleccion =  (boolean) md.getValueAt(i, 6);
			
			if(eleccion) {
				listaMedicamentos.add(new Medicamento((Integer) md.getValueAt(i, 0),(String) md.getValueAt(i, 1),(String) md.getValueAt(i, 2),(String) md.getValueAt(i, 3),(String) md.getValueAt(i, 4),(Integer) md.getValueAt(i, 5)));
			}
			
			
			
		}
		
		
        ArrayList<JCheckBox> selectedCheckboxes = cie10.getSelectedCheckboxes();
		ArrayList<Integer> diagnostico = new ArrayList<>();
		
		for(JCheckBox chck : selectedCheckboxes) {
			diagnostico.add(c10DAO.getId(chck.getText()));
		}
		
		
		String pacienteNombre = (String) pacientes.getSelectedItem();
		String[] completo = pacienteNombre.split(" ");
		Paciente paciente = pDAO.getPaciente(completo[0], medicoUsuario);
		System.out.println(paciente.getIdPaciente());
		//	public Consulta(int idConsulta,Date fecha,Paciente paciente,Receta receta,Medico encargado,String[] diagnostico) {
		Identidades.Consulta consulta = new Identidades.Consulta(Builder.generateRandomID(),
										date,
										paciente,
										new Receta(Builder.generateRandomID(),listaMedicamentos),
										medicoUsuario,
										diagnostico.toArray()
										);
		ConsultaDAO cDAO = new ConsultaDAO();
		cDAO.agregarConsulta(consulta);
		
		
	}
	private void panelReceta() {
		//Object[] column = {"Id","Nombre","Principio Activo","Marca","Fabricante","Cantidad"};
		
		
		panelReceta = new JPanel();
		panelReceta.setBackground(Color.yellow);
		panelReceta.setLayout(new BoxLayout(panelReceta,BoxLayout.PAGE_AXIS));
		
		medicamentos = new JTable();
	/*	medicamentos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Id","Nombre","Principio Activo","Marca","Fabricante","Cantidad"
				}
				));*/
		DefaultTableModel md = new DefaultTableModel();
	//	md = (DefaultTableModel) medicamentos.getModel();
		md.addColumn("Id");
		md.addColumn("Nombre");
		md.addColumn("Principio Activo");
		md.addColumn("Marca");
		md.addColumn("Fabricante");
		md.addColumn("Cantidad");
		md.addColumn("Eleccion");
		MedicamentoDAO mDAO = new MedicamentoDAO();
		List<Medicamento> listaMedicamentos = mDAO.listaMedicamentos();
		for(Medicamento m : listaMedicamentos) {
			md.addRow(new Object[] {m.getIdMedicamento(),m.getNombreMedicamento(),m.getPrincipioActivo(),m.getMarca(),m.getFabricante(),m.getCantidad(),false});
		}
		medicamentos.setModel(md);
		TableColumn checkboxColumn = medicamentos.getColumnModel().getColumn(6); // Cambia el índice (6) por el de la columna donde deseas checkboxes
		checkboxColumn.setCellRenderer(new CheckboxRenderer());
		checkboxColumn.setCellEditor(new CheckboxEditor()); // Agrega esta línea para asignar el editor
		JScrollPane sp = new JScrollPane(medicamentos);
		panelReceta.add(sp);
		
		
	}
	
	
	
}

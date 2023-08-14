package gui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import Identidades.*;
import db.dao.*;

public class ConsultaM extends JFrame {

    private Medico medicoUsuario;
    private JPanel panelVentana, panelComboBox, panelReceta, panelBotones;
    private JButton btnGuardar, btnAtras;
    private JTable medicamentos;
    private JComboBox<Object> pacientes;
    JComboCheckBox cie10;

    public ConsultaM(Medico medicoUsuario) {
        this.medicoUsuario = medicoUsuario;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Consulta Médica"); // Agregado: Cambia el título del frame

        panelVentana();
        this.add(panelVentana);
    }

    private void panelVentana() {
        panelVentana = new JPanel();
        panelVentana.setLayout(new GridBagLayout());
        panelVentana.setBackground(Color.WHITE); // Cambiado: Fondo blanco para mejor legibilidad

        GridBagConstraints gbcCB = new GridBagConstraints();
        gbcCB.gridx = 0;
        gbcCB.gridy = 0;
        gbcCB.weightx = 1;
        gbcCB.weighty = 0.1; // Cambiado: Ajuste del peso para el tamaño
        gbcCB.fill = GridBagConstraints.BOTH;
        panelComboBox();
        panelVentana.add(panelComboBox, gbcCB);

        GridBagConstraints gbcR = new GridBagConstraints();
        gbcR.gridx = 0;
        gbcR.gridy = 1; // Cambiado: Cambio de posición para evitar espacio en blanco
        gbcR.weightx = 1;
        gbcR.weighty = 1;
        gbcR.fill = GridBagConstraints.BOTH;
        panelReceta();
        panelVentana.add(panelReceta, gbcR);

        GridBagConstraints gbcB = new GridBagConstraints();
        gbcB.gridx = 0;
        gbcB.gridy = 2;
        gbcB.weightx = 1;
        gbcB.weighty = 0.1; // Cambiado: Ajuste del peso para el tamaño
        gbcB.fill = GridBagConstraints.HORIZONTAL;
        panelBotones();
        panelVentana.add(panelBotones, gbcB);
    }

    private void panelComboBox() {
        panelComboBox = new JPanel();
        panelComboBox.setBackground(Color.WHITE);
        panelComboBox.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agregado: Espacio alrededor
        panelComboBox.setLayout(new GridBagLayout());

        pacientes = new JComboBox<Object>();
        PacienteDAO pDAO = new PacienteDAO();
        List<Paciente> listaPacientes = pDAO.listaPacientes(medicoUsuario);

        for (Paciente p : listaPacientes) {
            pacientes.addItem(p.getNombre() + " " + p.getApellido());
        }
        GridBagConstraints gbcP = new GridBagConstraints();
        gbcP.gridx = 0;
        gbcP.gridy = 0;
        gbcP.weightx = 1;
        gbcP.weighty = 1;
        gbcP.fill = GridBagConstraints.HORIZONTAL;
        gbcP.insets = new Insets(0, 0, 10, 10); // Agregado: Espaciado entre componentes
        panelComboBox.add(pacientes, gbcP);

        cie10 = new JComboCheckBox();
        Cie10DAO cDAO = new Cie10DAO();
        List<String> listaCodigos = cDAO.listaCodigos();
        for (String c : listaCodigos) {
            cie10.addItem(new JCheckBox(c));
        }
        GridBagConstraints gbcC = new GridBagConstraints();
        gbcC.gridx = 1;
        gbcC.gridy = 0;
        gbcC.weightx = 0.3;
        gbcC.weighty = 1;
        gbcC.fill = GridBagConstraints.HORIZONTAL;
        gbcC.insets = new Insets(0, 10, 10, 0); // Agregado: Espaciado entre componentes
        panelComboBox.add(cie10, gbcC);
    }

    private void panelReceta() {
        panelReceta = new JPanel();
        panelReceta.setBackground(Color.WHITE);
        panelReceta.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agregado: Espacio alrededor
        panelReceta.setLayout(new BorderLayout()); // Cambiado: Uso de BorderLayout

        DefaultTableModel md = new DefaultTableModel();
        md.addColumn("Id");
        md.addColumn("Nombre");
        md.addColumn("Principio Activo");
        md.addColumn("Marca");
        md.addColumn("Fabricante");
        md.addColumn("Cantidad");
        md.addColumn("Eleccion");

        MedicamentoDAO mDAO = new MedicamentoDAO();
        List<Medicamento> listaMedicamentos = mDAO.listaMedicamentos();
        for (Medicamento m : listaMedicamentos) {
            md.addRow(new Object[]{m.getIdMedicamento(), m.getNombreMedicamento(), m.getPrincipioActivo(),
                    m.getMarca(), m.getFabricante(), m.getCantidad(), false});
        }
        medicamentos = new JTable(md);
        TableColumn checkboxColumn = medicamentos.getColumnModel().getColumn(6);
        checkboxColumn.setCellRenderer(new CheckboxRenderer());
        checkboxColumn.setCellEditor(new CheckboxEditor());
        JScrollPane sp = new JScrollPane(medicamentos);
        panelReceta.add(sp, BorderLayout.CENTER); // Cambiado: Uso de BorderLayout
    }

    private void panelBotones() {
        panelBotones = new JPanel();
        panelBotones.setBackground(Color.WHITE);
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Cambiado: Alineación derecha

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                agregarConsulta();
            }
        });
        panelBotones.add(btnGuardar);

        btnAtras = new JButton("Atrás");
        panelBotones.add(btnAtras);
    }

    // ... (resto del código)



	
	
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
	
}

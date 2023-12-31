package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.Point;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JCalendar;

import Identidades.Consulta;
import Identidades.Medico;
import Identidades.Paciente;
import db.dao.ConsultaDAO;
import db.dao.MedicoDAO;
import db.dao.PacienteDAO;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;

public class Ventana {
	private Medico medicoUsuario;
	private JFrame frame;
	
	private JScrollPane scrollPane;
	private JPanel panel1, panel2, panel3, panel4;
	private JLabel label1, labelR, iniciarL, labelColor, labelI, lbl1, lbl2, lbl3, lbl4;
	private JPanel panel;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenu mnNewMenu_3;
	  private JPopupMenu popupMenu;
      private JMenuItem item1;
      private JMenuItem item2;
      private JMenuItem item3;
      private JLabel selectedLabel;
      private Color originalColor;
      private boolean menuVisible = false; // Bandera para verificar si el menú está visible
  	private DefaultTableModel model;
  	private Date selectedDate = null;
  	private JComboBox<Object> pacientes;
  	private JTable tabla,tablaPacientes;

      

	/**
	 * Launch the application.
	 */
	public static void main(int idEntero) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana(idEntero);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana(int idEntero) {
		MedicoDAO medicoDAO = new MedicoDAO();
		this.medicoUsuario = medicoDAO.getMedico(idEntero);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		 frame = new JFrame("Hospital MeDick");
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		 frame.setBounds(10,10,1600,800);
		 frame.setResizable(false);
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.getContentPane().setLayout(new GridLayout(1, 1));
		 
		 scrollPane = new JScrollPane();
		 
		 panel = new JPanel();
		 panel.setLayout(new GridLayout(4, 1));
		
         GridBagConstraints gbc = new GridBagConstraints();
		 
		 panel1 = new JPanel();
		 panel1.setBackground(Color.GRAY);
	     panel1.setLayout(new GridBagLayout());
	     
	     GridBagConstraints gbcImage = new GridBagConstraints();
         ImageIcon imageIcon = new ImageIcon("imagenes/Cruz.png");
         Image scaledImage = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
         ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
         JLabel imageLabel = new JLabel(scaledImageIcon);
         
        

         gbcImage.gridx = 0;
         gbcImage.gridy = 0;
         gbcImage.anchor = GridBagConstraints.LINE_START; // Align to the left
         gbcImage.insets = new Insets(0, 400, 0, 100); // Add space to the right
         gbcImage.ipadx = 5;
         gbcImage.ipady = 5;
         gbcImage.gridwidth = 2;
         gbcImage.gridheight = 1;
         gbcImage.weightx = 1.0;
         gbcImage.weighty = 0.0;
         panel1.add(imageLabel, gbcImage);
         
         label1 = new JLabel("LifeSaver");
         label1.setFont(new Font("Arial", Font.BOLD, 80));

         gbc.gridx = 1; // Coloca el label en la columna siguiente
         gbc.gridy = 0; // Mantén la misma fila
         gbc.anchor = GridBagConstraints.LINE_START; // Alinea a la izquierda
         gbc.insets = new Insets(0, 600, 20, 0); // Ajusta los márgenes para el espacio entre la imagen y el label

         panel1.add(label1, gbc);
         
	      
       
	     panel2 = new JPanel();
	     panel2.setLayout(new GridBagLayout());
	     GridBagConstraints gbcImage22 = new GridBagConstraints();
         ImageIcon imageIcon22 = new ImageIcon("imagenes/Citas.jpg");
         Image scaledImage22 = imageIcon22.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
         ImageIcon scaledImageIcon22 = new ImageIcon(scaledImage22);
         JLabel imageLabel22 = new JLabel(scaledImageIcon22);
         gbcImage22.gridx = 0;
         gbcImage22.gridy = 0;
         gbcImage22.anchor = GridBagConstraints.LINE_START; // Align to the left
         gbcImage22.insets = new Insets(0, 0, 0, 100); // Add space to the right

         panel2.add(imageLabel22, gbcImage22);
         imageLabel22.addMouseListener(new MouseAdapter() {
        	    private JButton btn;

				@Override
        	    public void mouseEntered(MouseEvent e) {
        	        // Cambiar la imagen al pasar el mouse por encima
        	        ImageIcon newImageIcon22 = new ImageIcon("imagenes/Citas2.jpg");
        	        Image newScaledImage22 = newImageIcon22.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        	        ImageIcon newScaledImageIcon22 = new ImageIcon(newScaledImage22);
        	        imageLabel22.setIcon(newScaledImageIcon22);
        	    }

        	    @Override
        	    public void mouseExited(MouseEvent e) {
        	        // Restaurar la imagen original al quitar el mouse
        	        ImageIcon originalImageIcon22 = new ImageIcon("imagenes/Citas.jpg");
        	        Image originalScaledImage22 = originalImageIcon22.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        	        ImageIcon originalScaledImageIcon22 = new ImageIcon(originalScaledImage22);
        	        imageLabel22.setIcon(originalScaledImageIcon22);
        	    }

        	    @Override
        	    public void mouseClicked(MouseEvent e) {
        	        if (SwingUtilities.isLeftMouseButton(e)) {
        	            // Abre la nueva ventana aquí
        	           // Por ejemplo, creando una nueva instancia de JFrame
        	            JFrame newFrame = new JFrame("Agenda de citas");
        	            newFrame.setSize(800, 600);
        	            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	        	newFrame.setLocationRelativeTo(null);
        	        	newFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        	            newFrame.setVisible(true);
        	            newFrame.setResizable(false);
        	    		newFrame.getContentPane().setLayout(null);
        	            
        	    	// Cambia este valor según tus necesidades
        	    		
        	    		model = new DefaultTableModel();
        	    		model.addColumn("");	
        	    		model.addColumn("");
        	    		model.addColumn("Fecha");	
        	    		model.addColumn("Paciente");
                        model.addRow(new Object[]{"09:00am"});
                        model.addRow(new Object[]{"10:00am"});
                        model.addRow(new Object[]{"11:00am"});
                        model.addRow(new Object[]{"12:00pm"});
                        model.addRow(new Object[]{"01:00pm"});
                        model.addRow(new Object[]{"02:00pm"});
                        model.addRow(new Object[]{"03:00pm"});
                        model.addRow(new Object[]{"04:00pm"});
                        model.addRow(new Object[]{"05:00pm"});
                        model.addRow(new Object[]{"07:00pm"});
                        model.addRow(new Object[]{"08:00pm"});
                        model.addRow(new Object[]{"09:00pm"});
                        model.addRow(new Object[]{"10:00pm"});
                        model.addRow(new Object[]{"11:00pm"});


                        JCalendar calendar23 = new JCalendar();
        	    		calendar23.setBounds(550, 100, 200, 200);
        	    		newFrame.add(calendar23);
                        
        	    		   
        	    		JTable citas1 = new JTable(model);
        	    		JScrollPane pane = new JScrollPane();
        	    		pane.setBounds(30, 100, 500, 450);
        	    		newFrame.add(pane);
        	    		pane.setViewportView(citas1);
        	    		
        	    		   citas1.setRowHeight(40);
    	   
        	    		

        	    		calendar23.addPropertyChangeListener("calendar", new PropertyChangeListener() {
        	    		    @Override
        	    		    public void propertyChange(PropertyChangeEvent evt) {
        	    		        if (evt.getPropertyName().equals("calendar")) {
        	    		            Calendar selectedCalendar = (Calendar) evt.getNewValue();
        	    		            Date selectedDate = selectedCalendar.getTime();
        	    		            		
        	    		        }
        	    		    }
        	    		});

        	    		
        	            btn = new JButton("Agregar cita");
        	            btn.setBounds(30, 20, 180, 30);
        	            btn.setFont(new Font("", Font.BOLD, 20));
        	            btn.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								JFrame agendar = new JFrame("Agenda de Citas");							
								agendar.setSize(500, 300);
								agendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								agendar.setLocationRelativeTo(null);
								agendar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		        	        	agendar.setVisible(true);
		        	        	agendar.getContentPane().setLayout(null);	
		        	            agendar.setResizable(false);
		        	            
								JLabel lbl1 = new JLabel("Paciente");
		        	            lbl1.setBounds(10, 50, 180, 30);
		        	            agendar.add(lbl1);
		        	            
		        	            pacientes = new JComboBox<Object>();
		        	    		PacienteDAO pDAO = new PacienteDAO();
		        	    		List<Paciente> listaPacientes = pDAO.listaPacientes(medicoUsuario);
		        	    		
		        	    		for(Paciente p : listaPacientes) {
		        	    			pacientes.addItem(p.getNombre() + " " + p.getApellido());
		        	    		}
		        	            pacientes.setBounds(100, 60, 300, 20);
		        	            
		        	            
		        	            agendar.add(pacientes);
		        	            		        	            
		        	          
		        	            
		        	            JLabel lbl3 = new JLabel("Fecha y hora:");
		        	            lbl3.setBounds(10, 95, 180, 30);
		        	            agendar.add(lbl3);
		        	                   	            
		        	            
		        	            JComboBox<String> box2 = new JComboBox<>();
		        	          

		        	            
		        	            box2.setBounds(260, 100, 100, 20);
		        	            box2.addItem("Hora");
		        	            box2.addItem("09:00am");
		        	            box2.addItem("10:00am");
		        	            box2.addItem("11:00am");
		        	            box2.addItem("12:00pm");
		        	            box2.addItem("01:00pm");
		        	            box2.addItem("02:00pm");
		        	            box2.addItem("03:00pm");
		        	            box2.addItem("04:00pm");
		        	            box2.addItem("05:00pm");
		        	            box2.addItem("06:00pm");
		        	            box2.addItem("07:00pm");
		        	            box2.addItem("08:00pm");
		        	            box2.addItem("09:00pm");
		        	            box2.addItem("10:00pm");
		        	            box2.addItem("11:00pm");
		        	            agendar.add(box2);
		        	            
		        	            
		        	            
		        	    		 JComboBox<String> box3 = new JComboBox<>();
		        	    	        box3.setBounds(100, 100, 150, 20);
		        	    	        agendar.add(box3);
		        	    	        
		        	    	        JPopupMenu popupMenu1 = new JPopupMenu();
		        	    	        JCalendar calendarBox1 = new JCalendar();
		        	    	        
		        	    	        calendarBox1.addPropertyChangeListener("calendar", new PropertyChangeListener() {
		        	    	            @Override
		        	    	            public void propertyChange(PropertyChangeEvent evt) {
		        	    	                Date selectedDate = calendarBox1.getDate();
		        	    	                if (selectedDate != null) {
		        	    	                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        	    	                    String formattedDate = dateFormat.format(selectedDate);
		        	    	                    box3.removeAllItems();
		        	    	                    box3.addItem(formattedDate);
		        	    	                }
		        	    	            }
		        	    	        });
    
		        	    	  
		        	    	        
		        	    	        box3.addMouseListener(new MouseAdapter() {
		        	    	            @Override
		        	    	            public void mouseClicked(MouseEvent e) {
		        	    	                if (SwingUtilities.isLeftMouseButton(e)) {
		        	    	                    calendarBox1.setBounds(30, 100, 200, 200);
		        	    	                    popupMenu1.show(box3, 0, box3.getHeight());
		        	    	                 
		        	    	                    
		        	    	                 
		        	    	                }
		        	    	            }
		        	    	        });  
		        	    	        
		        	    	        							
		        	    	     // Suponiendo que calendarBox1 y box3 ya están inicializados correctamente
		        	    	        popupMenu1.add(calendarBox1);

		        	    	        JButton btnGuardar = new JButton("Guardar");
			        	            btnGuardar.setFont(new Font("", Font.BOLD, 20));
			        	            btnGuardar.setBounds(300, 200, 150, 30);
			        	            btnGuardar.addActionListener(new ActionListener() {
										
										@Override
										public void actionPerformed(ActionEvent e) {
											// TODO Auto-generated method stub
											
											  String horaSeleccionada = (String) box2.getSelectedItem();
											    String diaSeleccionado = (String) box3.getSelectedItem();
											    String paciente = (String) pacientes.getSelectedItem();

										        boolean encontrado = false;
											    // Buscar la fila correspondiente a la hora seleccionada en la tabla
											    for (int row = 0; row < model.getRowCount(); row++) {
											        String horaTabla = (String) model.getValueAt(row, 0);
											        if (horaSeleccionada.equals(horaTabla)) {
											            model.setValueAt(diaSeleccionado, row, 2); // Columna "Dia"
											            model.setValueAt(paciente, row, 3); // Columna "Paciente"
										                encontrado = true;
											            break; // No es necesario seguir buscando
											        }
											    }
										        agendar.dispose(); // Cerrar la ventana agendar después de guardar

										        if (encontrado) {
										            agendar.dispose(); // Cerrar la ventana agendar después de guardar
										        } else {
										            JOptionPane.showMessageDialog(agendar, "No se encontró la hora seleccionada en la tabla", "Error", JOptionPane.ERROR_MESSAGE);
										        }
										}
									});
			        	            agendar.add(btnGuardar);
		        	    	        
			        	            
		        	    	        
							}
							
						  
						    	
	        	            
							
						});
        	            
        	       
        	        
        	         
        	            
        	            newFrame.add(btn);
        	            
        	            
        	        }
        	    }
        	});

         
         
         
         
         GridBagConstraints gbcImage3 = new GridBagConstraints();
         ImageIcon imageIcon3 = new ImageIcon("imagenes/Consulta1.png");
         Image scaledImage3 = imageIcon3.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
         ImageIcon scaledImageIcon3 = new ImageIcon(scaledImage3);
         JLabel imageLabel3 = new JLabel(scaledImageIcon3);
         gbcImage3.gridx = 0;
         gbcImage3.gridy = 0;
         gbcImage3.anchor = GridBagConstraints.LINE_START; // Align to the left
         gbcImage3.insets = new Insets(0, 300, 0, 200); // Add space to the right
 
         panel2.add(imageLabel3, gbcImage3);
         imageLabel3.addMouseListener(new MouseAdapter() {
     	    @Override
     	    public void mouseEntered(MouseEvent e) {
     	        // Cambiar la imagen al pasar el mouse por encima
     	        ImageIcon newImageIcon4 = new ImageIcon("imagenes/Consulta2.png");
     	        Image newScaledImage4 = newImageIcon4.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
     	        ImageIcon newScaledImageIcon4 = new ImageIcon(newScaledImage4);
     	        imageLabel3.setIcon(newScaledImageIcon4);
     	    }

     	    @Override
     	    public void mouseExited(MouseEvent e) {
     	        // Restaurar la imagen original al quitar el mouse
     	        ImageIcon originalImageIcon = new ImageIcon("imagenes/Consulta1.png");
     	        Image originalScaledImage = originalImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
     	        ImageIcon originalScaledImageIcon = new ImageIcon(originalScaledImage);
     	        imageLabel3.setIcon(originalScaledImageIcon);
     	    }

     	    @Override
     	    public void mouseClicked(MouseEvent e) {
     	        if (SwingUtilities.isLeftMouseButton(e)) {
     	            // Abre la nueva ventana aquí
     	            // Por ejemplo, creando una nueva instancia de JFrame
     	        	 JFrame newFrame = new JFrame("Agregar Consulta");
       	            newFrame.setSize(700, 500);
       	            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	            newFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);     
       	           newFrame.setLocationRelativeTo(null);
     	        	newFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     	            newFrame.setVisible(true);
     	            newFrame.setResizable(false);
     	    		newFrame.getContentPane().setLayout(null);
     	    		
     	    		
     	    		JButton btnP = new JButton("Agregar Consulta");
     	    		btnP.setBounds(10, 20, 200, 40);
     	    		btnP.setFont(new Font("", Font.BOLD, 20));
     	    		newFrame.add(btnP);
     	    		btnP.addActionListener(new ActionListener() {
  					
  					@Override
  					public void actionPerformed(ActionEvent e) {
  						// TODO Auto-generated method stub
  						ConsultaM consulta = new ConsultaM(medicoUsuario);
  						
  						
  					}
  				});
     	    		
     	    		JButton verConsulta = new JButton("Ver Consulta");
     	    		verConsulta.setBounds(470, 20, 200, 40);
     	    		verConsulta.setFont(new Font("", Font.BOLD, 20));
     	    		verConsulta.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							agregarConsulta();
						}
					});
     	    		newFrame.add(verConsulta);
     	    		
     	    		
     	    		DefaultTableModel model = new DefaultTableModel();
     	    		model.addColumn("IdConsulta");
     	    		model.addColumn("Paciente");
     	    		model.addColumn("Fecha");
     	    		
     	    		List<Identidades.Consulta> listaConsulta =  new ConsultaDAO().listaConsulta(medicoUsuario);
     	    		
     	    		for(Identidades.Consulta c : listaConsulta) {
     	    			model.addRow(new Object [] {c.getIdConsulta(),c.getPaciente().getNombre(),c.getFecha()});;
     	    		}
     	    		
     	    		
     	    		tabla = new JTable(model);
     	    		JScrollPane sp = new JScrollPane(tabla);
     	    		sp.setBounds(100, 80, 500, 500);
     	    		newFrame.add(sp);
       	            
       	        }
       	
       	    }
       	});
        
         
         GridBagConstraints gbcImage5 = new GridBagConstraints();
         ImageIcon imageIcon5 = new ImageIcon("imagenes/Saver1.png");
         Image scaledImage5 = imageIcon5.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
         ImageIcon scaledImageIcon5 = new ImageIcon(scaledImage5);
         JLabel imageLabel5 = new JLabel(scaledImageIcon5);
         gbcImage5.gridx = 0;
         gbcImage5.gridy = 0;
         gbcImage5.anchor = GridBagConstraints.LINE_START; // Align to the left
         gbcImage5.insets = new Insets(0, 600, 0, 200); // Add space to the right

         panel2.add(imageLabel5, gbcImage5);
         
         
         GridBagConstraints gbcImage7 = new GridBagConstraints();
         ImageIcon imageIcon7 = new ImageIcon("imagenes/Pacientes1.png");
         Image scaledImage7 = imageIcon7.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
         ImageIcon scaledImageIcon7 = new ImageIcon(scaledImage7);
         JLabel imageLabel7 = new JLabel(scaledImageIcon7);
         gbcImage7.gridx = 0;
         gbcImage7.gridy = 0;
         gbcImage7.anchor = GridBagConstraints.LINE_START; // Align to the left
         gbcImage7.insets = new Insets(0, 900, 0, 200); // Add space to the right
         
         panel2.add(imageLabel7, gbcImage7);
         imageLabel7.addMouseListener(new MouseAdapter() {
     	    @Override
     	    public void mouseEntered(MouseEvent e) {
     	        // Cambiar la imagen al pasar el mouse por encima
     	        ImageIcon newImageIcon7 = new ImageIcon("imagenes/Pacientes2.png");
     	        Image newScaledImage7 = newImageIcon7.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
     	        ImageIcon newScaledImageIcon7 = new ImageIcon(newScaledImage7);
     	        imageLabel7.setIcon(newScaledImageIcon7);
     	    }

     	    @Override
     	    public void mouseExited(MouseEvent e) {
     	        // Restaurar la imagen original al quitar el mouse
     	        ImageIcon originalImageIcon8 = new ImageIcon("imagenes/Pacientes1.png");
     	        Image originalScaledImage8 = originalImageIcon8.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
     	        ImageIcon originalScaledImageIcon8 = new ImageIcon(originalScaledImage8);
     	        imageLabel7.setIcon(originalScaledImageIcon8);
     	    }

     	    @Override
     	    public void mouseClicked(MouseEvent e) {
     	        if (SwingUtilities.isLeftMouseButton(e)) {
     	            // Abre la nueva ventana aquí
     	            // Por ejemplo, creando una nueva instancia de JFrame
     	           
     	        	JFrame newFrame = new JFrame("Agregar Paciente");
     	        	newFrame.setSize(700, 500);
       	            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       	            newFrame.setVisible(true);
       	            newFrame.setLocationRelativeTo(null);
     	        	newFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
     	            newFrame.setVisible(true);
     	            newFrame.setResizable(false);
     	    		newFrame.getContentPane().setLayout(null);
     	    		
     	    		
     	    		DefaultTableModel model = new DefaultTableModel();
     	    		model.addColumn("Id Paciente");
     	    		model.addColumn("Nombre");
     	    		model.addColumn("Apellido");
     	    		model.addColumn("Estado");
     	    		
     	    		List<Identidades.Paciente> listaPacientes = new PacienteDAO().listaPacientes(medicoUsuario);
     	    		
     	    		for(Identidades.Paciente p : listaPacientes){
     	    			model.addRow(new Object[] {p.getIdPaciente(),p.getNombre(),p.getApellido(),p.getEstado()});
     	    		}
     	    		
     	    		tabla = new JTable(model);
     	    		JScrollPane sp = new JScrollPane();
     	    		sp.setViewportView(tabla);
     	    		sp.setBounds(50, 80, 500, 500);
     	    		newFrame.add(sp);
     	    		
     	    		

     	    	  JLabel lblF = new JLabel("LifeSaver");
     	    	  lblF.setBounds(10, 20, 300, 50);
     	    	  lblF.setFont(new Font("Arial", Font.BOLD, 50));
     	    	  newFrame.add(lblF);
     	    	  
     	    		JButton btnP = new JButton("Agregar Paciente");
     	    		btnP.setBounds(450, 20, 200, 30);
     	    		btnP.setFont(new Font("", Font.BOLD, 20));
     	    		newFrame.add(btnP);
     	    		btnP.addActionListener(new ActionListener() {
  					
  					@Override
  					public void actionPerformed(ActionEvent e) {
  						gui.Paciente paciente = new gui.Paciente(medicoUsuario);
  						
  					}
  				});
     	    		
     	    		/*
     	    		JTable tabla = new JTable(model);
     	    		tabla.setBounds(50, 80, 500, 500);
     	    		newFrame.add(tabla);
       	         */   
       	        }
       	
       	    }
       	});
     	        	
               
         
         GridBagConstraints gbcImage9 = new GridBagConstraints();
         ImageIcon imageIcon9 = new ImageIcon("imagenes/Componente2.png");
         Image scaledImage9 = imageIcon9.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
         ImageIcon scaledImageIcon9 = new ImageIcon(scaledImage9);
         JLabel imageLabel9 = new JLabel(scaledImageIcon9);
         gbcImage9.gridx = 0;
         gbcImage9.gridy = 0;
         gbcImage9.anchor = GridBagConstraints.LINE_START; // Align to the left
         gbcImage9.insets = new Insets(0, 1100, 0, 200); // Add space to the right
         	
         panel2.add(imageLabel9, gbcImage9);
	     
         
	     panel3 = new JPanel();
	     panel3.setLayout(new GridBagLayout());
	     
	     panel4 = new JPanel();
	     panel4.setLayout(new GridBagLayout());
	     
	     panel.add(panel1);
  
	     
	     panel.add(panel2);
	     panel.add(panel3);
	     panel.add(panel4);
	     
	     scrollPane.setViewportView(panel);

		 
		 frame.getContentPane().add(scrollPane);
		 
		 
	}
	
	private void agregarConsulta() {
		
		int filaSeleccionada = tabla.getSelectedRow();
		model = (DefaultTableModel) tabla.getModel();
		if (filaSeleccionada != -1) {
            int idConsulta = (int) model.getValueAt(filaSeleccionada, 0);
           Consulta consulta = new  ConsultaDAO().getConsulta(idConsulta, medicoUsuario);

            
            
            mostrarDetalles(consulta);
        }
		
	}
	
	
	
	 private static void mostrarDetalles(Consulta consulta) {
	        JFrame detallesFrame = new JFrame("Detalles");
	        detallesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        detallesFrame.setResizable(false);
	        detallesFrame.setLocationRelativeTo(null);

	        JPanel panel = new JPanel(null); // Layout absoluto

	        JLabel idLabel = new JLabel("ID: " + consulta.getIdConsulta());
	        idLabel.setBounds(10, 10, 200, 20); // Posición y tamaño
	        panel.add(idLabel);

	        JLabel pacienteLabel = new JLabel("Nombre: " + consulta.getPaciente().getNombre());
	        pacienteLabel.setBounds(10, 40, 200, 20); // Posición y tamaño
	        panel.add(pacienteLabel);

	        JLabel nombreLabel = new JLabel("Apellido: " + consulta.getPaciente().getApellido());
	        nombreLabel.setBounds(10, 70, 200, 20); // Posición y tamaño
	        panel.add(nombreLabel);

	        /*
	        JLabel fechaLabel = new JLabel("Fecha: " + fecha);
	        fechaLabel.setBounds(10, 100, 200, 20); // Posición y tamaño
	        panel.add(fechaLabel);
*/
	        detallesFrame.getContentPane().add(panel);
	        detallesFrame.setSize(300, 200); // Tamaño de la ventana
	        detallesFrame.setVisible(true);
	    }
	}

package gui;

import Identidades.*;

import db.dao.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.TextField;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.*;

public class Builder {

	private JFrame Ventana, ventanaEmergente;
	private JButton btnGuardar;
	private String[] comboBoxOptions = {"Cedula", "Pasaporte"};
    private String[] buttonLabels = {"Medico", "Enfermero"};
    private JRadioButton selectedRadioButton;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Builder window = new Builder();
					window.Ventana.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Builder() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        Ventana = new JFrame();
        Ventana.setSize(700, 537);
        Ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ventana.setLocationRelativeTo(null);
        Ventana.setResizable(false);
        Ventana.setLayout(new GridLayout(1, 3));// Usar GridLayout de 1 fila y 2 columnas para dividir en dos mitades

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());

        // Crear un nuevo objeto GridBagConstraints para cada componente
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 20, 20, 20);

        // Crear un ButtonGroup para los radio buttons
        gbc.gridy = 1;
        ButtonGroup buttonGroup = createButtonGroupPanel(panel1, buttonLabels, gbc, 1);

        GridBagConstraints gbcImg5 = new GridBagConstraints();
        ImageIcon imageIcon5 = new ImageIcon("Imagenes/Saver1.png");
        Image scaledImage5 = imageIcon5.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon5 = new ImageIcon(scaledImage5);
        JLabel imageLbl = new JLabel(scaledImageIcon5);

        gbc.gridy = 0;
        panel1.add(imageLbl, gbcImg5);

        // Agregar el campo de ID
        gbc.gridy = 2;
        createLabeledTextFieldPanel(panel1, "ID:", "insertar ID", gbc, 3);

        // Agregar el campo de Contraseña
        gbc.gridy = 3;
        createPasswordField(panel1, "Contraseña", gbc, 4);

        // Agregar el botón "Iniciar sesión"
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.CENTER;
        btnGuardar = new JButton("Iniciar sesión");
        panel1.add(btnGuardar, gbc);
        // Resto de tu código para el botón "Iniciar sesión"

        // Agregar el JLabel de registro
        gbc.gridy = 6;
        JLabel registroLabel = new JLabel("Registrar");
        registroLabel.setForeground(Color.BLUE);
        registroLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        registroLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Registro();
            }
        });
        
        GridBagConstraints gbcRegistroLabel = new GridBagConstraints();
        gbcRegistroLabel.gridx = 0; // Columna 0
        gbcRegistroLabel.gridy = 12; 
        gbcRegistroLabel.anchor = GridBagConstraints.SOUTHWEST; // Alineación en la esquina inferior izquierda
        panel1.add(registroLabel, gbcRegistroLabel);

        
        // Agregar el panel1 a la ventana
        Ventana.add(panel1);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        ImageIcon imagen = new ImageIcon("Imagenes/LogoHospital.png");
        JLabel lblImagen = new JLabel(imagen);
        lblImagen.setPreferredSize(new Dimension(imagen.getIconWidth(), imagen.getIconHeight()));       
        panel2.add(lblImagen);
        Ventana.add(panel2);
        
     // Solicitar el enfoque en el panel1 después de mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            panel1.requestFocusInWindow();
        });
    

    }

    
	public void Registro() {      
		String correctPassword = "admin123";
	    String enteredPassword = getPasswordFromInputDialog();

	    while (enteredPassword != null && !enteredPassword.equals(correctPassword)) {
	        JOptionPane.showMessageDialog(Ventana, "Contraseña incorrecta. Inténtalo nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
	        enteredPassword = getPasswordFromInputDialog();
	    }

	    if (enteredPassword != null && enteredPassword.equals(correctPassword)) {
	        ButtonModel selectedButton = selectedRadioButton.getModel();
	        
	        if (selectedButton.getActionCommand().equals("Medico")) {
	           registrarMedico();
	        } else if (selectedButton.getActionCommand().equals("Enfermero")) {
	            registrarEnfermero();
	        }
	    }
	}
    
    
     
    private void registrarMedico() {
    	ventanaEmergente = new JFrame("Registro de medico");
    	ventanaEmergente.setSize(700, 537);
        ventanaEmergente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaEmergente.setLocationRelativeTo(null);
        ventanaEmergente.setResizable(false);
        ventanaEmergente.setLayout(new GridLayout(1, 3));
        ventanaEmergente.setVisible(true);
        ventanaEmergente.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Para que al cerrar la ventana emergente no se cierre la ventana principal
        Ventana.setVisible(false);
        
        ventanaEmergente.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	Ventana.setVisible(true);
            }
        });
        
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());

        // Crear un nuevo objeto GridBagConstraints para cada componente
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(20, 20, 20, 20);

        // Agregar el espacio vacío
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        panel1.add(new JLabel(), gbc);

     // Agregar el campo de ID 
        gbc.gridwidth = 2;
        JTextField nombreMedico = createLabeledTextFieldPanel(panel1, "Nombre:", "primer nombre", gbc, 2);
        gbc.gridwidth = 2;
        JTextField apellidoMedico = createLabeledTextFieldPanel(panel1, "Apellido:", "primer apellido", gbc, 3);
        gbc.gridwidth = 1;
        JComboBox<String> tipoDocumentoMedico = createLabeledComboBox("Tipo de documento", comboBoxOptions, panel1, gbc, 4);
        gbc.gridwidth = 1;
        JTextField noDocuementoMedico = createLabeledTextFieldPanel(panel1, "numero de documento:", "documento", gbc, 4);
        gbc.gridwidth = 2;
        JTextField exequatur = createLabeledTextFieldPanel(panel1, "Exequatur:", "exequatur", gbc, 5); 
        gbc.gridwidth = 2;
        JTextField especializacion = createLabeledTextFieldPanel(panel1, "Especializacion", "¿Cual es su especializacion?", gbc, 6);
        
        // Agregar el campo de Contraseña
        gbc.gridx = 0;
        gbc.gridy = 13;
        JTextField contraseñaMedico = createPasswordField(panel1, "Contraseña", gbc, 7);
        
        noDocuementoMedico.setEnabled(false);
        tipoDocumentoMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tipoDocumentoMedico.getSelectedIndex() != -1) {
                    noDocuementoMedico.setEnabled(true);
                }
            }
        });

     // Agregar el botón "Registrar"
        gbc.gridy = 14;
        gbc.gridwidth = 2; // Ocupar 2 celdas horizontales
        gbc.anchor = GridBagConstraints.CENTER;
        btnGuardar = new JButton("Registrar");
        btnGuardar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (nombreMedico.getText().equals("primer nombre") || apellidoMedico.getText().equals("primer apellido") || tipoDocumentoMedico.getSelectedItem() == null || noDocuementoMedico.getText().equals("documento") || exequatur.getText().equals("exequatur") || especializacion.getText().equals("especializacion") || contraseñaMedico.getText().equals("Contraseña") || nombreMedico.getText().equals("") || apellidoMedico.getText().equals("") || tipoDocumentoMedico.getSelectedItem() == null || noDocuementoMedico.getText().equals("") || exequatur.getText().equals("") || especializacion.getText().equals("") || contraseñaMedico.getText().equals("")  ) {
					JOptionPane.showMessageDialog(Ventana, "Debe completar todos los campos de registro.", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					
					// Generar el ID aleatorio
			        int idMedico = generateRandomID();
			        // Crear una instancia de Medico con los valores ingresados
			        Medico medico = new Medico(
			            idMedico,
			            exequatur.getText(),
			            especializacion.getText(),
			            nombreMedico.getText(),
			            apellidoMedico.getText(),
			            // Puedes asignar los valores directamente a las propiedades de la instancia medico
			            // Por ejemplo:
			            new Documentacion(tipoDocumentoMedico.getSelectedItem().toString(), noDocuementoMedico.getText()),
			            contraseñaMedico.getText()
			        );
			        
			        // Llamar al método btnRegistroMedico pasando la instancia de Medico y los demás campos
			        btnRegistroMedico(medico, nombreMedico, apellidoMedico, tipoDocumentoMedico, noDocuementoMedico, exequatur, especializacion, contraseñaMedico);				
				}
				
			}
        	
        });          
        panel1.add(btnGuardar, gbc);
        
        ventanaEmergente.add(panel1);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        ImageIcon imagen = new ImageIcon("Imagenes/LogoHospital.png");
        JLabel lblImagen = new JLabel(imagen);
        lblImagen.setPreferredSize(new Dimension(imagen.getIconWidth(), imagen.getIconHeight()));       
        panel2.add(lblImagen);
        ventanaEmergente.add(panel2);
        
     // Solicitar el enfoque en el panel1 después de mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            panel1.requestFocusInWindow();
        });
    }

     private void registrarEnfermero() {
    	 ventanaEmergente = new JFrame("Registro de enfermero");
     	 ventanaEmergente.setSize(700, 537);
         ventanaEmergente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         ventanaEmergente.setLocationRelativeTo(null);
         ventanaEmergente.setResizable(false);
         ventanaEmergente.setLayout(new GridLayout(1, 3));
         ventanaEmergente.setVisible(true);
         ventanaEmergente.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//Para que al cerrar la ventana emergente no se cierre la ventana principal
         Ventana.setVisible(false);
         
         ventanaEmergente.addWindowListener(new WindowAdapter() {
             @Override
             public void windowClosing(WindowEvent e) {
             	Ventana.setVisible(true);
             }
         });
         
         JPanel panel1 = new JPanel();
         panel1.setLayout(new GridBagLayout());

         // Crear un nuevo objeto GridBagConstraints para cada componente
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.anchor = GridBagConstraints.WEST;
         gbc.insets = new Insets(20, 20, 20, 20);

         // Agregar el espacio vacío
         gbc.gridy = 7;
         panel1.add(new JLabel(), gbc);

         // Agregar el campo de ID
         gbc.gridwidth = 2;
         JTextField nombre = createLabeledTextFieldPanel(panel1, "Nombre:", "primer nombre", gbc, 2);
         gbc.gridwidth = 2;
         JTextField apellido = createLabeledTextFieldPanel(panel1, "Apellido:", "primer apellido", gbc, 3); 
         gbc.gridwidth = 1;
         JComboBox<String> tipoDocumentoEnfermero = createLabeledComboBox("Tipo de documento:", comboBoxOptions, panel1, gbc, 4);
         gbc.gridwidth = 1;
         JTextField noDocumentoEnfermero = createLabeledTextFieldPanel(panel1, "no. Documento", "documento", gbc, 4); 
         gbc.gridwidth = 2;
         JTextField grado = createLabeledTextFieldPanel(panel1, "Grado:", "grado de enfermeria", gbc, 5);
         
         // Agregar el campo de Contraseña
         JTextField contraseña = createPasswordField(panel1, "Contraseña", gbc, 6);

      // Agregar el botón "Registrar"
         gbc.gridx = 0;
         gbc.gridy = 7; 
         gbc.gridwidth = 2; // Ocupar 2 celdas horizontales
         gbc.anchor = GridBagConstraints.CENTER;
         btnGuardar = new JButton("Registrar");
         btnGuardar.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e) {
 				if (nombre.getText().equals("primer nombre") || apellido.getText().equals("primer apellido") || tipoDocumentoEnfermero.getSelectedItem() == null || noDocumentoEnfermero.getText().equals("documento") || grado.getText().equals("grado") || contraseña.getText().equals("Contraseña")) {
 					JOptionPane.showMessageDialog(Ventana, "Debe completar todos los campos de registro.", "Error", JOptionPane.ERROR_MESSAGE);
 				}else {
 					
 					// Generar el ID aleatorio
 			        int idEnfermero = generateRandomID();
 			        Enfermero enfermero = new Enfermero(
 			        		idEnfermero,
 			        		nombre.getText(), 
 			        		apellido.getText(),
 			        		grado.getText(),
 			        		new Documentacion(tipoDocumentoEnfermero.getSelectedItem().toString(), noDocumentoEnfermero.getText()),
 			        		contraseña.getText()
 			        		);
 			        
 			        
 			        // Llamar al método btnRegistroMedico pasando la instancia de Medico y los demás campos
 			        btnRegistroEnfermero(enfermero, nombre, apellido, tipoDocumentoEnfermero, noDocumentoEnfermero, contraseña);				
 				}
 				
 			}

			
         	
         });
         panel1.add(btnGuardar, gbc);
         
         ventanaEmergente.add(panel1);
         
         JPanel panel2 = new JPanel();
         panel2.setLayout(new BorderLayout());
         ImageIcon imagen = new ImageIcon("Imagenes/LogoHospital.png");
         JLabel lblImagen = new JLabel(imagen);
         lblImagen.setPreferredSize(new Dimension(imagen.getIconWidth(), imagen.getIconHeight()));       
         panel2.add(lblImagen);
         ventanaEmergente.add(panel2);
         
      // Solicitar el enfoque en el panel1 después de mostrar la ventana
         SwingUtilities.invokeLater(() -> {
             panel1.requestFocusInWindow();
         });
	}


	
	
	 public static int generateRandomID() {
	        // rango de valores para el ID
	        int minValue = 10000;
	        int maxValue = 99999;

	        // instancia de Random
	        Random random = new Random();

	        // Genera un número aleatorio dentro del rango especificado
	        int generatedID = random.nextInt(maxValue - minValue + 1) + minValue;

	        return generatedID;
	    }
	
	 private void btnRegistroMedico(Medico medico, JTextField nombreMedico, JTextField apellidoMedico, JComboBox<String> tipoDocumentoMedico, JTextField noDocuementoMedico, JTextField exequatur, JTextField especializacion, JTextField contraseñaMedico) {
		 Documentacion documentoValue = medico.getDocumento();
		    int idMedico = medico.getIdMedico();
		    String exequaturValue = medico.getExequatur();
		    String especializacionValue = medico.getEspecializacion();
		    String nombreValue = medico.getNombre();
		    String apellidoValue = medico.getApellido();
		    String tipoDocumento = documentoValue.getTipo();
		    String noDocumento = documentoValue.getNoDocumento();
		    String contraseñaValue = medico.getContraseña();
		    
		    if (esEntero(noDocumento) && esEntero(exequaturValue)) {
		    medico.setIdMedico(idMedico);
		    medico.setNombre(nombreValue);
		    medico.setApellido(apellidoValue);
		    medico.setDocumento(documentoValue);
		    medico.setExequatur(exequaturValue);
		    medico.setEspecializacion(especializacionValue);
		    medico.setContraseña(contraseñaValue);
		    
		    MedicoDAO medicoDAO = new MedicoDAO();
			    if (medicoDAO.agregarMedico(medico) == 0) {
			    	JOptionPane.showMessageDialog(ventanaEmergente, "El ID del nuevo medico es: "+medico.getIdMedico());
			    	ventanaEmergente.dispose();
					Ventana.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(ventanaEmergente, "El numero de documento o el exequatur ya existen en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
		    } else {
		    	JOptionPane.showMessageDialog(ventanaEmergente, "El numero de documento y el exequatur solo aceptan valores numericos enteros.", "Error", JOptionPane.ERROR_MESSAGE);
		    } 
		}
	 
	 private void btnRegistroEnfermero(Enfermero enfermero, JTextField nombre, JTextField apellido,JComboBox<String> tipoDocumento, JTextField noDocumento, JTextField contraseña) {
		 Documentacion documentoValue = enfermero.getDocumento();
		    int idEnfermero = enfermero.getIdEnferma();
		    String gradoValue = enfermero.getGrado();
		    String nombreValue = enfermero.getNombre();
		    String apellidoValue = enfermero.getApellido();
		    String tipoDocumentoEnfetemero = documentoValue.getTipo();
		    String noDocumentoEnfermero = documentoValue.getNoDocumento();
		    String contraseñaValue = enfermero.getContraseña();
		    
		    if (esEntero(noDocumentoEnfermero)) {
		    enfermero.setIdEnferma(idEnfermero);
		    enfermero.setNombre(nombreValue);
		    enfermero.setApellido(apellidoValue);
		    enfermero.setDocumento(documentoValue);
		    enfermero.setGrado(gradoValue);
		    enfermero.setContraseña(contraseñaValue);
		    
		    EnfermeroDAO enfermeroDAO = new EnfermeroDAO();
			    if (enfermeroDAO.agregarEnfermero(enfermero) == 0) {
			    	JOptionPane.showMessageDialog(ventanaEmergente, "El ID del nuevo medico es: "+enfermero.getIdEnferma());
			    	ventanaEmergente.dispose();
					Ventana.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(ventanaEmergente, "El numero de documento o el exequatur ya existen en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
				}
		    } else {
		    	JOptionPane.showMessageDialog(ventanaEmergente, "El numero de documento solo acepta valores numericos enteros.", "Error", JOptionPane.ERROR_MESSAGE);
		    }
			
		}

	public static boolean esEntero(String cadena) {
	        try {
	            Long.parseLong(cadena);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
	
	private ButtonGroup createButtonGroupPanel(JPanel panel, String[] buttonLabels, GridBagConstraints gbc, int gridy) {
	    ButtonGroup buttonGroup = new ButtonGroup();
	    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); 

	    for (int i = 0; i < buttonLabels.length; i++) {
	        JRadioButton radioButton = new JRadioButton(buttonLabels[i]);
	        radioButton.setActionCommand(buttonLabels[i]);
	        buttonGroup.add(radioButton);
	        buttonPanel.add(radioButton);

	        radioButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                selectedRadioButton = radioButton;
	            }
	        });
	        
	        if (buttonLabels[i].equals("Medico")) {
	            radioButton.setSelected(true);  // Seleccionar el botón "Medico" por defecto
	            selectedRadioButton = radioButton;  // Establecerlo como seleccionado
	        }
	    }
	    
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    gbc.weightx = 1.0;

	    panel.add(buttonPanel, gbc);
	    gbc.gridy++;

	    return buttonGroup;
	}
	
	private static String getPasswordFromInputDialog() {
        JPasswordField passwordField = new JPasswordField();
        int option = JOptionPane.showOptionDialog(
                null,
                passwordField,
                "Ingrese su contraseña:",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null);

       
        if (option == JOptionPane.OK_OPTION) {
            return new String(passwordField.getPassword());
        }
        return null;
	}
   
	private JTextField createLabeledTextFieldPanel(JPanel panel, String labelText, String placeholder, GridBagConstraints gbc, int gridy) {
		JPanel labeledTextFieldPanel = new JPanel(new BorderLayout());
		
		JTextField textField = new JTextField(20);
		textField.setText(placeholder);
		textField.setForeground(Color.GRAY);
		
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1.0;
		textField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent evt) {
				if (textField.getText().equals(placeholder)) {
					textField.setText("");
					textField.setForeground(Color.BLACK);
				}
			}
			
			public void focusLost(FocusEvent evt) {
				if (textField.getText().isEmpty()) {
					textField.setText(placeholder);
					textField.setForeground(Color.GRAY);
				}
			}
		});
		
		JLabel label = new JLabel(labelText);
		label.setForeground(Color.BLACK);
		
		
		labeledTextFieldPanel.add(label, BorderLayout.NORTH);
		labeledTextFieldPanel.add(textField, BorderLayout.CENTER);
		
		gbc.gridy = gridy;
		panel.add(labeledTextFieldPanel, gbc);
		
		return textField;
	}
	
	private JPasswordField createPasswordField(JPanel panel, String placeholder, GridBagConstraints gbc, int gridy) {
		JPanel passwordPanel = new JPanel(new BorderLayout());
		
		JPasswordField passwordField = new JPasswordField(20);
		passwordField.setText(placeholder);
		passwordField.setForeground(Color.GRAY);
		passwordField.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent evt) {
				char[] password = passwordField.getPassword();
				String passwordString = new String(password);
				if (passwordString.equals(placeholder)) {
					passwordField.setText("");
					passwordField.setForeground(Color.BLACK);
				}
			}
			
			public void focusLost(FocusEvent evt) {
				char[] password = passwordField.getPassword();
				String passwordString = new String(password);
				if (passwordString.isEmpty()) {
					passwordField.setText(placeholder);
					passwordField.setForeground(Color.GRAY);
				}
			}
		});
		
		gbc.gridy = gridy;
		panel.add(passwordField, gbc);
		
		JLabel passwordLabel = new JLabel("Contraseña:");
		passwordLabel.setForeground(Color.BLACK);
		
		passwordPanel.add(passwordLabel, BorderLayout.NORTH);
		passwordPanel.add(passwordField, BorderLayout.CENTER);
		
		gbc.gridy = gridy;
		panel.add(passwordPanel, gbc);
		
		return passwordField;
	}
	
	private JComboBox<String> createLabeledComboBox(String labelText, String[] options, JPanel panel, GridBagConstraints gbc, int gridy) {
	    JPanel comboBoxPanel = new JPanel(new BorderLayout());
	    
	    JComboBox<String> comboBox = new JComboBox<>(options);
	    comboBox.setSelectedIndex(-1);  // No seleccionar ningún elemento por defecto
	    
	    JLabel label = new JLabel(labelText);
	    label.setForeground(Color.BLACK);
	    
	    comboBoxPanel.add(label, BorderLayout.NORTH);
	    comboBoxPanel.add(comboBox, BorderLayout.CENTER);
	    
	    gbc.gridy = gridy;
	    panel.add(comboBoxPanel, gbc);
	    
	    return comboBox;
	}
}


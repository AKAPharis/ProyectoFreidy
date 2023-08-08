package gui;

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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;


public class Builder {

	private JFrame Ventana;
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField textGenerar;
	private JLabel lbl6;
	private JButton btnGuardar;


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

        // Agregar el espacio vacío
        gbc.gridy = 7;
        panel1.add(new JLabel(), gbc);

        // Agregar el campo de ID
        gbc.gridy = 8; 
        createLabeledTextFieldPanel(panel1, "ID:", "insertar ID", gbc, 2);

        // Agregar el campo de Contraseña
        gbc.gridy = 9; // Cambia este valor según el diseño deseado
        createPasswordField(panel1, "Contraseña", gbc, 3);

        // Agregar el JLabel de registro
        gbc.gridy = 10; 
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

        // Agregar el botón "Iniciar sesión"
        gbc.gridy = 4; // Cambia este valor según el diseño deseado
        gbc.gridwidth = 2; // Ocupar 2 celdas horizontales
        gbc.anchor = GridBagConstraints.CENTER;
        btnGuardar = new JButton("Iniciar sesión");
        panel1.add(btnGuardar, gbc);
        
        // Agregar el panel1 a la ventana
        Ventana.add(panel1);
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        ImageIcon imagen = new ImageIcon("Imagenes/city.png");
        JLabel lblImagen = new JLabel(imagen);
        lblImagen.setPreferredSize(new Dimension(imagen.getIconWidth(), imagen.getIconHeight()));       
        panel2.add(lblImagen);
        Ventana.add(panel2);
        
     // Solicitar el enfoque en el panel1 después de mostrar la ventana
        SwingUtilities.invokeLater(() -> {
            panel1.requestFocusInWindow();
        });
    

    }

	private JPanel createLabeledTextFieldPanel(JPanel panel, String labelText, String placeholder, GridBagConstraints gbc, int gridy) {
	    JPanel labeledTextFieldPanel = new JPanel(new BorderLayout());

	    JTextField textField = new JTextField(20);
	    textField.setText(placeholder);
	    textField.setForeground(Color.GRAY);
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

	    return labeledTextFieldPanel;
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
    
    public void Registro() {
    	SwingUtilities.invokeLater(() -> {
            String password = getPasswordFromInputDialog();
            if ("admin123".equals(password)) { // Utiliza equals para comparar cadenas
                JOptionPane.showMessageDialog(null, "Contraseña correcta :)");
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña insertada no es la correcta", "Incorrecta", JOptionPane.ERROR_MESSAGE);
            }
        });
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
    
    
}

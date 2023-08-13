package db.dao;

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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;


import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JCalendar;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class PruebaGUI {

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

      

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaGUI window = new PruebaGUI();
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
	public PruebaGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		 frame = new JFrame("Hospital MeDick");
		 frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
         ImageIcon imageIcon = new ImageIcon("ima/Cruz.png");
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
         
	        GridBagConstraints gbcButtonsPanel = new GridBagConstraints();

	      
	        labelR = createButtonLabel("Registrarse");
	        labelR.setFont(new Font("Arial", Font.BOLD, 20));
	        gbcButtonsPanel.gridx = 1; // Coloca en la misma columna que el label1
	        gbcButtonsPanel.gridy = 0; // Siguiente fila
	        gbcButtonsPanel.anchor = GridBagConstraints.FIRST_LINE_START; // Alinea a la esquina superior izquierda
	        gbcButtonsPanel.insets = new Insets(0, 1230, 0, 20); // Ajusta los márgenes
	        gbcButtonsPanel.weightx = 0.0; // Evita que el buttonsPanel se expanda horizontalmente
	        gbcButtonsPanel.weighty = 0.0;
	        
	        
	        labelI = createButtonLabel("Iniciar Sesión");
	        labelI.setFont(new Font("Arial", Font.BOLD, 20));
	        gbcButtonsPanel.gridx = 1; // Coloca en la misma columna que el label1
	        gbcButtonsPanel.gridy = 0; // Siguiente fila
	        gbcButtonsPanel.anchor = GridBagConstraints.FIRST_LINE_START; // Alinea a la esquina superior izquierda
	        gbcButtonsPanel.insets = new Insets(50, 1210, 0, 0); // Ajusta los márgenes
	        gbcButtonsPanel.weightx = 0.0; // Evita que el buttonsPanel se expanda horizontalmente
	        gbcButtonsPanel.weighty = 0.0;
	        
       

    
   

       
	     panel2 = new JPanel();
	     panel2.setLayout(new GridBagLayout());
	     GridBagConstraints gbcImage22 = new GridBagConstraints();
         ImageIcon imageIcon22 = new ImageIcon("ima/Citas.jpg");
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
				private JButton btn1;

				@Override
        	    public void mouseEntered(MouseEvent e) {
        	        // Cambiar la imagen al pasar el mouse por encima
        	        ImageIcon newImageIcon22 = new ImageIcon("ima/Citas2.jpg");
        	        Image newScaledImage22 = newImageIcon22.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        	        ImageIcon newScaledImageIcon22 = new ImageIcon(newScaledImage22);
        	        imageLabel22.setIcon(newScaledImageIcon22);
        	    }

        	    @Override
        	    public void mouseExited(MouseEvent e) {
        	        // Restaurar la imagen original al quitar el mouse
        	        ImageIcon originalImageIcon22 = new ImageIcon("ima/Citas.jpg");
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
        	    		newFrame.getContentPane().setLayout(null);
        	            
        	    	// Cambia este valor según tus necesidades
        	    		
        	    		model = new DefaultTableModel();
        	    		model.addColumn("");	
        	    		model.addColumn("");
        	    		model.addColumn("Dia");	
        	    		model.addColumn("Semana");
        	    		model.addColumn("Orden del dia");
                        model.addRow(new Object[]{"09:00"});
                        model.addRow(new Object[]{"10:00"});
                        model.addRow(new Object[]{"11:00"});
                        model.addRow(new Object[]{"12:p.m."});
                        model.addRow(new Object[]{"01:00"});
                        model.addRow(new Object[]{"02:00"});
                        model.addRow(new Object[]{"03:00"});
                        model.addRow(new Object[]{"04:00"});
                        model.addRow(new Object[]{"05:00"});
                        model.addRow(new Object[]{"07:00"});
                        model.addRow(new Object[]{"08:00"});
                        model.addRow(new Object[]{"09:00"});
                        model.addRow(new Object[]{"10:00"});
                        model.addRow(new Object[]{"11:00"});

        	    		
        	    		 JComboBox<String> box = new JComboBox<>();
        	    	        box.setBounds(30, 70, 180, 30);
        	    	        box.addItem("Seleccione una fecha...");
        	    	        newFrame.add(box);

        	    	        JPopupMenu popupMenu = new JPopupMenu();
        	    	        JCalendar calendarBox = new JCalendar();
        	    	        popupMenu.add(calendarBox);

        	    	        box.addActionListener(new ActionListener() {
        	    	            public void actionPerformed(ActionEvent e) {
        	    	                if (box.getSelectedIndex() == 0) {
        	    	                    popupMenu.show(box, 0, box.getHeight());
        	    	                }
        	    	            }
        	    	        });
        	    		
        	   
        	    		JCalendar calendar23 = new JCalendar();
        	    		calendar23.setBounds(550, 100, 200, 200);
        	    		newFrame.add(calendar23);
        	    		
        	    		
        	    		

        	    	     class SynchronizeListener implements PropertyChangeListener {
        	    	        public void propertyChange(PropertyChangeEvent evt) {
        	    	            if (evt.getSource() instanceof JCalendar) {
        	    	                JCalendar sourceCalendar = (JCalendar) evt.getSource();
        	    	                JCalendar targetCalendar;

        	    	                if (sourceCalendar == calendar23) {
        	    	                    targetCalendar = calendarBox;
        	    	                } else {
        	    	                    targetCalendar = calendar23;
        	    	                }

        	    	                targetCalendar.setCalendar(sourceCalendar.getCalendar());
        	    	            }
        	    	        }
        	    	    }
        	    	    
        	    	    SynchronizeListener synchronizeListener = new SynchronizeListener();

    	    	        calendar23.addPropertyChangeListener("calendar", synchronizeListener);
    	    	        calendarBox.addPropertyChangeListener("calendar", synchronizeListener);

        	    	    
        	    		JTable citas1 = new JTable(model);
        	    		JScrollPane pane = new JScrollPane();
        	    		pane.setBounds(30, 100, 500, 450);
        	    		newFrame.add(pane);
        	    		pane.setViewportView(citas1);
        	    		
        	    		   citas1.setRowHeight(40);
        	    		
        	            btn = new JButton("Agregar cita");
        	            btn.setBounds(30, 20, 180, 30);
        	            btn.setFont(new Font("", Font.BOLD, 20));
        	         
        	            newFrame.add(btn);
        	            
        	            btn1 = new JButton("Imprimir");
        	            btn1.setBounds(580, 20, 180, 30);
        	            btn1.setFont(new Font("", Font.BOLD, 20));

        	            newFrame.add(btn1);
  	            

        	            
        	        }
        	    }
        	});

         
         GridBagConstraints gbcImage3 = new GridBagConstraints();
         ImageIcon imageIcon3 = new ImageIcon("ima/Medicamentos.jpg");
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
     	        ImageIcon newImageIcon4 = new ImageIcon("ima/Medicamentos2.jpg");
     	        Image newScaledImage4 = newImageIcon4.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
     	        ImageIcon newScaledImageIcon4 = new ImageIcon(newScaledImage4);
     	        imageLabel3.setIcon(newScaledImageIcon4);
     	    }

     	    @Override
     	    public void mouseExited(MouseEvent e) {
     	        // Restaurar la imagen original al quitar el mouse
     	        ImageIcon originalImageIcon = new ImageIcon("ima/Medicamentos.jpg");
     	        Image originalScaledImage = originalImageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
     	        ImageIcon originalScaledImageIcon = new ImageIcon(originalScaledImage);
     	        imageLabel3.setIcon(originalScaledImageIcon);
     	    }

     	    @Override
     	    public void mouseClicked(MouseEvent e) {
     	        if (SwingUtilities.isLeftMouseButton(e)) {
     	            // Abre la nueva ventana aquí
     	            // Por ejemplo, creando una nueva instancia de JFrame
     	            JFrame newFrame = new JFrame("Nueva Ventana");
     	            newFrame.setSize(400, 300);
     	            newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	            newFrame.setVisible(true);
     	        }
     	    }
     	});
        
         
         GridBagConstraints gbcImage5 = new GridBagConstraints();
         ImageIcon imageIcon5 = new ImageIcon("ima/Saver.png");
         Image scaledImage5 = imageIcon5.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
         ImageIcon scaledImageIcon5 = new ImageIcon(scaledImage5);
         JLabel imageLabel5 = new JLabel(scaledImageIcon5);
         gbcImage5.gridx = 0;
         gbcImage5.gridy = 0;
         gbcImage5.anchor = GridBagConstraints.LINE_START; // Align to the left
         gbcImage5.insets = new Insets(0, 600, 0, 200); // Add space to the right

         panel2.add(imageLabel5, gbcImage5);
         
         
         GridBagConstraints gbcImage7 = new GridBagConstraints();
         ImageIcon imageIcon7 = new ImageIcon("ima/Documentacion.png");
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
     	        ImageIcon newImageIcon7 = new ImageIcon("ima/Documentacion2.png");
     	        Image newScaledImage7 = newImageIcon7.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
     	        ImageIcon newScaledImageIcon7 = new ImageIcon(newScaledImage7);
     	        imageLabel7.setIcon(newScaledImageIcon7);
     	    }

     	    @Override
     	    public void mouseExited(MouseEvent e) {
     	        // Restaurar la imagen original al quitar el mouse
     	        ImageIcon originalImageIcon8 = new ImageIcon("ima/Documentacion.png");
     	        Image originalScaledImage8 = originalImageIcon8.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
     	        ImageIcon originalScaledImageIcon8 = new ImageIcon(originalScaledImage8);
     	        imageLabel7.setIcon(originalScaledImageIcon8);
     	    }

     	    @Override
     	    public void mouseClicked(MouseEvent e) {
     	        if (SwingUtilities.isLeftMouseButton(e)) {
     	            // Abre la nueva ventana aquí
     	            // Por ejemplo, creando una nueva instancia de JFrame
     	            JFrame newFrame = new JFrame("Nueva Ventana");
     	            newFrame.setSize(400, 300);
     	            // Agrega componentes a la nueva ventana si es necesario
     	            newFrame.setVisible(true);
     	        }
     	    }
     	});
               
         
         GridBagConstraints gbcImage9 = new GridBagConstraints();
         ImageIcon imageIcon9 = new ImageIcon("ima/Componente2.png");
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

	private JLabel createButtonLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(JLabel.RIGHT); // Align right
        label.setForeground(Color.BLACK);
        
        label.addMouseListener(new MouseAdapter() {
        	
        	public void mouseClicked(MouseEvent e) {
	            if (SwingUtilities.isLeftMouseButton(e)) {
	                // Abre la nueva ventana aquí
	                // Por ejemplo, creando una nueva instancia de JFrame
	                JFrame newFrame = new JFrame("Nueva Ventana");
	                newFrame.setSize(400, 300);
	                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                
	                newFrame.setVisible(true);
	            }
	        }
        	
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setForeground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setForeground(Color.BLACK);
            }
        });
        return label;
    } 
	
	
	private JLabel createMenuLabel(String text) {
	    JLabel label = new JLabel(text);
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setForeground(Color.BLACK);

	    label.addMouseListener(new MouseAdapter() {
	        private JPopupMenu popupMenu;
	        private JLabel selectedLabel;

	        @Override
	        public void mouseEntered(MouseEvent e) {
	            label.setForeground(Color.BLUE);
	            showMenu();
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            if (!label.equals(selectedLabel)) {
	                label.setForeground(Color.BLACK);
	            }
	        }

	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (SwingUtilities.isLeftMouseButton(e)) {
	                if (selectedLabel != null) {
	                    selectedLabel.setForeground(Color.BLACK);
	                }
	                selectedLabel = label;
	                label.setForeground(Color.BLUE);
	                showMenu();
	            }
	        }

	        private void showMenu() {
	            if (popupMenu == null) {
	                popupMenu = new JPopupMenu();
	                JMenuItem item1 = new JMenuItem("Sobre MeDick");
	                JMenuItem item2 = new JMenuItem("Novedades y Noticias");
	                item1.setBackground(Color.gray);
	                
	                item2.setBackground(Color.gray);

	              
	                item1.addActionListener(new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        // Abre una nueva ventana con el contenido correspondiente
	                        JFrame newFrame = new JFrame("Sobre MeDick");
	                        newFrame.setSize(400, 300);
	                        // Agrega componentes a la nueva ventana si es necesario
	                        newFrame.setVisible(true);
	                    }
	                });

	                item2.addActionListener(new ActionListener() {
	                    @Override
	                    public void actionPerformed(ActionEvent e) {
	                        // Abre una nueva ventana con el contenido correspondiente
	                        JFrame newFrame = new JFrame("Novedades y Noticias");
	                        newFrame.setSize(400, 300);
	                        // Agrega componentes a la nueva ventana si es necesario
	                        newFrame.setVisible(true);
	                    }
	                });

	                popupMenu.add(item1);
	                popupMenu.add(item2);
	            }

	            popupMenu.show(label, label.getWidth() / 2, label.getHeight());
	        }
	    });

	    return label;
	}



	
	
	private JLabel createClickableLabel(String text) {
	    JLabel label = new JLabel(text);
	    label.setHorizontalAlignment(JLabel.CENTER);
	    label.setForeground(Color.BLACK);

	    label.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            if (SwingUtilities.isLeftMouseButton(e)) {
	                // Abre la nueva ventana aquí
	                // Por ejemplo, creando una nueva instancia de JFrame
	                JFrame newFrame = new JFrame("Nueva Ventana");
	                newFrame.setSize(400, 300);
	                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	                newFrame.setVisible(true);
	            }
	        }

	        @Override
	        public void mouseEntered(MouseEvent e) {
	            label.setForeground(Color.BLUE);
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            label.setForeground(Color.BLACK);
	        }
	    });

	    return label;
	}
	
	private JLabel abajo(String text) {
		
		  JLabel label = new JLabel(text);
		    label.setHorizontalAlignment(JLabel.CENTER);
		    label.setForeground(Color.BLACK);
		    
		    label.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		        	  SwingUtilities.invokeLater(new Runnable() {
		                  @Override
		                  public void run() {
		                      Rectangle rect = panel4.getBounds();
		                      scrollPane.getViewport().scrollRectToVisible(rect);
		                  }
		        	  });
		        }

		        @Override
		        public void mouseEntered(MouseEvent e) {
		            label.setForeground(Color.BLUE);
		        }

		        @Override
		        public void mouseExited(MouseEvent e) {
		            label.setForeground(Color.BLACK);
		        }
		    });
		    
		    return label;
		
	}
	
	private JLabel abajo2(String text) {
		
		  JLabel label = new JLabel(text);
		    label.setHorizontalAlignment(JLabel.CENTER);
		    label.setForeground(Color.BLACK);
		    
		    label.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		        	  SwingUtilities.invokeLater(new Runnable() {
		                  @Override
		                  public void run() {
		                      Rectangle rect = panel3.getBounds();
		                      scrollPane.getViewport().scrollRectToVisible(rect);
		                  }
		        	  });
		        }

		        @Override
		        public void mouseEntered(MouseEvent e) {
		            label.setForeground(Color.BLUE);
		        }

		        @Override
		        public void mouseExited(MouseEvent e) {
		            label.setForeground(Color.BLACK);
		        }
		    });
		    
		    return label;
		
	}

	
	}
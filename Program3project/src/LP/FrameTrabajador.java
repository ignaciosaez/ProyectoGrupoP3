package LP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrameTrabajador extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menu;
	private JMenu MenuEntrar;
	private JMenu MenuRegistrarse;
	private JTextField texto;
	private JMenuItem itemEntrarCliente;
	private JMenuItem itemEntrarTrabajador;
	private JMenuItem itemRegistrarcliente;;
	private JLabel fondopantalla;
	
	public FrameTrabajador() 
	{	
		AtributosVentana();
	}
	
	private void AtributosVentana()
	{
		
		
		setForeground(Color.BLACK);
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 549, 453);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(500, 500);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu = new JMenuBar();
		setJMenuBar(menu);
		
		
		
		MenuEntrar = new JMenu("Catalogo de productos");
		MenuEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		menu.add(MenuEntrar);
		
		MenuEntrar.setForeground(Color.BLACK);
		
		itemEntrarCliente = new JMenuItem("Insertar Productos");
		itemEntrarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemEntrarCliente.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent ev) 
		        
		        {
		        	FrameInsertarProducto obj= new FrameInsertarProducto();
		        	obj.setVisible(true);
		        }
		    });
		
		MenuEntrar.add(itemEntrarCliente);
		
		itemEntrarTrabajador = new JMenuItem("Eliminar productos");		
		itemEntrarTrabajador.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		MenuEntrar.add(itemEntrarTrabajador);
		
		MenuRegistrarse = new JMenu("DATOS TRABAJADORES");
		MenuRegistrarse.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		MenuRegistrarse.setForeground(Color.BLUE);
		menu.add(MenuRegistrarse);
		
		itemRegistrarcliente = new JMenuItem("Trabajadores");
		itemRegistrarcliente.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemRegistrarcliente.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent ev) 
		        
		        {
		        	 
		        }
		    });
		
		MenuRegistrarse.add(itemRegistrarcliente);
		
		
	
		
		
		
		this.setVisible(true);
	}

}

	
	
	
	
	
	


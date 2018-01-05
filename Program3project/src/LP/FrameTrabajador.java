package LP;

import static COMUN.constantesActionCommand.BUTTON_CANCELAR;

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

public class FrameTrabajador extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menu;
	private JMenu MenuEntrar;
	private JMenu MenuRegistrarse;
	private JButton btnNewButtonCancelar;
	private JTextField texto;
	private JMenuItem itemInsertarProductos;
	private JMenuItem itemEntrarEliminarProductos;
	private JMenuItem itemEntrarModificarProductos;
	private JMenuItem itemVerProductos;
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
		
		btnNewButtonCancelar = new JButton("VOLVER ATRÁS");
		btnNewButtonCancelar.setForeground(Color.DARK_GRAY);
		btnNewButtonCancelar.setBackground(Color.RED);
		btnNewButtonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonCancelar.setBounds(1680, 860, 198, 48);
		contentPane.add(btnNewButtonCancelar);
		btnNewButtonCancelar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonCancelar.addActionListener(this);
		
		
		
		MenuEntrar = new JMenu("Catalogo de productos");
		MenuEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		menu.add(MenuEntrar);
		
		MenuEntrar.setForeground(Color.BLACK);
		
		itemVerProductos = new JMenuItem("Ver productos");
		itemVerProductos.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemVerProductos.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent ev) 
		        
		        {
		        	FrameVerProductos objV= new FrameVerProductos();
		        	objV.setVisible(true);
		        }
		    });
		
		MenuEntrar.add(itemVerProductos);
		
		itemInsertarProductos = new JMenuItem("Insertar Productos");
		itemInsertarProductos.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemInsertarProductos.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent ev) 
		        
		        {
		        	FrameInsertarProducto obj= new FrameInsertarProducto();
		        	obj.setVisible(true);
		        }
		    });
		
		MenuEntrar.add(itemInsertarProductos);
		
		itemEntrarModificarProductos = new JMenuItem("Modificar producto");		
		itemEntrarModificarProductos.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemEntrarModificarProductos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				FrameModificarProducto obj= new FrameModificarProducto();
				obj.setVisible(true);
				
			}
		});
		MenuEntrar.add(itemEntrarModificarProductos);
		
		
		itemEntrarEliminarProductos = new JMenuItem("Eliminar producto");		
		itemEntrarEliminarProductos.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemEntrarEliminarProductos.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent arg0) 
			{
				FrameEliminarProducto obj= new FrameEliminarProducto();
				obj.setVisible(true);
				
			}
		});
		MenuEntrar.add(itemEntrarEliminarProductos);
		
		
		
		fondopantalla = new JLabel("");
		fondopantalla.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/70030553-shop-wallpapers.jpg")));
		fondopantalla.setBounds(150,0,3000,1000 );
		fondopantalla.setOpaque(false);
		getContentPane().add(fondopantalla);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand())
		{
			
			
			case BUTTON_CANCELAR: this.dispose();
			break;
		} 
	}

}

	
	
	
	
	
	


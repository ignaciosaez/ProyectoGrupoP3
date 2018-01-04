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

public class FrameCliente extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menu;
	private JMenu MenuEntrar;
	private JMenu MenuCarrito;
	private JTextField texto;
	private JMenuItem itemEntrarCliente;
	private JMenuItem itemEntrarComprar;
	private JMenuItem itemVerProductos;;
	private JLabel fondopantalla;
	
	String usuario;
	
	public FrameCliente( String usuario) 
	{	
		this.usuario=usuario;
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
		
	
		
		itemEntrarComprar = new JMenuItem("Comprar productos");		
		itemEntrarComprar.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemEntrarComprar.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				FrameCompraCliente obj= new FrameCompraCliente(usuario);
				obj.setVisible(true);
				// TODO Auto-generated method stub
				
			}
		});
		MenuEntrar.add(itemEntrarComprar);
		
		MenuCarrito = new JMenu("CARRITO DE COMPRA");
		MenuCarrito.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		MenuCarrito.setForeground(Color.BLUE);
		menu.add(MenuCarrito);
		
		itemVerProductos = new JMenuItem("Ver productos comprados");
		itemVerProductos.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemVerProductos.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent ev) 
		        
		        {
		        	FrameCarritoCompra obj= new FrameCarritoCompra();
		        	obj.setVisible(true);
		        }
		    });
		
		MenuCarrito.add(itemVerProductos);
		
	}
	
/*
		fondopantalla = new JLabel("");
		fondopantalla.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/logodeusto.jpg")));
		fondopantalla.setBounds(0,0,1000,1000 );
		fondopantalla.setOpaque(false);
		fondopantalla.setMaximumSize(getMaximumSize());
		getContentPane().add(fondopantalla);
		
		
		this.setVisible(true);
	}
*/
		
}

	
	
	
	
	
	


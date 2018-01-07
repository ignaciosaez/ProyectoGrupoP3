package LP;

import static COMUN.constantesActionCommand.BUTTON_CANCELAR;
import static COMUN.constantesActionCommand.BUTTON_ELIMINARDELCARRITO;

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

import org.edisoncor.gui.varios.ClockFace;

/**
 * Clase para la creación de la ventana que nos permite visualizar las opciones que tiene el cliente una vez se haya registrado con éxito. Es decir, ver el catalogo de producto o el carrito de compra.
 * @author Alumno
 */

public class FrameCliente extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menu;
	private JMenu MenuEntrar;
	private JMenu MenuCarrito;
	private JMenu MenuVolver;
	private JButton btnNewButtonCancelar;
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
		
		
		System.out.println(usuario);
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
		        	FrameCarritoCompra obj= new FrameCarritoCompra(usuario);
		        	obj.setVisible(true);
		        }
		    });
		
		MenuCarrito.add(itemVerProductos);
		
		btnNewButtonCancelar = new JButton("VOLVER ATRÁS");
		btnNewButtonCancelar.setForeground(Color.DARK_GRAY);
		btnNewButtonCancelar.setBackground(Color.RED);
		btnNewButtonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonCancelar.setBounds(1680, 860, 198, 48);
		contentPane.add(btnNewButtonCancelar);
		btnNewButtonCancelar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonCancelar.addActionListener(this);
		
		fondopantalla = new JLabel("");
		fondopantalla.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/70030553-shop-wallpapers.jpg")));
		fondopantalla.setBounds(75,0,3000,1000 );
		fondopantalla.setOpaque(false);
		getContentPane().add(fondopantalla);
		
		ClockFace clockFace = new ClockFace();
		clockFace.setBounds(1720, 20, 150, 150);
		contentPane.add(clockFace);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
			
			
			case BUTTON_CANCELAR: this.dispose();
			break;
		} 
	}
	

		
}

	
	
	
	
	
	


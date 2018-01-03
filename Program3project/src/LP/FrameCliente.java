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
	private JMenu MenuRegistrarse;
	private JTextField texto;
	private JMenuItem itemEntrarCliente;
	private JMenuItem itemEntrarComprar;
	private JMenuItem itemRegistrarcliente;;
	private JLabel fondopantalla;
	
	public FrameCliente() 
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
		
	
		
		itemEntrarComprar = new JMenuItem("Comprar productos");		
		itemEntrarComprar.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemEntrarComprar.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		MenuEntrar.add(itemEntrarComprar);
		
		MenuRegistrarse = new JMenu("CARRITO DE COMPRA");
		MenuRegistrarse.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		MenuRegistrarse.setForeground(Color.BLUE);
		menu.add(MenuRegistrarse);
		
		itemRegistrarcliente = new JMenuItem("Ver productos comprados");
		itemRegistrarcliente.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemRegistrarcliente.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent ev) 
		        
		        {
		        	FrameRegistrarCliente obj= new FrameRegistrarCliente();
		    		obj.setVisible(true); 
		        }
		    });
		
		MenuRegistrarse.add(itemRegistrarcliente);
		
		
	

		fondopantalla = new JLabel("");
		fondopantalla.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/logodeusto.jpg")));
		fondopantalla.setBounds(0,0,1000,1000 );
		fondopantalla.setOpaque(false);
		fondopantalla.setMaximumSize(getMaximumSize());
		getContentPane().add(fondopantalla);
		
		
		this.setVisible(true);
	}

}

	
	
	
	
	
	


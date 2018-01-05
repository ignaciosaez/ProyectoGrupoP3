package LP;

//import static COMUN.Definiciones.CMD_COMPRABILLETE;

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

import org.edisoncor.gui.varios.ClockDigital;
import org.edisoncor.gui.varios.ClockFace;

public class PaginaPrincipal extends JFrame 
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
	
	//recogeremos el usuario para luego en la ventana de comprar producto podamos tenerlo y guardar asi su transacción
	
	
	public PaginaPrincipal() 
	{	
		
		AtributosVentana();
	}
	
	private void AtributosVentana()
	{
		
		
		setForeground(Color.BLACK);
		setTitle("ACCESO AL PROGRAMA");
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
		
		
		
		MenuEntrar = new JMenu("ENTRAR");
		MenuEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 40));
		menu.add(MenuEntrar);
		
		MenuEntrar.setForeground(Color.RED);
		
		itemEntrarCliente = new JMenuItem("Entrar como cliente");
		itemEntrarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		itemEntrarCliente.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent ev) 
		        
		        {
		        	FrameEntrarCliente obj= new FrameEntrarCliente();
		    		obj.setVisible(true); 
		        }
		    });
		
		MenuEntrar.add(itemEntrarCliente);
		
		itemEntrarTrabajador = new JMenuItem("Entrar como trabajador");		
		itemEntrarTrabajador.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		itemEntrarTrabajador.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent ev) 
	        
	        {
	        	FrameEntrarTrabajador obj= new FrameEntrarTrabajador();
	    		obj.setVisible(true); 
	        }
	    });
		MenuEntrar.add(itemEntrarTrabajador);
		
		MenuRegistrarse = new JMenu("REGISTRASE");
		MenuRegistrarse.setFont(new Font("Segoe UI", Font.PLAIN, 40));
		MenuRegistrarse.setForeground(Color.BLUE);
		menu.add(MenuRegistrarse);
		
		itemRegistrarcliente = new JMenuItem("Registrarse / crear nuevo usuario");
		itemRegistrarcliente.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		itemRegistrarcliente.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent ev) 
		        
		        {
		        	FrameRegistrarCliente obj= new FrameRegistrarCliente();
		    		obj.setVisible(true); 
		        }
		    });
		
		MenuRegistrarse.add(itemRegistrarcliente);
		
		fondopantalla = new JLabel("");
		fondopantalla.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/70030553-shop-wallpapers.jpg")));
		fondopantalla.setBounds(75,0,3000,1000 );
		fondopantalla.setOpaque(false);
		getContentPane().add(fondopantalla);
		
		JTextArea txtrBienevnidoAAmazon = new JTextArea();
		txtrBienevnidoAAmazon.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 60));
		txtrBienevnidoAAmazon.setText("Welcome to AMAZON DEUSTO SHOP!!!");
		txtrBienevnidoAAmazon.setBackground(Color.gray);
		txtrBienevnidoAAmazon.setBounds(75, 30, 1325, 70);
		contentPane.add(txtrBienevnidoAAmazon);
		
		ClockFace clockFace = new ClockFace();
		clockFace.setBounds(1720, 20, 150, 150);
		contentPane.add(clockFace);
		
		
		
		this.setVisible(true);
	}

}

	
	
	
	
	
	


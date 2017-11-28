package LP;

//import static COMUN.Definiciones.CMD_COMPRABILLETE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

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


import static COMUN.constantesActionCommand.*;
public class PaginaPrincipal extends JFrame  implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menu;
	private JMenu MenuEntrar;
	private JMenu MenuRegistrarse;
	private JTextField texto;
	private JMenuItem itemEntrarCliente;
	private JMenuItem itemEntrarTrabajador;

	private JLabel fondopantalla;
	
	public PaginaPrincipal() 
	{	
		AtributosVentana();
	}
	
	private void AtributosVentana()
	{
		
		
		setForeground(Color.BLACK);
		setTitle("AMAZON DEUSTO-ACCESO AL PROGRAMA");
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
		MenuEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		menu.add(MenuEntrar);
		
		MenuEntrar.setForeground(Color.BLACK);
		
		itemEntrarCliente = new JMenuItem("Entrar como cliente");
		itemEntrarCliente.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemEntrarCliente.setActionCommand(ENTRAR_CLIENTE);
		
		itemEntrarCliente.addActionListener(this);
		MenuEntrar.add(itemEntrarCliente);
		
		itemEntrarTrabajador = new JMenuItem("Entrar como trabajador");	
		itemEntrarTrabajador.setFont(new Font("Segoe UI", Font.PLAIN, 21));
		itemEntrarCliente.setActionCommand(ENTRAR_TRABAJADOR);
		itemEntrarTrabajador.addActionListener(this);
		MenuEntrar.add(itemEntrarTrabajador);
		
		MenuRegistrarse = new JMenu("REGISTRASE");
		MenuRegistrarse.setFont(new Font("Segoe UI", Font.PLAIN, 28));
		MenuRegistrarse.setForeground(Color.BLUE);
		
		menu.add(MenuRegistrarse);
		
		
		
		
		fondopantalla = new JLabel("");
		fondopantalla.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/70030553-shop-wallpapers.jpg")));
		fondopantalla.setBounds(0,0,3200,1000 );
		fondopantalla.setOpaque(false);
		getContentPane().add(fondopantalla);
		
		JTextArea txtrBienevnidoAAmazon = new JTextArea();
		txtrBienevnidoAAmazon.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 27));
		txtrBienevnidoAAmazon.setText("Bienvenido a AMAZON DEUSTO SHOP!!");
		txtrBienevnidoAAmazon.setBackground(Color.gray);
		txtrBienevnidoAAmazon.setBounds(706, 56, 609, 58);
		contentPane.add(txtrBienevnidoAAmazon);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		switch(arg0.getActionCommand())
		{
			case ENTRAR_CLIENTE:
				this.enrtarcliente();
				break;
		
			case ENTRAR_TRABAJADOR:
			
				break;
		} 
	}
	
	private void enrtarcliente()
	{
		
		FrameEntrarCliente obj= new FrameEntrarCliente();
		obj.setVisible(true);
		this.dispose();
	}
	
	
}

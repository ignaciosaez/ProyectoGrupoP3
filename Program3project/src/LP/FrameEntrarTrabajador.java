package LP;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import LD.BaseDatos;
import LN.gestorClientes;
import LN.gestorTrabajadores;

import static COMUN.constantesActionCommand.*;
public class FrameEntrarTrabajador extends JFrame implements ActionListener

{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabelU;
	private JLabel IMAGEN;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	private JButton btnNewButtonEntrar;
	private JPasswordField contrasenaPasswordField;
	public FrameEntrarTrabajador() 
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
		
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(150, 246, 500, 60);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		lblNewLabelU = new JLabel("Usuario");
		lblNewLabelU.setBounds(150, 160, 400, 60);
		lblNewLabelU.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabelU);
		
		contrasenaPasswordField = new JPasswordField();
		contrasenaPasswordField.setBounds(150, 400, 500, 60);
		getContentPane().add(contrasenaPasswordField);
		
	
		
		JLabel lblNewLabel = new JLabel("Contraseņa");
		lblNewLabel.setBounds(150, 320, 400, 60);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		JTextArea txtrBienevnidoAAmazon = new JTextArea();
		txtrBienevnidoAAmazon.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 27));
		txtrBienevnidoAAmazon.setText("RELLENE LOS CAMPOS !");
		txtrBienevnidoAAmazon.setBackground(Color.CYAN);
		txtrBienevnidoAAmazon.setBounds(150, 56, 400, 58);
		contentPane.add(txtrBienevnidoAAmazon);
		
		btnNewButtonEntrar = new JButton("LOGIN");
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEntrar.setBounds(150, 500, 198, 48);
		btnNewButtonEntrar.setActionCommand(BUTTON_ENTRAR);
		btnNewButtonEntrar.addActionListener(this);
		contentPane.add(btnNewButtonEntrar);
		
		btnNewButtonEntrar = new JButton("CANCELAR");
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEntrar.setBounds(450, 500, 198, 48);
		contentPane.add(btnNewButtonEntrar);
		btnNewButtonEntrar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonEntrar.addActionListener(this);
		
		
		IMAGEN = new JLabel("");
		IMAGEN.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/SIGNIN.jpg")));
		IMAGEN.setBounds(940,60,900,650 );
		
		IMAGEN.setOpaque(false);
		getContentPane().add(IMAGEN);
		this.setVisible(true);
		
		//PONGO YA UN USUARIO QUE HEN METIDO Y SU CONTRA PARA AGILIZAR
		textFieldUsuario.setText("GARBI");
		contrasenaPasswordField.setText("GARBI");
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
			case BUTTON_ENTRAR:this.entrarTrabajador();
				
				break;
		
			case BUTTON_CANCELAR:
				this.dispose();
				break;
		} 
		
	}
	
	private void entrarTrabajador() 
	{
		//AQUI LO QUE HAGO ES LLAMAR A UN METODO DE BASEDATOS QUE ME METERA LOS TRABJADORES A LA BD
		Statement state = BaseDatos.getStatement();
		BaseDatos.getConnection();
		BaseDatos.crearTablaTrabajadorBD();
		BaseDatos.InsertarTrabajadores(state);
		 
		 
		String usuario = textFieldUsuario.getText();
		char[] passWord = contrasenaPasswordField.getPassword();
		String contrasena = String.valueOf(passWord);
		gestorTrabajadores objT= new gestorTrabajadores();
		boolean existe; 
		
		
		
		
		existe =objT.validacionUsuarioContrasenaTrabajador(state, usuario, contrasena);
		if(existe == true)
		{
			FrameCliente objFrameCliente= new FrameCliente();
			objFrameCliente.setVisible(true);
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Correo o contraseņa incorrectas, vuelva a introducirlas");
			this.setVisible(true);
		}
		this.dispose();
	}

}

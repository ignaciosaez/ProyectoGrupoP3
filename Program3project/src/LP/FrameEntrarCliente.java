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

import static COMUN.constantesActionCommand.*;
public class FrameEntrarCliente extends JFrame implements ActionListener

{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabelU;
	private JLabel IMAGEN;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
	private JButton btnNewButtonEntrar;
	private JPasswordField contrasenaPasswordField;
	public FrameEntrarCliente() 
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
		lblNewLabelU.setForeground(Color.DARK_GRAY);
		lblNewLabelU.setBackground(Color.GREEN);
		lblNewLabelU.setBounds(150, 160, 400, 60);
		lblNewLabelU.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
		contentPane.add(lblNewLabelU);
		
		contrasenaPasswordField = new JPasswordField();
		contrasenaPasswordField.setBounds(150, 400, 500, 60);
		getContentPane().add(contrasenaPasswordField);
		
	
		
		JLabel lblNewLabel = new JLabel("Contraseña");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(150, 320, 400, 60);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JTextArea txtrBienevnidoAAmazon = new JTextArea();
		txtrBienevnidoAAmazon.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 27));
		txtrBienevnidoAAmazon.setText("RELLENE LOS CAMPOS !");
		txtrBienevnidoAAmazon.setBackground(Color.CYAN);
		txtrBienevnidoAAmazon.setBounds(150, 56, 400, 58);
		contentPane.add(txtrBienevnidoAAmazon);
		
		btnNewButtonEntrar = new JButton("LOGIN");
		btnNewButtonEntrar.setForeground(Color.DARK_GRAY);
		btnNewButtonEntrar.setBackground(Color.GREEN);
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButtonEntrar.setBounds(150, 500, 198, 48);
		btnNewButtonEntrar.setActionCommand(BUTTON_ENTRAR);
		btnNewButtonEntrar.addActionListener(this);
		contentPane.add(btnNewButtonEntrar);
		
		btnNewButtonEntrar = new JButton("CANCELAR");
		btnNewButtonEntrar.setForeground(Color.DARK_GRAY);
		btnNewButtonEntrar.setBackground(Color.RED);
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
		textFieldUsuario.setText("IGNACIO96");
		contrasenaPasswordField.setText("IGNACIO96");
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
			case BUTTON_ENTRAR:this.entrarCliente();
				
				break;
		
			case BUTTON_CANCELAR:
				this.dispose();
				break;
		} 
		
	}
	
	private void entrarCliente() 
	{
		String usuario = textFieldUsuario.getText();
		char[] passWord = contrasenaPasswordField.getPassword();
		String contrasena = String.valueOf(passWord);
		gestorClientes obj= new gestorClientes();
		boolean existe; 
		
		Statement state = BaseDatos.getStatement();
	
		
		
		existe =obj.validacionUsuarioContrasenaCliente(state, usuario, contrasena);
		if(existe == true)
		{
			FrameCliente objFrameCliente= new FrameCliente(usuario);
			objFrameCliente.setVisible(true);
			this.dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Correo o contraseña incorrectas, intentelo de nuevo");
			this.setVisible(true);
		}
		this.dispose();
	}

}

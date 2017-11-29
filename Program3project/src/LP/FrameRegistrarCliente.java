package LP;





import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import static COMUN.constantesActionCommand.*;

public class FrameRegistrarCliente extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel1;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel3;
	private JLabel lblNewLabel4;
	private JLabel lblNewLabel5;
	private JLabel IMAGEN;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JButton btnNewButtonEntrar;

	public FrameRegistrarCliente() 
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
		
		JTextArea txtrBienevnidoAAmazon = new JTextArea();
		txtrBienevnidoAAmazon.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 27));
		txtrBienevnidoAAmazon.setText("Rellene los campos!");
		txtrBienevnidoAAmazon.setBackground(Color.CYAN);
		txtrBienevnidoAAmazon.setBounds(150, 56, 400, 58);
		contentPane.add(txtrBienevnidoAAmazon);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(150, 160, 400, 60);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 230, 500, 60);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
		
		lblNewLabel1 = new JLabel("Apellidos");
		lblNewLabel1.setBounds(150, 300, 400, 60);
		lblNewLabel1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel1);
		
		textField1 = new JTextField();
		textField1.setBounds(150, 370, 500, 60);
		contentPane.add(textField1);
		textField1.setColumns(10);
		

		lblNewLabel2 = new JLabel("Ciudad");
		lblNewLabel2.setBounds(150, 440, 400, 60);
		lblNewLabel2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel2);
		
		textField2 = new JTextField();
		textField2.setBounds(150, 510, 500, 60);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		
		lblNewLabel3 = new JLabel("Dirección");
		lblNewLabel3.setBounds(150, 580, 400, 60);
		lblNewLabel3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel3);
		
		textField3 = new JTextField();
		textField3.setBounds(150, 650, 500, 60);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		
		
		lblNewLabel4 = new JLabel("Usuario /o/correo");
		lblNewLabel4.setBounds(800, 160, 500, 60);
		lblNewLabel4.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel4);
		
		textField4 = new JTextField();
		textField4.setBounds(800, 230, 500, 60);
		contentPane.add(textField4);
		textField4.setColumns(10);
		
		
		lblNewLabel5 = new JLabel("Contraseña");
		lblNewLabel5.setBounds(800, 300, 500, 60);
		lblNewLabel5.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel5);
		
		textField5 = new JTextField();
		textField5.setBounds(800, 370, 500, 60);
		contentPane.add(textField5);
		textField5.setColumns(10);
		
		
		
		btnNewButtonEntrar = new JButton("ENTRAR");
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEntrar.setBounds(800, 580, 198, 48);
		btnNewButtonEntrar.setActionCommand(BUTTON_ENTRAR);
		btnNewButtonEntrar.addActionListener(this);
		contentPane.add(btnNewButtonEntrar);
		
		btnNewButtonEntrar = new JButton("CANCELAR");
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEntrar.setBounds(1080, 580, 198, 48);
		contentPane.add(btnNewButtonEntrar);
		btnNewButtonEntrar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonEntrar.addActionListener(this);
		
		
		
		this.setVisible(true);
		
		
	

		}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		switch(e.getActionCommand())
		{
			case BUTTON_ENTRAR:
				
				break;
		
			case BUTTON_CANCELAR:
				
				break;
		} 
	}
}

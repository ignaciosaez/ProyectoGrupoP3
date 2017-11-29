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
	private JLabel lblNewLabelU;
	private JLabel IMAGEN;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasena;
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
		
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(150, 246, 500, 60);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		lblNewLabelU = new JLabel("Nombre");
		lblNewLabelU.setBounds(150, 160, 400, 60);
		lblNewLabelU.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabelU);
		
		textFieldContrasena = new JTextField();
		textFieldContrasena.setBounds(150, 400, 500, 60);
		contentPane.add(textFieldContrasena);
		textFieldContrasena.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Apellidos");
		lblNewLabel.setBounds(150, 320, 400, 60);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		JTextArea txtrBienevnidoAAmazon = new JTextArea();
		txtrBienevnidoAAmazon.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 27));
		txtrBienevnidoAAmazon.setText("Rellene los campos!");
		txtrBienevnidoAAmazon.setBackground(Color.CYAN);
		txtrBienevnidoAAmazon.setBounds(150, 56, 300, 58);
		contentPane.add(txtrBienevnidoAAmazon);
		
		btnNewButtonEntrar = new JButton("ENTRAR");
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEntrar.setBounds(150, 700, 198, 48);
		btnNewButtonEntrar.setActionCommand(BUTTON_ENTRAR);
		btnNewButtonEntrar.addActionListener(this);
		contentPane.add(btnNewButtonEntrar);
		
		btnNewButtonEntrar = new JButton("CANCELAR");
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEntrar.setBounds(450, 700, 198, 48);
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

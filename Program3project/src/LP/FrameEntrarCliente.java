package LP;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FrameEntrarCliente extends JFrame implements ActionListener

{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JLabel fondopantalla;
	
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
		
		
		 JTextField textField = new JTextField();
		textField.setBounds(26, 246, 206, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(36, 210, 112, 20);
		contentPane.add(lblNewLabel);
		
		
		/*
		fondopantalla = new JLabel("");
		fondopantalla.setIcon(new ImageIcon(PaginaPrincipal.class.getResource("/imagenes/70030553-shop-wallpapers.jpg")));
		fondopantalla.setBounds(0,0,3200,1000 );
		fondopantalla.setOpaque(false);
		getContentPane().add(fondopantalla);
		*/
		JTextArea txtrBienevnidoAAmazon = new JTextArea();
		txtrBienevnidoAAmazon.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 27));
		txtrBienevnidoAAmazon.setText("REGISTRESE AQUI!");
		txtrBienevnidoAAmazon.setBackground(Color.gray);
		txtrBienevnidoAAmazon.setBounds(706, 56, 609, 58);
		contentPane.add(txtrBienevnidoAAmazon);
		
		this.setVisible(true);
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package LP;


import static COMUN.constantesActionCommand.BUTTON_REGISTARSE;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import LD.BaseDatos;
import LN.gestorTrabajadores;

import static COMUN.constantesActionCommand.*;
public class FrameInsertarProducto extends JFrame implements ActionListener
{
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
	private JButton btnNewButtonEntrar;
	private JPasswordField contrasenaPasswordField;

	public FrameInsertarProducto ()
	{
		AtributosVentana();
		
	}
	
	private void AtributosVentana()
	{
		
		setForeground(Color.BLACK);
		setTitle("INSERTAR PRODUCTO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 549, 453);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(500, 500);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNewLabel = new JLabel("Nombre del producto");
		lblNewLabel.setBounds(150, 160, 500, 60);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 230, 500, 60);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
		
		lblNewLabel1 = new JLabel("Descripción del producto");
		lblNewLabel1.setBounds(150, 300, 400, 60);
		lblNewLabel1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel1);
		
		textField1 = new JTextField();
		textField1.setBounds(150, 370, 500, 60);
		contentPane.add(textField1);
		textField1.setColumns(10);
		

		lblNewLabel2 = new JLabel("Categoria");
		lblNewLabel2.setBounds(150, 440, 400, 60);
		lblNewLabel2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel2);
		
		textField2 = new JTextField();
		textField2.setBounds(150, 510, 500, 60);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		
		lblNewLabel3 = new JLabel("Código");
		lblNewLabel3.setBounds(150, 580, 400, 60);
		lblNewLabel3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel3);
		
		textField3 = new JTextField();
		textField3.setBounds(150, 650, 500, 60);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		
		
		lblNewLabel4 = new JLabel("Precio");
		lblNewLabel4.setBounds(800, 160, 500, 60);
		lblNewLabel4.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel4);
		
		
		textField4 = new JTextField();
		textField4.setBounds(800,230, 100, 60);
		contentPane.add(textField4);
		textField4.setColumns(10);
		
	
		
		lblNewLabel5 = new JLabel("€");
		lblNewLabel5.setBounds(1000, 230, 500, 60);
		lblNewLabel5.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel5);
		
		
		
	
		
		
		
		btnNewButtonEntrar = new JButton("AÑADIR PRODUCTO");
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEntrar.setBounds(800, 580, 300, 48);
		btnNewButtonEntrar.setActionCommand(BUTTON_ANADIRPRODUCTO);
		btnNewButtonEntrar.addActionListener(this);
		contentPane.add(btnNewButtonEntrar);
		
		btnNewButtonEntrar = new JButton("CANCELAR");
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEntrar.setBounds(1180, 580, 198, 48);
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
			case BUTTON_ANADIRPRODUCTO: 
				
				anadirproductos();
				
				break;
		
			case BUTTON_CANCELAR: this.dispose();
				
				break;
		} 
		
	}
	
	private void anadirproductos()
	{
		BaseDatos.getConnection();
		BaseDatos.crearTablaProductosBD();
		
		String nombre;
		String descripcion;
		String categoria;
		String codigo;
		String PRECIO;
		double precio;
		
		
		
		if(textField1.getText().isEmpty()||textField.getText().isEmpty()||textField2.getText().isEmpty()||textField3.getText().isEmpty()||textField4.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(this, "DEBES RELLENAR TODOS LOS CAMPOS");
		}else
		{
			nombre=textField.getText();
			descripcion=textField1.getText();
			categoria=textField2.getText();
			codigo=textField3.getText();
			
			PRECIO=textField4.getText();
			precio= Double.valueOf(PRECIO).doubleValue();
			gestorTrabajadores obj= new gestorTrabajadores();
			
			Statement state = BaseDatos.getStatement();
			obj.CrearProcuto(state, codigo, nombre ,descripcion, categoria, precio);
			JOptionPane.showMessageDialog(this, "El producto se ha añadido correctamente");
			int siOno= JOptionPane.showConfirmDialog(null,"¿Quiere seguir añadiendo productos?","SEGUIR AÑADIENDO PRODUCTOS",JOptionPane.YES_NO_OPTION);
			if(siOno==0)
			{
			textField.setText("");
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
			}else
			{
				this.dispose();
			}
		}
		
	}

}

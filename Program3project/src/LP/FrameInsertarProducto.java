package LP;


import static COMUN.constantesActionCommand.BUTTON_REGISTARSE;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LD.BaseDatos;
import LN.gestorClientes;
import LN.gestorTrabajadores;

import static COMUN.constantesActionCommand.*;

/**
 * Clase para la creaci�n de la ventana que nos permite introducir los datos de un nuevo producto al sistema. 
 * Adem�s, antes de introducir los datos, podremos tambi�n ver la lista de productos dados de alta mediante un bot�n.
 * @author Alumno
 */

public class FrameInsertarProducto extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel1;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel3;
	private JLabel lblNewLabel4;
	private JLabel lblNewLabel5;
	private JLabel lblNewLabel6;
	private JLabel IMAGEN;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JButton btnNewButtonEntrar;
	private JButton btnNewButtonCancelar;
	private JButton btnNewButtonVerProductos;
	private JButton btnNewButtonVerProductosActualizados;
	private JTable tabla;
	private JScrollPane scroll;
	private JPasswordField contrasenaPasswordField;
	DefaultTableModel modelo;


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
		
	
		
		lblNewLabel1 = new JLabel("Descripci�n del producto");
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
		
		
		lblNewLabel3 = new JLabel("C�digo");
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
		
	
		
		lblNewLabel5 = new JLabel("�");
		lblNewLabel5.setBounds(950, 230, 500, 60);
		lblNewLabel5.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 25));
		contentPane.add(lblNewLabel5);
		
		lblNewLabel6 = new JLabel("Utilizar . para los decimales");
		lblNewLabel6.setBounds(950, 260, 700, 60);
		lblNewLabel6.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 14));
		contentPane.add(lblNewLabel6);
		
	
		
		
		
		btnNewButtonEntrar = new JButton("A�ADIR PRODUCTO");
		btnNewButtonEntrar.setForeground(Color.DARK_GRAY);
		btnNewButtonEntrar.setBackground(Color.GREEN);
		btnNewButtonEntrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonEntrar.setBounds(750, 800, 300, 48);
		btnNewButtonEntrar.setActionCommand(BUTTON_ANADIRPRODUCTO);
		btnNewButtonEntrar.addActionListener(this);
		contentPane.add(btnNewButtonEntrar);
		
		btnNewButtonCancelar = new JButton("CANCELAR");
		btnNewButtonCancelar.setForeground(Color.DARK_GRAY);
		btnNewButtonCancelar.setBackground(Color.RED);
		btnNewButtonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonCancelar.setBounds(1200, 800, 198, 48);
		contentPane.add(btnNewButtonCancelar);
		btnNewButtonCancelar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonCancelar.addActionListener(this);
		
	
		btnNewButtonVerProductos = new JButton("VER PRODUCTOS EXISTENTES");
		btnNewButtonVerProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonVerProductos.setBounds(1480, 700, 380, 48);
		contentPane.add(btnNewButtonVerProductos);
		btnNewButtonVerProductos.setActionCommand(BUTTON_VERPRODUCTOS);
		btnNewButtonVerProductos.addActionListener(this);
		
		

		btnNewButtonVerProductosActualizados = new JButton("ACTUALIZAR TABLA");
		btnNewButtonVerProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonVerProductosActualizados.setBounds(1480, 800, 380, 48);
		contentPane.add(btnNewButtonVerProductosActualizados);
		btnNewButtonVerProductosActualizados.setActionCommand(BUTTON_VERPRODUCTOSACTUALIZADOS);
		btnNewButtonVerProductosActualizados.addActionListener(this);
		
		btnNewButtonVerProductosActualizados.setEnabled(false);;

		
		
		
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
				
			case BUTTON_VERPRODUCTOS:	construirTabla();
		
			break;	
			case BUTTON_VERPRODUCTOSACTUALIZADOS:actualizarTabla();	;
			
			break;	
		} 
		
	}
	private void construirTabla()
	{
	
		
		btnNewButtonVerProductosActualizados.setEnabled(true);;
		
		
		tabla= new JTable();
		scroll= new JScrollPane();
		scroll.setBounds(1200, 250, 700, 400);
		getContentPane().add(scroll);
		scroll.setViewportView(tabla); 
		
		modelo= new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Categoria");
		modelo.addColumn("Precio");
		tabla.setModel(modelo);
		modelo.fireTableDataChanged();
		gestorTrabajadores obj= new gestorTrabajadores();
		obj.devolverTabla(tabla);
		
		
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
		boolean existe;
		
		
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
			existe=obj.validacionCodigoPorducto(state, codigo);
			if(existe==false)
			{
				obj.CrearProcuto(state, codigo, nombre ,descripcion, categoria, precio);
				
				JOptionPane.showMessageDialog(this, "El producto se ha a�adido correctamente");
				
				int siOno= JOptionPane.showConfirmDialog(null,"�Quiere seguir a�adiendo productos?","SEGUIR A�ADIENDO PRODUCTOS",JOptionPane.YES_NO_OPTION);
				if(siOno==0)
				{
				textField.setText("");
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				}
				else
				{
					this.dispose();
				}
			}else
			{
				JOptionPane.showMessageDialog(this, "CODIGO EXISTENTE");
			}
			
			
		}
		
	}
	private void actualizarTabla()
	{
		modelo.fireTableDataChanged();
		construirTabla();
	
	}
	

}

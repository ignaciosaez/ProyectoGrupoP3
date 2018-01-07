package LP;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import LD.BaseDatos;
import LN.gestorTrabajadores;

import static COMUN.constantesActionCommand.*;

/**
 * Clase para la creaci�n de la ventana que nos permite visualizar y modificar la lista de los productos disponibles en nuestra tienda.
 * Se nos mostrar� la lista de productos y una vez seleccionado el producto a modificar, se podr�n cambiar los valores.
 * Una vez modificado el producto, tambi�n se podr� actualizar la lista que vemos en pantalla mediante un bot�n. 
 * @author Alumno
 */

public class FrameModificarProducto extends JFrame implements ActionListener 
{
	private JLabel lblNewLabel;
	private JLabel lblNewLabel1;
	private JLabel lblNewLabel2;
	private JLabel lblNewLabel3;
	private JLabel lblNewLabel4;
	private JLabel lblNewLabel5;
	private JLabel lblNewLabel6;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JButton btnNewButtonCancelar;
	private JButton btnNewButtonVerProductosActualizados;
	private JPanel contentPane;
	private JScrollPane scroll;
	private JLabel etiqueta;
	private JLabel etiqueta1;
	private JLabel etiqueta2;
	static Connection connection ;
	Connection con= BaseDatos.getConnection();
	private int filaseleccionada;
	private String codigo;
	private String nombre;
	private String Descripcion;
	private String categoria;
	private double precio;
	private JButton btnModificar;
	 DefaultTableModel modelo;
	 JTable tabla;
	
	

	public FrameModificarProducto() 
	{
		atributosVentana();
	} 

	
	
	
	
	private void atributosVentana()
	{
	
		setForeground(Color.BLACK);
		setTitle("PRODUCTOS DISPONIBLES");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 549, 453);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(500, 500);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		etiqueta1 = new JLabel("PRODUCTOS EN EL CATALOGO");
		etiqueta1.setBounds(10, 10, 900, 60);
		etiqueta1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		etiqueta1.setForeground(Color.blue);
		contentPane.add(etiqueta1);  
		
		etiqueta = new JLabel("Seleccione el producto que desea modificar");
		etiqueta.setBounds(1050, 490, 900, 60);
		etiqueta.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		etiqueta.setForeground(Color.blue);
		contentPane.add(etiqueta);
		
	

		

		lblNewLabel = new JLabel("Nombre del producto");
		lblNewLabel.setBounds(100, 420, 500, 60);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(100, 490, 400, 60);
		contentPane.add(textField);
		textField.setColumns(10);
		
	
		
		lblNewLabel1 = new JLabel("Descripci�n");
		lblNewLabel1.setBounds(100, 560, 400, 60);
		lblNewLabel1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel1);
		
		textField1 = new JTextField();
		textField1.setBounds(100, 630, 400, 100);
		contentPane.add(textField1);
		textField1.setColumns(10);
		

		lblNewLabel2 = new JLabel("Categoria");
		lblNewLabel2.setBounds(100, 730, 400, 60);
		lblNewLabel2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel2);
		
		textField2 = new JTextField();
		textField2.setBounds(100, 800, 400, 60);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		
		lblNewLabel3 = new JLabel("C�digo");
		lblNewLabel3.setBounds(600, 420, 400, 60);
		lblNewLabel3.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel3);
		
		textField3 = new JTextField();
		textField3.setBounds(600, 490, 400, 60);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		
		
		lblNewLabel4 = new JLabel("Precio");
		lblNewLabel4.setBounds(600, 560, 500, 60);
		lblNewLabel4.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel4);
		
		
		textField4 = new JTextField();
		textField4.setBounds(600,630, 100, 60);
		contentPane.add(textField4);
		textField4.setColumns(10);
		
		

		btnModificar = new JButton("Modificar producto");
		btnModificar.setForeground(Color.DARK_GRAY);
		btnModificar.setBackground(Color.GREEN);
		btnModificar.setActionCommand(BUTTON_MODIFICARPRODUCTOS);
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificar.addActionListener(this);
		btnModificar.setBounds(900, 800, 418, 50);
		contentPane.add(btnModificar);
		
		btnNewButtonCancelar = new JButton(" VOLVER ATR�S");
		btnNewButtonCancelar.setForeground(Color.DARK_GRAY);
		btnNewButtonCancelar.setBackground(Color.RED);
		btnNewButtonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonCancelar.setBounds(1380, 800, 198, 48);
		contentPane.add(btnNewButtonCancelar);
		btnNewButtonCancelar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonCancelar.addActionListener(this);
	//modificar producto
		btnNewButtonVerProductosActualizados = new JButton("ACTUALIZAR TABLA");
		btnNewButtonVerProductosActualizados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonVerProductosActualizados.setBounds(1580, 800, 280, 48);
		contentPane.add(btnNewButtonVerProductosActualizados);
		btnNewButtonVerProductosActualizados.setActionCommand(BUTTON_VERPRODUCTOSACTUALIZADOS);
		btnNewButtonVerProductosActualizados.addActionListener(this);
		
		
		construirTabla();
		
		tabla.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				filaseleccionada=tabla.getSelectedRow();
				codigo = (String)tabla.getValueAt(filaseleccionada, 0);
				nombre=(String)tabla.getValueAt(filaseleccionada, 1);
				Descripcion=(String)tabla.getValueAt(filaseleccionada, 2);
				categoria=(String)tabla.getValueAt(filaseleccionada, 3);
				precio=(Double)tabla.getValueAt(filaseleccionada, 4);
				
				String stringPrecio=String.valueOf(precio);
				textField.setText(nombre);
				textField1.setText(Descripcion);
				textField2.setText(categoria);
				textField3.setText(codigo);
				textField3.setEnabled(false);
				textField4.setText(stringPrecio);
				//clicado=true;
				
			}
		});
	}

	private void construirTabla()
	{
		tabla= new JTable();
		scroll= new JScrollPane();
		scroll.setBounds(0, 100, 1930, 300);
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

	private void ModificarProducto()
	{
		//falta validar que las tablas no esten vacias
		gestorTrabajadores obj= new gestorTrabajadores();
		Statement state = BaseDatos.getStatement();
		if(textField1.getText().isEmpty()||textField.getText().isEmpty()||textField2.getText().isEmpty()||textField3.getText().isEmpty()||textField4.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "DEBES RELLENAR TODOS LOS CAMPOS");
		}else
		{
			String PRECIO;
			double precio;
			PRECIO=textField4.getText();
			precio= Double.valueOf(PRECIO).doubleValue();
			obj.modificar(state, codigo, textField.getText(),textField1.getText(),textField2.getText(), precio);
		
			textField.setText("");
			textField1.setText("");
			textField2.setText("");
			textField3.setText("");
			textField4.setText("");
			
			
		}	
		
	}
	
	private void actualizartabla()
	{
		
		modelo.fireTableDataChanged();
		
		construirTabla();
	}



	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		case BUTTON_MODIFICARPRODUCTOS: 
		ModificarProducto();break;
		
		case BUTTON_CANCELAR:
		this.dispose();break;
		
		case BUTTON_VERPRODUCTOSACTUALIZADOS: actualizartabla(); 
		break;
			
		
				
		} 
		
	}
	

	

}

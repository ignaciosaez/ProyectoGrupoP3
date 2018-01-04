package LP;

import static COMUN.constantesActionCommand.BUTTON_CANCELAR;
import static COMUN.constantesActionCommand.BUTTON_MODIFICARPRODUCTOS;
import static COMUN.constantesActionCommand.BUTTON_REGISTARSE;

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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import LD.BaseDatos;
import LN.gestorClientes;
import LN.gestorTrabajadores;
import static COMUN.constantesActionCommand.*;


public class FrameCompraCliente extends JFrame implements ActionListener
{

	private JButton btnNewButtonCancelar;
	private JButton btnComprar;
	private JButton btnEliminar;
	private JButton btnAnadir;
	private JPanel contentPane;
	private JScrollPane scroll;
	private JLabel etiqueta2;
	private JLabel etiqueta;
	static Connection connection ;
	Connection con= BaseDatos.getConnection();
	private JTable tabla;
	private JTable tablaCarrito;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloCarrito;
	private JSpinner spinnerCantidad;
	private int filaseleccionada;
	private String codigo;
	private String nombre;
	private String Descripcion;
	private String categoria;
	private double precio;
	private int cantidad;
	String usuario;
	
	public FrameCompraCliente(String usuario) 
	{
		this.usuario=usuario;
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
		
		etiqueta = new JLabel("Cantidad");
		etiqueta.setBounds(1650, 10, 900, 60);
		etiqueta.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(etiqueta);
		
		etiqueta2 = new JLabel("Seleccione el producto que desea comprar");
		etiqueta2.setBounds(10, 10, 900, 60);
		etiqueta2.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(etiqueta2);
		
		btnAnadir = new JButton("A�adir al carrito");
		btnAnadir.setActionCommand(BUTTON_ANADIRCARRITO);
		btnAnadir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAnadir.addActionListener(this);
		btnAnadir.setBounds(1100, 500, 200, 50);
		contentPane.add(btnAnadir);
		
		btnEliminar = new JButton("Eliminar del carrito");
		btnEliminar.setActionCommand(BUTTON_ELIMINARDELCARRITO);
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(1100, 550, 200, 50);
		contentPane.add(btnEliminar);
		
		btnComprar = new JButton("Comprar");
		btnComprar.setActionCommand(BUTTON_COMPRARPRODUCTOS);
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnComprar.addActionListener(this);
		btnComprar.setBounds(1100, 600, 200, 50);
		contentPane.add(btnComprar);
		
		btnNewButtonCancelar = new JButton("Cancelar");
		btnNewButtonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonCancelar.setBounds(1100, 650, 200, 50);
		contentPane.add(btnNewButtonCancelar);
		btnNewButtonCancelar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonCancelar.addActionListener(this);
		

		JLabel lblcarritoCompra = new JLabel("CARRITO DE LA COMPRA");
		lblcarritoCompra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblcarritoCompra.setBounds(10, 470, 242, 33);
		contentPane.add(lblcarritoCompra);
		
		spinnerCantidad = new JSpinner();
		spinnerCantidad.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinnerCantidad.setBounds(1650, 70, 83, 72);
		spinnerCantidad.setValue(1);
		contentPane.add(spinnerCantidad);
		construirTabla();
		
	}

	private void construirTabla()
	{
		tabla= new JTable();
		scroll= new JScrollPane();
		scroll.setBounds(10, 70, 1500, 400);
		getContentPane().add(scroll);
		scroll.setViewportView(tabla); 
		
		//DefaultTableModel modelo= new DefaultTableModel();
		modelo= new DefaultTableModel();
		modelo.addColumn("C�digo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Categoria");
		modelo.addColumn("Precio");
		tabla.setModel(modelo);
		ArrayList<Object[]> datos= new ArrayList<Object[]>();
		gestorTrabajadores obj = new gestorTrabajadores();
		datos= obj.llenarTabla();
		
		for(int i=0;i<datos.size();i++)
		{
			modelo.addRow(datos.get(i));
			
		}
		
		tablaCarrito= new JTable();
		scroll= new JScrollPane();
		scroll.setBounds(10, 500, 1000, 200);
		getContentPane().add(scroll);
		scroll.setViewportView(tablaCarrito); 
		
		modeloCarrito= new DefaultTableModel();
		modeloCarrito.addColumn("C�digo");
		modeloCarrito.addColumn("Nombre");
		modeloCarrito.addColumn("Descripcion");
		modeloCarrito.addColumn("Categoria");
		modeloCarrito.addColumn("Precio");
		tablaCarrito.setModel(modeloCarrito);
		
	
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
				
			}
		});
		
	}

	private void ComprarProducto()
	{
		
		BaseDatos.getConnection();
		BaseDatos.crearTablaCompraBD();
		Statement state = BaseDatos.getStatement();
		gestorClientes obj= new gestorClientes();
		cantidad=(int) spinnerCantidad.getValue();
		if(filaseleccionada>=0)
		{
			obj.ComprarProducto(state, codigo, nombre, precio, cantidad, usuario);
			
		}else
		{
			JOptionPane.showMessageDialog(null,"debes seleccionar un producto");
		}
		
		
		
	}
	
	private void anadirCarrito()
	{

		Object[] fila = new Object[5];
		
		fila[0] = codigo;
		fila[1] = nombre;
		fila[2] = Descripcion;
		fila[3] = categoria;
		fila[4] = precio;
		modelo.removeRow(filaseleccionada);
		modeloCarrito.addRow(fila);
		
	}
	
	private void eliminarCarrito()
	{
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
		
		case BUTTON_ANADIRCARRITO: anadirCarrito();
			
			break;
			
		case BUTTON_ELIMINARDELCARRITO: eliminarCarrito();
			
			break;
			
		case BUTTON_COMPRARPRODUCTOS: ComprarProducto();
		
		break;
		
		case BUTTON_CANCELAR: this.dispose();
				
				break;
		} 
		
	}
	

}

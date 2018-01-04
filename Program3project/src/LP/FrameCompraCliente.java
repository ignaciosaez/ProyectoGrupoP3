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
	private JPanel contentPane;
	private JScrollPane scroll;
	private JLabel etiqueta2;
	private JLabel etiqueta;
	static Connection connection ;
	Connection con= BaseDatos.getConnection();
	private JTable tabla;
	private DefaultTableModel modelo;
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
		
		btnNewButtonCancelar = new JButton(" CANCELAR");
		btnNewButtonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonCancelar.setBounds(1580, 750, 198, 48);
		contentPane.add(btnNewButtonCancelar);
		btnNewButtonCancelar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonCancelar.addActionListener(this);
		
		btnComprar = new JButton("Añadir al carrito de compra");
		btnComprar.setActionCommand(BUTTON_COMPRARPRODUCTOS);
		btnComprar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnComprar.addActionListener(this);
		btnComprar.setBounds(750, 750, 618, 50);
		contentPane.add(btnComprar);
		
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
		
		DefaultTableModel modelo= new DefaultTableModel();
		modelo.addColumn("Código");
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

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
			
		case BUTTON_COMPRARPRODUCTOS: ComprarProducto();
		
		break;
		
		case BUTTON_CANCELAR: this.dispose();
				
				break;
		} 
		
	}
	

}

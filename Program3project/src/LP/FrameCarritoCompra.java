package LP;

import static COMUN.constantesActionCommand.BUTTON_CANCELAR;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import LD.BaseDatos;
import LN.gestorClientes;
import LN.gestorTrabajadores;
import static COMUN.constantesActionCommand.*;


public class FrameCarritoCompra extends JFrame implements ActionListener
{

	private JButton btnNewButtonCancelar;
	private JButton btnEliminar;
	private JButton btnNewButtonFinalizarCompra;
	private JLabel IMAGEN;
	private JPanel contentPane;
	private JScrollPane scroll;
	static Connection connection ;
	Connection con= BaseDatos.getConnection();
	 JTable tabla;
	 DefaultTableModel modelo;
	 JTextField textField;
	private JLabel lblNewLabel;
	private int filasTabla;
	private int filaseleccionada;
	private String codigo;
	private String usuario;	
	private JLabel etiqueta;


	public FrameCarritoCompra() 
	{
		java.sql.Connection con=  BaseDatos.getConnection();
		atributosVentana();
	} 

	
	
	
	
	private void atributosVentana()
	{
	
		setForeground(Color.BLACK);
		setTitle("PRODUCTOS EN EL CARRITO DE COMPRA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 549, 453);
		this.setExtendedState(MAXIMIZED_BOTH);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setSize(500, 500);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		etiqueta = new JLabel("CARRITO DE COMPRA");
		etiqueta.setBounds(10, 10, 900, 60);
		etiqueta.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		etiqueta.setForeground(Color.blue);
		contentPane.add(etiqueta); 
		

		btnEliminar = new JButton("ELIMINAR PRODUCTO");
		btnEliminar.setActionCommand("ELIMINAR");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand(BUTTON_ELIMINARDELCARRITO);
		btnEliminar.setBounds(1280, 500, 318, 50);
		contentPane.add(btnEliminar);
		
		btnNewButtonCancelar = new JButton("VOLVER ATRÁS");
		btnNewButtonCancelar.setForeground(Color.DARK_GRAY);
		btnNewButtonCancelar.setBackground(Color.RED);
		btnNewButtonCancelar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButtonCancelar.setBounds(1680, 860, 198, 48);
		contentPane.add(btnNewButtonCancelar);
		btnNewButtonCancelar.setActionCommand(BUTTON_CANCELAR);
		btnNewButtonCancelar.addActionListener(this);
		
		
		lblNewLabel = new JLabel("TOTAL A PAGAR");
		lblNewLabel.setBounds(150, 480, 500, 60);
		lblNewLabel.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 30));
		contentPane.add(lblNewLabel);
		
		
		textField = new JTextField();
		textField.setBounds(450, 480, 100, 60);
		contentPane.add(textField);
		textField.setColumns(10);
	
		
		
		construirTabla();
		totalapagar();
		
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
			public void mouseClicked(MouseEvent arg0) 
			{
				filaseleccionada=tabla.getSelectedRow();
				codigo = (String)tabla.getValueAt(filaseleccionada, 0);
				usuario= (String)tabla.getValueAt(filaseleccionada, 4);
				//clicado=true;
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		
		
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
		modelo.addColumn("Precio");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Usuario");
		tabla.setModel(modelo);
		ArrayList<Object[]> datos= new ArrayList<Object[]>();
		gestorClientes obj= new  gestorClientes();
		datos=obj.llenarTablaCarrito();
		
		for(int i=0;i<datos.size();i++)
		{
			modelo.addRow(datos.get(i));
			
		}
		
		
		
	}


	private void EliminarProductoCarrito()
	{
		gestorClientes obj= new gestorClientes();
		Statement state = BaseDatos.getStatement();
		modelo= (DefaultTableModel) tabla.getModel();
		modelo.removeRow(filaseleccionada);
		obj.EliminarProductoCarrito(state, codigo, usuario);
		totalapagar();

		
		
	}

	
	private void totalapagar()
	{
		gestorClientes obj= new gestorClientes();
		
		int filaseleccionada;
		int columnaseleccionada;
		double total=0;
		double precio=0;
		int cantidad=0;
		Statement state = BaseDatos.getStatement();
		for(int i=0;i<tabla.getRowCount();i++)
		{
			precio=(double) tabla.getValueAt(i,2 );
			cantidad=(int) tabla.getValueAt(i,3 );
			
			total=total+ precio * cantidad;
			
		}
		String stringPrecio=String.valueOf(total);
		textField.setText(stringPrecio+" €");
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch(arg0.getActionCommand())
		{
			
			case BUTTON_ELIMINARDELCARRITO: EliminarProductoCarrito();
			break;
			case BUTTON_CANCELAR: this.dispose();
			break;
		} 
		
	}
	

}

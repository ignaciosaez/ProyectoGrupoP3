package LP;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LD.BaseDatos;
import LN.gestorTrabajadores;



public class FrameVerProductos extends JFrame
{

	
	private JPanel contentPane;
	private JScrollPane scroll;
	static Connection connection ;
	Connection con= BaseDatos.getConnection();
	private JTable tabla;
	private DefaultTableModel modelo;
	private JLabel IMAGEN;
	public FrameVerProductos() 
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
		
		
	}
	

}

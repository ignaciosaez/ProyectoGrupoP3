package LP;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import LD.BaseDatos;
import LN.gestorTrabajadores;



public class FrameVerProductos extends JFrame
{
	static Statement state ;
	static ResultSet rs;
	private JPanel contentPane;
	private JTable	tabla;
	private JScrollPane scroll;
	static Connection connection = null;
	
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
		
		tabla= new JTable();
		scroll= new JScrollPane();
		scroll.setBounds(10, 70, 766, 367);
		getContentPane().add(scroll);
		scroll.setViewportView(tabla);
		
		construirTabla();
		
	}

	private void construirTabla()
	{
		DefaultTableModel modelo= new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Categoria");
		modelo.addColumn("Precio");
		tabla.setModel(modelo);
		ArrayList<Object[]> datos= new ArrayList<Object[]>();
		datos= llenarTabla();
		
		for(int i=0;i<datos.size();i++)
		{
			modelo.addRow(datos.get(i));
		}
		
		
	}
	public static ArrayList<Object[]> llenarTabla()
	{
		//SENTENCIA=STATE
		//RESULTADO=RESULSET
	
		ArrayList<Object[]> datos= new ArrayList<Object[]>();
		
		
		try
		{
			String query= "SELECT * FROM PRODUCTO" ;
			PreparedStatement pat = connection.prepareStatement(query);
			ResultSet rs = pat.executeQuery();
			
			while(rs.next())
			{
				Object [] filas=new Object[5];
				for(int i=0;i<5;i++)
				{
					
					filas[i]=rs.getObject(i+1);
				}
				datos.add(filas);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		/*try {
			rs=state.executeQuery(query);
			System.out.println("CORRECTO");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while(rs.next())
			{
				Object [] filas=new Object[5];
				for(int i=0;i<5;i++)
				{
					
					filas[i]=rs.getObject(i+1);
				}
				datos.add(filas);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return datos;
	}
	private String[][] obtenerMatriz()
	{
		return null;
		
	}
}

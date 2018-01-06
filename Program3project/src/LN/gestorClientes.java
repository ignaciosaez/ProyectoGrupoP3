package LN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import LD.BaseDatos;

public class gestorClientes 
{
	static Statement state= BaseDatos.getStatement();
	java.sql.Connection con=  BaseDatos.getConnection();
	static ResultSetMetaData rm;
	static ResultSet rs;
	 

	
	public boolean añadirNuevoCliente(Statement state, String nombre, String apellidos, String ciudad, String direccion, String usuario, String contrasena)
	{
		try 
		{
			String SelectBD = "insert into CLIENTE values(" + "'" + nombre + "', " + "'" + apellidos + "', "+ "'" + ciudad +  "', "+ "'" + direccion + "', "+ "'" + usuario  + "'," +  "'" + contrasena  + "')";
			int val;
			val = state.executeUpdate( SelectBD );
			
			if (val!= 1)
			{
				return false;  
			}else
			{
				return true;
			}
		}catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean ExisteCliente(Statement state, String usuario)
	{
		String SelectBD = "select * from CLIENTE where (usuario = '" + usuario + "')";
		try 
		{
			ResultSet rs = state.executeQuery( SelectBD );
			if(rs.next())
			{
				rs.close();
				return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean validacionUsuarioContrasenaCliente(Statement state, String usuario, String contrasena)
	{
		String SelectBD = "select * from CLIENTE where (usuario = '" + usuario + "' and contrasena = '" + contrasena + "')";
		try 
		{
			ResultSet rs = state.executeQuery( SelectBD );
			if(rs.next())
			{
				rs.close();
				JOptionPane.showMessageDialog(null, "Usuario y contraseña correctas", "Correcto",JOptionPane.INFORMATION_MESSAGE);					return true;
			}
			else
			{
				return false;
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public void ComprarProducto(Statement state, String cod_producto,String nombre_producto, double precio,int cantidad, String usuario)
	{
		
		
			String query = "insert into CARRITOCOMPRA values(" + "'" + cod_producto + "'," + "'" + nombre_producto + "'," + "'" + precio + "',"+ "'" + cantidad+ "'," + "'" + usuario + "')";
			
			try {
				state.executeUpdate( query );
				JOptionPane.showMessageDialog(null, "Producto añadido correctamente al carrito de la compra");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
	public static ArrayList<Object[]> llenarTablaCarrito(String usuario)
	{
		
	
		ArrayList<Object[]> datos= new ArrayList<Object[]>();
		
		
		
			
			try {
				String query= "SELECT * FROM CARRITOCOMPRA where (usuario= '"+usuario+"' )" ;
				rs=state.executeQuery(query);
				rm=rs.getMetaData();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		

			
	
		try {
			while(rs.next())
			{
				Object [] filas=new Object[rm.getColumnCount()];
				for(int i=0;i<rm.getColumnCount();i++)
				{
					
					filas[i]=rs.getObject(i+1);
					
				}
				datos.add(filas);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return datos;
	}
	
	public void EliminarProductoCarrito(Statement state, String cod,String usuario)
	{
		
		String query = "delete from CARRITOCOMPRA where (cod_producto = '" + cod + "' AND usuario= '"+usuario+"' )";
		
		 try {
			state.execute(query);
			JOptionPane.showMessageDialog(null, "Eliminado correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	public JTable devolverTabla( JTable tabla, String usuario) 
	{
		ArrayList<Object[]> datos= new ArrayList<Object[]>();
		datos= llenarTablaCarrito(usuario);
		DefaultTableModel modelo;
		modelo=(DefaultTableModel) tabla.getModel();
		for(int i=0;i<datos.size();i++)
		{
			modelo.addRow(datos.get(i));
			
		}
		return tabla;
	}
	public double totalPAGAR(JTable tabla)
	{
		
		double total=0;
		
		int filaseleccionada;
		int columnaseleccionada;
		double precio=0;
		int cantidad=0;
		Statement state = BaseDatos.getStatement();
		for(int i=0;i<tabla.getRowCount();i++)
		{
			precio=(double) tabla.getValueAt(i,2 );
			cantidad=(int) tabla.getValueAt(i,3 );
			
			total=total+ precio * cantidad;
			
		}
		
		return total;
		
		
		
		
	}
	public void eliminarTablaCompra(Statement state)
	{
		
		
	
			String SelectBD = "DROP TABLE CARRITOCOMPRA ";
			try {
				state.executeUpdate(SelectBD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}
	
	

}

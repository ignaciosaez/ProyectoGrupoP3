package LN;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	public static ArrayList<Object[]> llenarTablaCarrito()
	{
		
	
		ArrayList<Object[]> datos= new ArrayList<Object[]>();
		
		
		
			
			try {
				String query= "SELECT * FROM CARRITOCOMPRA" ;
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
	/*
	public double TotalApagar(Statement state, Connection connection)
	{
		try 
		{
			double total=0;
			ArrayList<	Double> arrayPrecio = new ArrayList<Double>();
			ArrayList<Integer> arrayCantidad = new ArrayList<Integer>();
			String query = "select * from CARRITOCOMPRA";
			PreparedStatement pat = connection.prepareStatement(query);
			ResultSet rs = pat.executeQuery();
			
			//Recorremos el cursor hasta que no haya más registros
			do
			{
				double precio= rs.getDouble("precio_producto");
			    arrayPrecio.add(precio);
			    int cantidad= rs.getInt("cantidad");
			    arrayCantidad.add(cantidad);
			} while(rs.next() == true);
			
			if(arrayPrecio.size()>=1)
			{
				
					for(int i=1; i<arrayCantidad.size();i++)
					{
						total = total + arrayCantidad.get(i);
					}
			
				
			}
		     return total;

		} catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}*/
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

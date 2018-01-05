package LN;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.sun.corba.se.pept.transport.Connection;

import LD.BaseDatos;

public class gestorTrabajadores {

	static Statement state= BaseDatos.getStatement();
	java.sql.Connection con=  BaseDatos.getConnection();
	static ResultSetMetaData rm;
	static ResultSet rs;
	
	public boolean validacionUsuarioContrasenaTrabajador(Statement state, String usuario, String contrasena)
	{
		String SelectBD = "select * from TRABAJADOR where (usuario = '" + usuario + "' and contrasenya = '" + contrasena + "')";
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
	
	
	public void CrearProcuto(Statement state, String cod_producto , String nom_producto ,String descripcion_producto,String categoria_producto, double precio_producto)
	{
		try 
		{
			
			String SelectBD = "INSERT INTO PRODUCTO values(" + "'" + cod_producto + "', "+ "'" + nom_producto + "', "+ "'" + descripcion_producto + "', "+ "'" + categoria_producto +  "', "+ "'" +  precio_producto  + "')";
			state.executeUpdate(SelectBD);
		
		}catch (SQLException e)
		{
			e.printStackTrace();
			
		}
	}
	
	public void eliminarTablaProducto(Statement state)
	{
		
		
	
			String SelectBD = "DROP TABLE PRODUCTO ";
			try {
				state.executeUpdate(SelectBD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}
	
	
	public static ArrayList<Object[]> llenarTabla()
	{
		
	
		ArrayList<Object[]> datos= new ArrayList<Object[]>();
		
		
		
			
			try {
				String query= "SELECT * FROM PRODUCTO" ;
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
	
	public boolean validacionCodigoPorducto(Statement state, String cod)
	{
		String SelectBD = "select * from PRODUCTO where (cod_producto = '" + cod + "')";
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
	
	public void EliminarProducto(Statement state, String cod_producto)
	{
		
		String query = "delete from PRODUCTO where (cod_producto = '" + cod_producto + "')";
		
		 try {
			state.execute(query);
			JOptionPane.showMessageDialog(null, "Eliminado correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	public void modificar(Statement state, String codigo,String nombre,String descripcion,String categoria,double precio)
	{
		
		String query = "UPDATE PRODUCTO SET "
				+"cod_producto = ' "+codigo+ "',"
				+"nombre_producto = '"+nombre+" ',"
				+"descripcion_producto =' "+descripcion+" ',"
				+"categoria_producto = '"+ categoria+" ',"
				+"precio_producto = '"+ precio+" '"
				+"WHERE cod_producto = '"+codigo+"' ";
		
		try {
			state.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null,"Modificado correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	public ArrayList<clsProducto> DevolverProductos (Statement state)
	{
		ArrayList<clsProducto> ArrayP = new ArrayList<clsProducto>();
		
		String SelectBD = "select * from PRODUCTO ";
		ResultSet rs;
		try
		{
			rs = state.executeQuery(SelectBD);
			while(rs.next())
			{
				ArrayP.add(new clsProducto( rs.getString("cod_producto"),rs.getString("nombre_producto"), rs.getString("descripcion_producto"),rs.getString("categoria_producto") ,rs.getDouble("precio_producto")));
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ArrayP;
	}
	
}



package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class gestorClientes 
{
	
	 

	
	public boolean a�adirNuevoCliente(Statement state, String nombre, String apellidos, String ciudad, String direccion, String usuario, String contrasena)
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
				JOptionPane.showMessageDialog(null, "Usuario y contrase�a correctas", "Correcto",JOptionPane.INFORMATION_MESSAGE);					return true;
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
				JOptionPane.showMessageDialog(null, "Compra realizada con exito");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
	

}

package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class gestorClientes 
{
	
	 

	
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
	
	public boolean validacionUsuarioContrasena(Statement state, String usuario, String contrasena)
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

}

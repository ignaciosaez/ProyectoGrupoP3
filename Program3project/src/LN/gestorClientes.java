package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class gestorClientes 
{
	
	 
	public boolean ClienteNuevo(Statement state, String correo, String nombre, String contrasenya) 
	{
		try 
		{
			String SelectBD = "insert into CLIENTE values(" + "'" + correo + "', " + "'" + nombre + "', "+ "'" + contrasenya + "')";
			int val;
			val = state.executeUpdate( SelectBD );
			//ExecuteUpdate devuelve el numero de filas que se ven afectadas que en nuestro caso debe ser 1 sino se�al de que no esta bien
			if (val!= 1)
			{
				return false;  
			}else
			{
				return true;
			}
		}catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, this, "El correo introducido ya est� registrado", 0);
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean ExisteCliente(Statement state, String correo)
	{
		String SelectBD = "select * from CLIENTE where (correo = '" + correo + "')";
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
	
	public boolean ValidarEntradaCli(Statement state, String correo, String contrasenya)
	{
		String SelectBD = "select * from CLIENTE where (correo = '" + correo + "' and contrasenya = '" + contrasenya + "')";
		try 
		{
			ResultSet rs = state.executeQuery( SelectBD );
			if(rs.next())
			{
				rs.close();
				JOptionPane.showMessageDialog(null, "Nombre de usuario y contrase�a correctas", "Correcto",JOptionPane.INFORMATION_MESSAGE);					return true;
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
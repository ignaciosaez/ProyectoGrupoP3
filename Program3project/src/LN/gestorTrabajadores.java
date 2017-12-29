package LN;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class gestorTrabajadores {

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
			
			String SelectBD = "INSERT INTO PRODUCTO values(" + "'" + cod_producto + "', "+ "'" + descripcion_producto + "', "+ "'" + nom_producto + "', "+ "'" + categoria_producto +  "', "+ "'" +  precio_producto  + "')";
			state.executeUpdate(SelectBD);
		
		}catch (SQLException e)
		{
			e.printStackTrace();
			
		}
	}
	/*
	public void eliminarProducto(Statement state)
	{
		
		
	
			String SelectBD = "DROP TABLE PRODUCTO ";
			try {
				state.executeUpdate(SelectBD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
	}
	*/
	public boolean ExisteProducto(Statement state, int codigo)
	{
		String SelectBD = "select * from PRODUCTO where (cod_producto = '" + codigo + "')";
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
	
	/*
	public boolean CancelarProducto(Statement state, String cod_producto)
	{
		String SelectBD1 = "select * from PRODUCTO";
		String SelectBD2 = "delete from PRODUCTO where (cod_vuelo = '" + cod_producto + "')";
		
		try 
		{
			ResultSet rs1 = state.executeQuery( SelectBD1 );
			ResultSet rs2 = state.executeQuery( SelectBD2 );
			
			if(rs1==rs2)
			{
				return false;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Se ha eliminado el producto", "Correcto",JOptionPane.INFORMATION_MESSAGE);
				return true;
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}*/
	
}

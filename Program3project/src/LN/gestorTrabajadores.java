package LN;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class gestorTrabajadores {

	/**
	 * Metodo que se encarga de comprobar si el DNI y la contrasenya introducidos para acceder como trabajador coinciden con alguna que este 
	 * guardada en la Base de Datos
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la Base de Datos que debe estar abierta anteriormente mediante connection
	 * @param DNI: Variable identificativa de cada trabajador
	 * @param contrasenya: Contrasenya que elige cada trabajador para que solo el pueda acceder a su perfil
	 * @return true en caso de que el DNI y la contrasenya introducidas coincidan con alguna guardada en la Base de Datos
	 */
	public boolean ValidarEntradaTrabajador(Statement state, String DNI, String contrasenya)
	{
		String SelectBD = "select * from TRABAJADOR where (dni_tra = '" + DNI + "' and contrasenya_tra = '" + contrasenya + "')";
		try 
		{
			ResultSet rs = state.executeQuery( SelectBD );
			if(rs.next())
			{
				rs.close();			
				JOptionPane.showMessageDialog(null, "DNI y contraseña correctas", "Correcto",JOptionPane.INFORMATION_MESSAGE);
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
	
	/**
	 * Metrodo que crea una fila en la tabla de productos, es decir crea un producto
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la Base de Datos que debe estar abierta anteriormente mediante connection
	 * @param cod_producto: Codigo identificativo de cada producto
	 * @param nom_producto: Nombre de cada producto
	 * @param categoria_producto: Categoría a la que pertenece cada producto
	 * @param precio_producto: Precio de cada producto
	 */
	public boolean CrearProcuto(Statement state, String cod_producto , String nom_producto ,String categoria_producto, double precio_producto)
	{
		try 
		{
			String SelectBD = "insert into PRODUCTO values(" + "'" + cod_producto + "', " + "'" + nom_producto + "', "+ "'" + categoria_producto +  "', "+ "'" +  precio_producto  + "')";
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
	
	/**
	 * Metodo que comprueba si el codigo introducido coincide con alguno introducido anteriormente
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la Base de Datos que debe estar abierta anteriormente mediante connection
	 * @param codigo: Variable identificativa de cada producto
	 * @return true en casod de que haya un producto con ese codigo
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
	
	/**
	 * Metodo que elimina el producto que se elija
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la Base de Datos que debe estar abierta anteriormente mediante connection
	 * @param cod_producto: Variable identificativa de cada vuelo y con la que se elegira que vuelo se desea eliminar
	 * @return true en caso de que se haya logrado eliminar el producto seleccionado
	 */
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
	}
	
}

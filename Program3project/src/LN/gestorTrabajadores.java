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

/**
 * 
 * Clase que relaciona la logica de presentacion (LP) con la logica de datos(LD).
 * La mayoria de los metodos que precisan informacion de la Base de Datos se encuentran en esta clase
 *
 */
public class gestorTrabajadores {

	static Statement state= BaseDatos.getStatement();
	java.sql.Connection con=  BaseDatos.getConnection();
	static ResultSetMetaData rm;
	static ResultSet rs;
	
	/**
	 * Metodo que se encarga de comprobar si el usuario y la contraseña introducidos para acceder como trabajador coinciden con alguna que este 
	 * guardada en la Base de Datos
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la Base de Datos que debe estar abierta anteriormente mediante connection
	 * @param usuario: Nombre de usuario
	 * @param contrasena: Contraseña para acceder como trabajador
	 * @return false en caso de que el usuario y la contraseña introducidas no coincidan con alguna guardada en la Base de Datos, si no, true
	 */
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
	
	/**
	 * Método mediante el cual crea una fila en la tabla de Productos, es decir crea un producto
	 * @param state:Objeto necesario para ejecutar una sentencia de SQL sobre la Base de Datos que debe estar abierta anteriormente mediante connection
	 * @param cod_producto: Código del producto
	 * @param nom_producto: Nombre del producto
	 * @param descripcion_producto: Descripción del producto
	 * @param categoria_producto: Categoría a la que pertenece el producto
	 * @param precio_producto: Precio del producto
	 */
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
	

	
	/**
	 * Método que llena la tabla producto
	 * @return datos, un array con todos los productos
	 */
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
	
	/**
	 * Metodo que comprueba si el codigo introducido coincide con alguno introducido anteriormente
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la Base de Datos que debe estar abierta anteriormente mediante connection
	 * @param cod: código de producto, identificativo en cada uno. 
	 * @return true en caso de que haya un producto con ese codigo, si no, false
	 */
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
	/**
	 * Método que elimina un producto
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la Base de Datos que debe estar abierta anteriormente mediante connection
	 * @param cod_producto: Código del producto
	 */
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
	/**
	 * Método que permite modificar un producto
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la Base de Datos que debe estar abierta anteriormente mediante connection
	 * @param codigo: Código del producto
	 * @param nombre: Nombre del producto
	 * @param descripcion: Descripción del producto
	 * @param categoria: Categoría a la que pertenece el producto
	 * @param precio: Precio del producto
	 */
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
	 /**
	  * Método que devuelve todos los productos
	  * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la Base de Datos que debe estar abierta anteriormente mediante connection
	  * @return arrayP, un array con todos los productos disponibles
	  */
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
	
	/**
	 * Método que elimina la tabla PRODUCTO
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la BD que debe estar abierta anteriormente mediante connection
	 */
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
}



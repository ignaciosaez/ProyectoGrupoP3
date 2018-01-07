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

/**
 * 
 * Clase que relaciona la LP con la LD. La mayoría de los métodos que precisan informacion de la BD se encuentran en esta clase.
 *
 */
public class gestorClientes 
{
	static Statement state= BaseDatos.getStatement();
	java.sql.Connection con=  BaseDatos.getConnection();
	static ResultSetMetaData rm;
	static ResultSet rs;
	
	/**
	 * 
	 * Método que añade un nuevo cliente a la BD
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la BD que debe estar abierta anteriormente mediante connection
	 * @param nombre: Nombre del cliente
	 * @param apellidos: Apellidos del cliente
	 * @param ciudad: Ciudad en la que reside el cliente
	 * @param direccion: Dirección del cliente
	 * @param usuario: Nombre del usuario para acceder al aplicación
	 * @param contrasena: Contraseña del usuario para acceder a la aplicación
	 * @return false en caso de que no se haya podido guardar el cliente en la Base de Datos, si no, true
	 */
	
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
	
	/**
	 * Método que comprueba si existe algun cliente que coincida con el usuario introducido, que es el identificativo de cada cliente
	 * @param state:  Objeto necesario para ejecutar una sentencia de SQL sobre la BD que debe estar abierta anteriormente mediante connection
	 * @param usuario: Nombre del usuario para acceder al aplicación
	 * @return true en caso de que haya algun cliente con el usuario introducido, si no, false
	 */
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
	 /**
	  * Método que comprueba si el usuario y contraseña introducidos por el cliente son correctos
	  * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la BD que debe estar abierta anteriormente mediante connection
	  * @param usuario: Nombre del usuario para acceder al aplicación
	  * @param contrasena: Contraseña del usuario para acceder a la aplicación
	  * @return true si existe algun cliente con la contraseña y usuario introducidos, si no, false
	  */
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
	
	/**
	 * Método mediante el cual crea una fila en la tabla de carritocompra 
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la BD que debe estar abierta anteriormente mediante connection
	 * @param cod_producto: Código del producto 
	 * @param nombre_producto: Nombre del producto
	 * @param precio: Precio del producto
	 * @param cantidad: Cantidad a comprar del producto
	 * @param usuario: Nombre del usuario
	 */
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
	
	/**
	 * Método mediante el cual llena la tabla carrito de compra
	 * @param usuario: Nombre del usuario
	 * @return devuelve un array denominado datos con los productos del carrito de compra
	 */
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
	
	/**
	 * Método mediante el cual se elimina un producto del carrito de la compra
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la BD que debe estar abierta anteriormente mediante connection
	 * @param cod: Código del producto
	 * @param usuario: Nombre del usuario
	 */
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
	
	/**
	 * Método mediante el cual devuelve la tabla carrito de la compra
	 * @param tabla: Tabla carrito de compra
	 * @param usuario: Nombre del usuario
	 * @return tabla de carrito compra
	 */
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
	
	/**
	 * Método que calcula el importe total a pagar en una compra
	 * @param tabla: Tabla de carrito compra
	 * @return total, que indica el total a pagar en una compra
	 */
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
	/**
	 * Método que elimina la tabla compra
	 * @param state: Objeto necesario para ejecutar una sentencia de SQL sobre la BD que debe estar abierta anteriormente mediante connection
	 */
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

package LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class BaseDatos 
{
	private static Connection connection = null;
	private static Statement statement = null;
	
	/**
	 * Carga SQLite-JDBC driver usando el cargador de clases
	 * Crea la conexión a la Base de Datos
	 * Es el primer metodo al que se debe llamar para poder empezar a trabajar con la Base de Datos
	 * @param BD Nombre de la Base de Datos
	 * @return la conexión con la Base de Datos, en caso de que haya error devolvera null
	 */
	public static Connection initBD (String BD)
	{
		try 
		{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:" + BD );
			statement = connection.createStatement();
			/*Se pone un timeout de 30 msg porque al crear un statement puede quedarse atascado, 
			 * para que no ocurra lo cerramos y nos notificará de un error
			 */
			statement.setQueryTimeout(30); 
			//JOptionPane.showMessageDialog(null, "La Base de Datos se ha conectado");
			return connection;
		} catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "La base de datos no se ha podido conectar");
			return null;
		}
	}
	  
	/**
	 * Cierra la conexion de la Base de Datos. En caso de que haya error se notificara mediante JOptionPane
	 */
	public static void close()
	{
		 if(statement != null)
		try
		 {
			statement.close();
			connection.close();
		 } catch (SQLException e)
		 {
			JOptionPane.showMessageDialog(null, "El cierre de la conexión ha fallado");
		}
	}

	/**
	 * Devuelve la conexión con la Base de Datos
	 * @return la conexión con la Base de Datos
	 */
	public static Connection getConnection()
	{
		return connection;
	}
	
	/**
	 * Recupera el objeto tipo Statement que genero el ResulSet. Si el conjunto de resultados se llevo a cabo de alguna otra 
	 * manera devolvera null.
	 * @return objeto Statement que sera null en caso de que se llevara a cabo de otra manera
	 */
	public static Statement getStatement()
	{
		return statement;
	}
	
	/** 
	 * Crea una tabla de clientes en una base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaClienteBD()
	{
		if (statement==null) return; 
		try 
		{
			statement.executeUpdate("create table if not exists CLIENTE ( nombre string, apellido string, ciudad string, direccione string , usuario string, contrasena string )");
			//JOptionPane.showMessageDialog(null, "La creación de tabla esta bien");  
	} catch (SQLException e)  
		{
			JOptionPane.showMessageDialog(null, "La creación de tabla CLIENTE ha fallado");  
		}
	}
	
	/** 
	 * Crea una tabla de trabajadores en una base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaTrabajadorBD()
	{
		if (statement==null) return; 
		try 
		{
			statement.executeUpdate("create table if not exists TRABAJADOR( nombre string, apellido string, DNI string,contrasenya string,usuario string )");
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "La creación de tabla TRABAJADOR ha fallado");  //Señal de que la tabla ya existe
		}
	}
	
	/** 
	 * Crea una tabla de vuelos en una base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	public static void crearTablaProductosBD()
	{
		if (statement==null) return; 
		try 
		{
			statement.executeUpdate("create table if not exists PRODUCTO ( cod_producto string,nombre_producto, descripcion_producto string, categoria_producto string, precio_producto double  )");
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "La creación de tabla PRODUCTO ha fallado"); 
		}
	}
	
	public static void crearTablaCompraBD()
	{
		if (statement==null) return; 
		try 
		{
			statement.executeUpdate("create table if not exists CARRITOCOMPRA ( cod_producto string,nombre_producto, precio_producto double, cantidad int, usuario string  )");
		} catch (SQLException e) 
		{
			JOptionPane.showMessageDialog(null, "La creación de tabla CARRITOCOMPRA ha fallado"); 
		}
	}
	/** 
	 * Crea una tabla de billetes en una base de datos, si no existía ya.
	 * Debe haberse inicializado la conexión correctamente.
	 */
	
	public static void InsertarTrabajadores(Statement statement)
	{
		if(statement==null)
		{
			
		}
		else
		{
			try 
			{
				statement.executeUpdate("insert into TRABAJADOR values('MIKEL','AGUIRIANO', '7233432', 'MIKELO','MIKELO96' )");
				statement.executeUpdate("insert into TRABAJADOR values('IGNACIO','GARBIZU', '723341212', 'GARBI','GARBI' )");
				statement.executeUpdate("insert into TRABAJADOR values('JORGE','ECHEVERRIA', '723343A2', 'GIORGIO','GIORGIO' )");
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}		
	}
	
	
	
	
	
	
}

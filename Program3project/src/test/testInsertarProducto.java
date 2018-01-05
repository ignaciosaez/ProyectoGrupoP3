package test;

import static org.junit.Assert.*;

import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.BaseDatos;
import LN.gestorClientes;
import LN.gestorTrabajadores;

public class testInsertarProducto {
	
	gestorTrabajadores objt ;

	@Before
	public void setUp() throws Exception
	{
		objt= new gestorTrabajadores();
		BaseDatos.initBD("AmazonTestBD");
		BaseDatos.crearTablaProductosBD();
	}

	@After
	public void tearDown() throws Exception 
	{
		
		objt.eliminarTablaProducto(BaseDatos.getStatement());
		//elimino la tabla para que pueda funcionar mas de una vez
		BaseDatos.close();
		
	}

	@Test
	public void testInsertarProducto() 
	
	{
		
		objt.CrearProcuto(BaseDatos.getStatement(), "cod1", "ps4", "aaa", "consolas", 200);
		objt.CrearProcuto(BaseDatos.getStatement(), "cod2", "ps3", "aaa", "consolas", 200);
		objt.CrearProcuto(BaseDatos.getStatement(), "cod3", "ps3", "aaa", "consolas", 200);
		
		int productosahora=objt.DevolverProductos(BaseDatos.getStatement()).size();
		//te devuelve el numero de productos que hay 3
		objt.CrearProcuto(BaseDatos.getStatement(), "cod4", "ps3", "aaa", "consolas", 200);
		objt.CrearProcuto(BaseDatos.getStatement(), "cod4", "ps3", "aaa", "consolas", 200);
		int productosdespues= objt.DevolverProductos(BaseDatos.getStatement()).size();
		//te devuelve el numero de productos que hay 5
		
		
		assertEquals(productosahora+productosdespues, 8);
		
	}

}

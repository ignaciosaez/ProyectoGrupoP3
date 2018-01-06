package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import LD.BaseDatos;
import LN.gestorClientes;
import LN.gestorTrabajadores;

public class testValidacionContrasenaCliente {
	gestorClientes obj ;
	@Before
	public void setUp() throws Exception 
	{
		obj= new gestorClientes();
		BaseDatos.initBD("AmazonTestBD");
		BaseDatos.crearTablaClienteBD();
	}

	@After
	public void tearDown() throws Exception 
	{
		BaseDatos.close();
	}

	@Test
	public void testSiExisteUsuario() 
	
	{
		boolean existe;
		
		
		String usuario= "IGNA";
		String contrasena="72553";
		obj.añadirNuevoCliente(BaseDatos.getStatement(), "iñaki", "saez", "San Sebastian", "xxx", "IGNA", "72553");
		existe=obj.validacionUsuarioContrasenaCliente(BaseDatos.getStatement(), usuario, contrasena);
		assertTrue(existe);
		
	}
	@Test
	
	public void testNoExisteUsuario() 
	
	{
		boolean noexiste;
		String usuarionoexistente="AAA";
		String contrasenanoexistente="11111";
		obj.añadirNuevoCliente(BaseDatos.getStatement(), "iñaki", "saez", "San Sebastian", "xxx", "IGNA", "72553");
		
		noexiste= obj.validacionUsuarioContrasenaCliente(BaseDatos.getStatement(), usuarionoexistente, contrasenanoexistente);
		
		assertFalse(noexiste);
	}
}

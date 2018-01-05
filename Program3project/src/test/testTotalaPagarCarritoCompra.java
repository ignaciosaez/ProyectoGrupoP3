/* test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.corba.se.pept.transport.Connection;

import LD.BaseDatos;
import LN.gestorClientes;
import junit.framework.TestCase;

public class testTotalaPagarCarritoCompra extends TestCase {

	gestorClientes objC;
	JTable tablatest;
	Connection con=  (Connection) BaseDatos.getConnection();
	Statement state= BaseDatos.getStatement();
	@Override
	protected void setUp() 
	{
		 objC= new gestorClientes();
		
		BaseDatos.initBD("AmazonTestBD");
		BaseDatos.crearTablaCarritoCompraBD(); 
		
	}
	
	@Override
	protected void tearDown() throws Exception
	{
		BaseDatos.close();
	}

	@Test
	public void testComprarBilletes()
	{	
	
		
		objC.ComprarProducto(BaseDatos.getStatement(),"ada23sw","PS44",300.0, 2,"LEOMESSI");
		objC.ComprarProducto(BaseDatos.getStatement(),"adaS3214w","XBOXONE",275, 1,"LEOMESSI");
		
		tablatest= objC.devolverTabla(null);
		double total= 875.0;
		
		
		double totalgestor= objC.totalPAGAR(tablatest);
		System.out.println(totalgestor);
		assertEquals(total, totalgestor);
	}


}
*/
package LN;

public class clsCliente extends clsPersona
{
	
	private String ciudad_cliente;
	private String direc_cliente;
	
	
	public clsCliente(String usuario_cliente,String ciudad_cliente,String direc_cliente) 
	{
		super();
		this.ciudad_cliente= ciudad_cliente;
		this.direc_cliente= direc_cliente;
	}




	public String getCiudad_cliente() {
		return ciudad_cliente;
	}


	public void setCiudad_cliente(String ciudad_cliente) {
		this.ciudad_cliente = ciudad_cliente;
	}


	public String getDirec_cliente() {
		return direc_cliente;
	}


	public void setDirec_cliente(String direc_cliente) {
		this.direc_cliente = direc_cliente;
	}
	
	
	

}

package LN;

public class clsTrabajador extends clsPersona  
{
	private String usuario;
	private String cargo;
	
	
	public clsTrabajador(String usuario)
	{
		super();
		this.usuario= usuario;
		this.cargo= cargo;
		
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String toString()
	{		
		StringBuffer salida = new StringBuffer();
	
		salida.append(super.toString());
		salida.append("cargo en la compañía:");
		salida.append(this.getCargo());
	
	
		return salida.toString();
	}
}

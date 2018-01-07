package LN;

/**
 * 
 * Método que permite crear objetos de tipo clsTrabajador. Extiende de clsPersona.
 */
public class clsTrabajador extends clsPersona  
{
	private String DNI;
	private String cargo_trabajador;
	
	/**
	 * Constructor
	 * @param usuario_trabajador: Nombre de usuario trabajador
	 * @param cargo_trabajador: Cargo del trabajador
	 */
	
	public clsTrabajador(String usuario_trabajador, String cargo_trabajador)
	{
		super();
		this.cargo_trabajador= cargo_trabajador;
		
	}




	public String getCargo() {
		return cargo_trabajador;
	}


	public void setCargo(String cargo_trabajador) {
		this.cargo_trabajador = cargo_trabajador;
	}
	
	/**
	 * Método que permite sacar los datos de trabajadores por pantalla
	 */
	public String toString()
	{		
		StringBuffer salida = new StringBuffer();
	
		salida.append(super.toString());
		salida.append("cargo en la compañía:");
		salida.append(this.getCargo());
	
	
		return salida.toString();
	}
}

package LN;

import java.io.Serializable;

public class clsPersona implements Serializable 
{
	private String nombre;
	private String apellido;
	private String DNI;
	private String contrasenya;
	
	public clsPersona()
	{
		
	}
	
	public clsPersona(String nombre, String contrasenya) 
	{
		
		this.nombre = nombre;
		this.apellido= apellido;
		
		this.contrasenya = contrasenya;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	@Override
	public String toString() {
		
		StringBuffer salida = new StringBuffer();
		
		salida.append("Nombre: ");
		salida.append(this.getNombre());
		salida.append("Apellido");
		salida.append(this.getApellido());
		salida.append("D.N.I: ");
		salida.append(this.getDNI());
		salida.append("Contraseña:");
		salida.append(this.getContrasenya());
		
		return salida.toString();
	}
	
}

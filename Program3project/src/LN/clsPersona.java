package LN;

import java.io.Serializable;

/**
 * 
 * Clase que permite crear objetos clsPersona. Implementa serializable. 
 *
 */

public class clsPersona implements Serializable 
{
	private String nombre;
	private String apellidos;
	private String usuario;
	private String contrasenya;
	
	/**
	 * Constructor sin parámetros
	 */
	public clsPersona()
	{
		
	}
	
	/**
	 * Constructor con parámetros
	 * @param nombre: Nombre de la persona
	 * @param contrasenya: Contraseña para acceder a la aplicación
	 */
	public clsPersona(String nombre, String contrasenya) 
	{
		
		this.nombre = nombre;
		this.apellidos= apellidos;
		this.usuario=usuario;
		this.contrasenya = contrasenya;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellidos;
	}
	public void setApellido(String apellido) {
		this.apellidos = apellido;
	}
	

	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	/**
	 * Método que hace posible sacar los datos de personas por pantalla
	 */
	@Override
	public String toString() {
		
		StringBuffer salida = new StringBuffer();
		
		salida.append("Nombre: ");
		salida.append(this.getNombre());
		salida.append("Apellido");
		salida.append(this.getApellido());
		salida.append("Contraseña:");
		salida.append(this.getContrasenya());
		
		return salida.toString();
	}
	
}

package LN;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * Clase que permite crear objetos de tipo clsCompra. Implementa serializable.
 *
 */
public class clsCompra implements Serializable
{
	double precio;
	String codigo_producto;
	String nombre_producto;
	int cantidad;
	ArrayList carritoCompra;
	
	/**
	 * Costructor
	 * @param precio: Precio de la compra
	 * @param codigo: Codigo de compra
	 * @param nombre: Nombre de compra
	 * @param cantidad: Cantidad de compra
	 * @param carritoCompra: Array con los productos comprados
	 */
	
	public clsCompra(double precio,String codigo,String nombre,int cantidad, ArrayList carritoCompra)
	{
		this.precio= precio;
		this.codigo_producto=codigo;
		this.nombre_producto=nombre;
		this.cantidad=cantidad;
		this.carritoCompra=carritoCompra;
	}
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(String codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public ArrayList getCarritoCompra() {
		return carritoCompra;
	}
	public void setCarritoCompra(ArrayList carritoCompra) {
		this.carritoCompra = carritoCompra;
	}
}

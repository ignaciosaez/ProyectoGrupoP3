package LN;

import java.io.Serializable;

public class clsProducto implements Serializable
{
	 private String cod_producto;
	 private  String nom_producto;
	 private String descripcion_producto;
	 private String categoria_producto;
	 private double precio_producto;
	 


	 
	 public clsProducto(String cod_producto,String nom_producto, String descripcion,double precio_producto )
	 {
		 
		 this.cod_producto= cod_producto;
		 this.nom_producto= nom_producto;
		 this.descripcion_producto=descripcion;
		 this.categoria_producto= cod_producto;
		 this.precio_producto= precio_producto;
	 }
	 
	public String getCod_producto() {
		return cod_producto;
	}

	public void setCod_producto(String cod_producto) {
		this.cod_producto = cod_producto;
	}

	public String getNom_producto() {
		return nom_producto;
	}

	public void setNom_producto(String nom_producto) {
		this.nom_producto = nom_producto;
	}

	public double getPrecio_producto() {
		return precio_producto;
	}

	public void setPrecio_producto(float precio_producto) {
		this.precio_producto = precio_producto;
	}

	public String getCategoria_producto() {
		return categoria_producto;
	}

	public void setCategoria_producto(String categoria_producto) {
		this.categoria_producto = categoria_producto;
	}
	public String getDescripcion_producto() {
		return descripcion_producto;
	}

	public void setDescripcion_producto(String descripcion_producto) {
		this.descripcion_producto = descripcion_producto;
	}

	public void setPrecio_producto(double precio_producto) {
		this.precio_producto = precio_producto;
	}
	public String toString()
	{		
		StringBuffer salida = new StringBuffer();
	
		
		salida.append("Código producto:");
		salida.append(this.getCod_producto());
		salida.append("Descripción producto:");
		salida.append(this.getNom_producto());
		salida.append("Categoría del producto:");
		salida.append(this.getCategoria_producto());
		salida.append("Precio:");
		salida.append(this.getPrecio_producto());
	
		return salida.toString();
	}
}

package Entidades;

import Entidades.Producto;

public class ItemCarrito {

	private int cantidad;
	private Producto producto;
	
	public ItemCarrito() {}
	
	public ItemCarrito(int cantidad, Producto producto)
	{
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
	public int getCantidad()
	{
		return this.cantidad;
	}

	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public Producto getProducto()
	{
		return this.producto;
	}
	
	public void setProducto(Producto item)
	{
		this.producto = item;
	}
	
	public float precio()
	{
		return cantidad * producto.getPrecio();
	}
	
	
}

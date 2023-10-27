package Entidades;

import java.util.Scanner;

public class Producto {

	private static float precio;
	private static String nombre;
	
	public Producto(int precio, String nombre)
	{
		this.precio = precio;
		this.nombre = nombre;
	}
	
	public Producto()
	{
		this.precio = -1;
		this.nombre = "sin cargar";
	}

	public void setPrecio(float precio)
	{
		this.precio = precio;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getNombre()
	{
		return this.nombre;
	}
	
	public float getPrecio()
	{
		return this.precio;
	}
	
	public void cargarProducto()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nombre: ");
		this.nombre = sc.nextLine();
		float p = 0;
		while(p <= 0)
		{
			System.out.print("Precio: ");
			p = sc.nextFloat();
		}
		setPrecio(p);
	}
}

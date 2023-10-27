package Entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Excepciones.InformacionDuplicadaException;

public class Archivo_Estante {
	private static String nombre;
	
	public Archivo_Estante(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	

	public static void MostrarEstante()
	{
		try (FileReader fr = new FileReader(nombre);
	    BufferedReader br = new BufferedReader(fr))
		{
			String linea;
			System.out.println("Contenido del archivo:");
			int cont = 1;
			while ((linea = br.readLine()) != null)
			{
				System.out.println("Producto #" + cont);
				String[] part = linea.split(",");
				System.out.println("Nombre: " + part[1]);
				System.out.println("Precio: $" + part[0]);
				cont++;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Producto ObtenerProducto(String buscar)
	{
		Producto obj = new Producto();
		try (FileReader fr = new FileReader(nombre);
		BufferedReader br = new BufferedReader(fr))
	    {
			String linea;
	        while ((linea = br.readLine()) != null)
	        {
	        	String[] prod_Partes= linea.split(",");
	            if(prod_Partes[1].equals(buscar))
	            {
	            	obj = new Producto(Integer.parseInt(prod_Partes[0]), prod_Partes[1]);
	            	br.close();
	            	return obj;
	            }
	        }
	    } catch (IOException e)
	    {
	    	e.printStackTrace();
	    }
		return obj;
	}
	
	public static void cargarEstante()
	{
		Producto estante = new Producto();
		estante.cargarProducto();
		try
		{
            guardar(
            	nombre,
            	Float.toString(estante.getPrecio()) + "," + estante.getNombre());
        } catch (InformacionDuplicadaException e)
		{
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e)
		{
            System.out.println("Error al manipular el archivo: " + e.getMessage());
        }
	}
	
	public static void guardar(String nombreArchivo, String informacion)
            throws InformacionDuplicadaException, IOException
	{
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo)))
        {
            String linea;
            while ((linea = br.readLine()) != null)
            {
                if (linea.equals(informacion))
                {
                    throw new InformacionDuplicadaException();
                }
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo, true)))
        {
            bw.write(informacion);
            bw.newLine();
        }
    }
}

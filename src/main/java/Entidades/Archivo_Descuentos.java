package Entidades;

import Excepciones.InformacionDuplicadaException;

import java.io.*;

public class Archivo_Descuentos
{
    private static String nombre;

    public Archivo_Descuentos(String nombre)
    {
        this.nombre = nombre;
    }
    public void setNombre(String nombre){ this.nombre = nombre; }
    public String getNombre()
    {
        return nombre;
    }

    public static double ObtenerDescuento(String buscar)
    {
        try (FileReader fr = new FileReader(nombre);
             BufferedReader br = new BufferedReader(fr))
        {
            String linea;
            //revisa el archivo
            while ((linea = br.readLine()) != null)
            {
                String[] desc_part= linea.split(",");
                // compara el producto
                if(desc_part[0].equals(buscar))
                {
                    return Double.parseDouble(desc_part[1]); //devuelve el descuento
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return 0; //no hubo descuento
    }
}

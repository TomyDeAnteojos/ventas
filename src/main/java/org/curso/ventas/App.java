package org.curso.ventas;

import Entidades.*;
import Excepciones.*;
import java.util.Scanner;


public class App
{
    public static void main(String[] args)
    {
        Archivo_Estante archivo = new Archivo_Estante("src\\main\\java\\Source\\productos.txt");
        while (true)
        {
            switch (pedirOpcion()) {
                case 1:
                    archivo.cargarEstante();
                    break;
                case 2:
                    archivo.MostrarEstante();
                    break;
                case 3:
                    try {
                        Comprar();
                    } catch (InformarProductoNoExistente e) {
                        throw  new RuntimeException();
                    } catch (InformarMontoMinimo e) {
                        throw new RuntimeException();
                    } catch (Exception e)
                    {
                        System.out.println("otro error");
                    }
                    break;
            }
        }
    }

    public static int pedirOpcion()
    {
        int op;
        Scanner sc = new Scanner(System.in);
        System.out.print(
                "--------- MENU CARRITO ---------\n"
                        + "1. Cargar Estante.\n"
                        + "2. Mostrar Estante.\n"
                        + "3. Cargar Carrito.\n"
                        + "Opcion: ");
        op = sc.nextInt();
        return op;
    }

    public static void Comprar() throws
            InformarProductoNoExistente,
            InformarMontoMinimo
    {
        Scanner sc = new Scanner(System.in);

        String ruta_productos = "src\\main\\java\\Source\\productos.txt";
        Archivo_Estante arc = new Archivo_Estante(ruta_productos);
        Carrito car = new Carrito();
        int op = 1;

        while(op == 1)
        {

            System.out.print("Ingrese un producto: ");
            String nombre = sc.nextLine();
            System.out.print("Ingrese cantidad: ");
            int cantidad = sc.nextInt();

            {
                Archivo_Estante arcEst = new Archivo_Estante(ruta_productos);
                ItemCarrito auxItem = new ItemCarrito();
                auxItem.setProducto(arcEst.ObtenerProducto(nombre));
                auxItem.setCantidad(cantidad);

                try
                {
                    System.out.println(auxItem.getProducto().getPrecio());
                    if (auxItem.getProducto().getPrecio() == -1)
                    {
                        throw new InformarProductoNoExistente();
                    }
                }catch (InformarProductoNoExistente e)
                {
                    System.out.println("El producto no existe");
                } catch (Exception e)  {
                    e.printStackTrace();

                }
                finally {
                    car.setItem(auxItem);

                }

            }

            System.out.println("Seguir agregando productos(ingrese 1): ");
            op = sc.nextInt();
        }
        if( car.contarLista() == 0)
        {
            System.out.println("No se encontraron productos cargados.");
        } else
        {
            car.precio();
        }



    }
}
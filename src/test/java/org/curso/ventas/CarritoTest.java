package org.curso.ventas;

import org.junit.Test;
import Entidades.Carrito;
import Entidades.ItemCarrito;
import Entidades.Producto;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CarritoTest
{
    //TAREAS
    /*
    1- MOSTRAR SALDO NEGATIVO
    2- MOSTRAR CARRITO VACIO
    3- MOSTRAR NO SE ENCONTRO DESCUENTO
    */

    @Test
    public void TestSaldoNegativo()
    {
        Producto prod = new Producto(1,"a");
        ItemCarrito ic = new ItemCarrito(20,prod);
        Carrito cr = new Carrito();
        cr.setItem(ic);
        double precio = cr.precio(1) + cr.precio(2);
        assertTrue( precio >= 10);
    }

    @Test
    public void TestCarritoVacio()
    {
        Carrito cr = new Carrito();
        assertEquals(cr.contarLista() == 0, true);
    }

    @Test
    public void TestNoHayDescuento()
    {
        Producto prod = new Producto(10,"z");
        ItemCarrito ic = new ItemCarrito();
        ic.setProducto(prod);
        ic.setCantidad(1);
        Carrito cr = new Carrito();
        cr.setItem(ic);
        double descuento = cr.precio(1)+ cr.precio(2);


        assertEquals(descuento == 0, true);
    }
}

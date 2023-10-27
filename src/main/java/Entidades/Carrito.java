package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Entidades.ItemCarrito;

public class Carrito {
	
	private LocalDate fecha;
	private List<ItemCarrito> items;
	public Carrito() 
	{
		this.fecha = LocalDate.now();
		List<ItemCarrito> items = new ArrayList<ItemCarrito>();
	}
	public LocalDate getFecha() {
	    return fecha;
	}
	public void setFecha(LocalDate fecha) {
	    this.fecha = fecha;
	}
	public List<ItemCarrito> getItem() {
		List<ItemCarrito> items1 = new ArrayList<ItemCarrito>();
		items1.addAll(this.items);
		return items1;
	}
	public void setItem(ItemCarrito ic) { this.items.add(ic);
		System.out.println("hola");}
	public void quitarItem(ItemCarrito ic) { this.items.remove(ic); }
	public double precio()
	{
		String desc_fijo = "src\\main\\java\\Source\\descuento_fijo.txt";
		String desc_procentaje = "src\\main\\java\\Source\\descuento_procentaje.txt";

		Double costoFinal = 0.0;
		for(ItemCarrito item : this.items) {
			Archivo_Descuentos arc_descuento = new Archivo_Descuentos(desc_fijo);
			double precio_desc = item.getProducto().getPrecio();

			if(arc_descuento.ObtenerDescuento(item.getProducto().getNombre()) > 0)
			{
				precio_desc = arc_descuento.ObtenerDescuento(item.getProducto().getNombre());
				System.out.println("Descuento a $" + precio_desc);
			}

			costoFinal += precio_desc * item.getCantidad();
		}
		System.out.println("precio final: " + costoFinal);
		return costoFinal;
	}

	public int contarLista() {
		List<ItemCarrito> items1 = new ArrayList<ItemCarrito>();
		items1 = this.getItem();
		int cantidadItems = 0;
		for (ItemCarrito item : items1) {
			cantidadItems += item.getCantidad();
		}
		return cantidadItems;
	}
}

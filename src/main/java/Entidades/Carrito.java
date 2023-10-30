package Entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	
	private LocalDate fecha;
	private List<ItemCarrito> items;
	public Carrito() 
	{
		this.fecha = LocalDate.now();
		this.items = new ArrayList<ItemCarrito>();
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
	public void setItem(ItemCarrito ic)
	{
		this.items.add(ic);
	}
	public void quitarItem(ItemCarrito ic) { this.items.remove(ic); }
	public double precio(int archivo)
	{
		String desc_fijo = "src\\main\\java\\Source\\descuento_fijo.txt";
		String desc_procentaje = "src\\main\\java\\Source\\descuento_porcentaje.txt";

		Double costoFinal = 0.0;
		double precio_desc = 0.0;
		for(ItemCarrito item : this.items) {

			Archivo_Descuentos arc_descuento;
			if(archivo == 1)
			{
				arc_descuento = new Archivo_Descuentos(desc_fijo);
			} else
			{
				arc_descuento = new Archivo_Descuentos(desc_procentaje);
			}


			if(arc_descuento.ObtenerDescuento(item.getProducto().getNombre()) > 0)
			{
				if(archivo == 1)
				{
					precio_desc +=
						item.getProducto().getPrecio() -
 						arc_descuento.ObtenerDescuento(item.getProducto().getNombre());
				} else
				{
					precio_desc +=
							item.getProducto().getPrecio() -
							item.getProducto().getPrecio() *
							arc_descuento.ObtenerDescuento(item.getProducto().getNombre());
				}
			}
			costoFinal += precio_desc * item.getCantidad();
		}

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

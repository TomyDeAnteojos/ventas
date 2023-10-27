package Entidades;

import  java.time.LocalDate;

public class DescuentoFijo extends Descuento
{
    private double monto;

    public DescuentoFijo(LocalDate comienzo, LocalDate fin)
    {
        super(comienzo, fin);
    }

    public void setMonto(int monto)
    {
        this.monto = monto;
    }

    @Override
    public double descuento(double base)
    {
        return base - monto;
    }
}

package Entidades;

import java.time.LocalDate;

public class DescuentoPorcentaje extends Descuento
{
    private Double porcentaje;

    public DescuentoPorcentaje(LocalDate inicio, LocalDate fin)
    {
        super(inicio,fin);
    }

    @Override
    public double descuento(double base)
    {
        return base - (base * porcentaje / 100.0);
    }
}

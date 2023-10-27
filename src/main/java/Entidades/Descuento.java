package Entidades;

import java.time.LocalDate;
public abstract class Descuento
{
    private LocalDate comienzo;
    private LocalDate fin;

    public Descuento(LocalDate comienzo, LocalDate fin)
    {
        this.comienzo = comienzo;
        this.fin = fin;
    }

    public abstract double descuento(double base);
}

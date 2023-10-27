package Excepciones;

public class InformarMontoMinimo extends Exception
{
    public InformarMontoMinimo()
    {
        super("El producto no supera los $10.");
    }
}

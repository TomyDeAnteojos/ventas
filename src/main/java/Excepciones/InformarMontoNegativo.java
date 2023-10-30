package Excepciones;

public class InformarMontoNegativo extends Exception
{
    public InformarMontoNegativo()
    {
        super("el monto es negativo");
    }
}

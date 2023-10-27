package Excepciones;

public class InformarProductoNoExistente extends Exception
{
    public InformarProductoNoExistente()
    {
        super("El producto no se encuentra cargado dentro del archivo.");
    }
}

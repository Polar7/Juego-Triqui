package modelo;

public class Casilla
{

    public enum Estado
    {
        VACIA, OCUPADA, LINEACOMPLETADA
    }

    public enum Figura
    {
        EQUIS, CIRCULO, TRIANGULO, ESTRELLA
    }

    private Estado estado;
    private Figura figura;


    public Casilla()
    {
        estado = null;
        figura = null;
    }

    public Estado getEstado()
    {
        return estado;
    }

    public Figura getValor()
    {
        return figura;
    }

    public void setEstado (Estado pEstado)
    {
        switch (pEstado)
        {
            case VACIA:
                estado = Estado.VACIA;
                break;
            case OCUPADA:
                estado = Estado.OCUPADA;
                break;
            case LINEACOMPLETADA:
                estado = Estado.LINEACOMPLETADA;
                break;
        }
    }

    public void setValor (Figura pFigura)
    {
        switch (pFigura)
        {
            case EQUIS:
                figura = Figura.EQUIS;
                break;
            case CIRCULO:
                figura = Figura.CIRCULO;
                break;
            case TRIANGULO:
                figura = Figura.TRIANGULO;
                break;
            case ESTRELLA:
                figura = Figura.ESTRELLA;
                break;
        }
    }







}

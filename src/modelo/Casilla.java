package modelo;

public class Casilla
{

    public enum Estado
    {
        VACIA, OCUPADA, LINEACOMPLETADA
    }

    public enum Valor
    {
        EQUIS, CIRCULO, TRIAGULO, ESTRELLA, BLANCO
    }

    private Estado estado;
    private Valor valor;

    public Estado getEstado()
    {
        return estado;
    }

    public Valor getValor()
    {
        return valor;
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

    public void setValor (Valor pValor)
    {
        switch (pValor)
        {
            case EQUIS:
                valor = Valor.EQUIS;
                break;
            case CIRCULO:
                valor = Valor.CIRCULO;
                break;
            case TRIAGULO:
                valor = Valor.TRIAGULO;
                break;
            case ESTRELLA:
                valor = Valor.ESTRELLA;
            case BLANCO:
                valor = Valor.BLANCO;
        }
    }







}

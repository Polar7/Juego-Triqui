package modelo;

public class Jugador
{

    private String nombre;

    private String cadenaFigura;

    private boolean esSuTurno;

    private Casilla.Figura figura;

    private boolean esGanador;

    public Jugador (String pNombre, String pValorFigura)
    {
        nombre = pNombre;
        cadenaFigura = pValorFigura;
        esSuTurno = false;
        figura = null;
        esGanador = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCadenaFigura() {
        return cadenaFigura;
    }

    public void setCadenaFigura(String cadenaFigura) {
        this.cadenaFigura = cadenaFigura;
    }

    public boolean isEsSuTurno() {
        return esSuTurno;
    }

    public void setEsSuTurno(boolean esSuTurno) {
        this.esSuTurno = esSuTurno;
    }

    public Casilla.Figura getFigura() {
        return figura;
    }

    public boolean isEsGanador() {
        return esGanador;
    }

    public void setEsGanador(boolean esGanador) {
        this.esGanador = esGanador;
    }

    public void asignarFigura(String pCadenaFigura)
    {
        if(pCadenaFigura.equals(Casilla.Figura.EQUIS.toString()))
        {
            figura = Casilla.Figura.EQUIS;
        }
        else if (pCadenaFigura.equals(Casilla.Figura.CIRCULO.toString()))
        {
            figura = Casilla.Figura.CIRCULO;
        }
        else if (pCadenaFigura.equals(Casilla.Figura.TRIANGULO.toString()))
        {
            figura = Casilla.Figura.TRIANGULO;
        }
        else if (pCadenaFigura.equals(Casilla.Figura.ESTRELLA.toString()))
        {
            figura = Casilla.Figura.CIRCULO;
        }
    }


}

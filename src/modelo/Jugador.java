package modelo;

public class Jugador
{

    private String nombre;

    private String valorFigura;

    private boolean esSuTurno;

    public Jugador (String pNombre, String pValorFigura)
    {
        nombre = "";
        valorFigura = "";
        esSuTurno = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValorFigura() {
        return valorFigura;
    }

    public void setValorFigura(String valorFigura) {
        this.valorFigura = valorFigura;
    }

    public boolean isEsSuTurno() {
        return esSuTurno;
    }

    public void setEsSuTurno(boolean esSuTurno) {
        this.esSuTurno = esSuTurno;
    }


}

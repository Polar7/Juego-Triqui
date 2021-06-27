package modelo;

import java.io.Serializable;

public class Historial_partidasDTO implements Dto, Serializable
{


    private static final long serialVersionUID = 568794L;

    private String nombreJugador1;
    private String nombreJugador2;
    private String nombreGanador;

    public Historial_partidasDTO (String pNombreJ1, String pNombreJ2, String pNombreGanador)
    {
        nombreJugador1 = pNombreJ1;
        nombreJugador2 = pNombreJ2;
        nombreGanador = pNombreGanador;
    }

    @Override
    public String insert()
    {
        String sql = "INSERT INTO public.historial_partidas(nombre_jugador1, nombre_jugador2, nombre_ganador) VALUES ('"
                + nombreJugador1.trim() + "','"
                + nombreJugador2.trim() + "','"
                + nombreGanador.trim() + "')";
        System.out.println(sql);
        return sql;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombreUsuario;
    private List<Barco> barcos = new ArrayList<>();
    private Tablero tableroPropio;
    private Tablero tableroEnemigo;

    public Jugador(String nombreUsuario, Tablero tableroPropio, Tablero tableroEnemigo) {
        this.nombreUsuario = nombreUsuario;
        this.tableroPropio = tableroPropio;
        this.tableroEnemigo = tableroEnemigo;
    }

    public boolean colocarBarco(Barco barco, List<Coordenada> posiciones) {
        if (tableroPropio.validarColocacion(barco, posiciones)) {
            barco.colocar(posiciones);
            barcos.add(barco);
            return true;
        }
        return false;
    }

    public boolean tieneBarcosVivos() {
        for (Barco barco : barcos) {
            if (!barco.estaHundido()) return true;
        }
        return false;
    }

    public boolean atacar(Coordenada coord) {
        for (Barco barco : barcos) {
            if (barco.recibirImpacto(coord)) {
                tableroEnemigo.actualizarCasilla(coord, "impacto");
                return true;
            }
        }
        tableroEnemigo.actualizarCasilla(coord, "fallo");
        return false;
    }
}

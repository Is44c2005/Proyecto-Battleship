import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jugador {
    private String nombreUsuario;
    private List<Barco> barcos = new ArrayList<>();
    public Tablero tableroPropio;
    private Tablero tableroEnemigo;

    public Jugador(String nombreUsuario, Tablero tableroPropio, Tablero tableroEnemigo) {
        this.nombreUsuario = nombreUsuario;
        this.tableroPropio = tableroPropio;
        this.tableroEnemigo = tableroEnemigo;
    }

    public boolean colocarBarco(Barco barco, List<Coordenada> posiciones) throws CoordenadaOcupadaException, CoordenadaInvalidaException {
        for (Coordenada coord : posiciones) {
            if (!tableroPropio.estaDentroDelTablero(coord)) {
                throw new CoordenadaInvalidaException("La coordenada está fuera del tablero.");
            }
            if (tableroPropio.estaOcupada(coord)) {
                throw new CoordenadaOcupadaException("La casilla ya está ocupada por otro barco.");
            }
        }

        Set<Coordenada> coordenadasUnicas = new HashSet<>(posiciones);
        if (coordenadasUnicas.size() != posiciones.size()) {
            throw new CoordenadaOcupadaException("No puedes colocar varias partes del barco en la misma casilla.");
        }

        if (tableroPropio.validarColocacion(barco, posiciones)) {
            barco.colocar(posiciones);
            barcos.add(barco);
            for (Coordenada coord : posiciones) {
                tableroPropio.ocuparCasilla(coord);
            }
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

    public boolean atacar(Coordenada coord) throws CoordenadaInvalidaException {
        if (!tableroEnemigo.estaDentroDelTablero(coord)) {
            throw new CoordenadaInvalidaException("Coordenada fuera del tablero.");
        }

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

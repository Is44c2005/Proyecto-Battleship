import java.util.*;

public class Tablero {
    private List<List<Casilla>> grilla = new ArrayList<>();

    public Tablero(int filas, int columnas) {
        for (int i = 0; i < filas; i++) {
            List<Casilla> fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(new Casilla(new Coordenada(i, j)));
            }
            grilla.add(fila);
        }
    }

    public void mostrarTablero() {
        for (List<Casilla> fila : grilla) {
            for (Casilla casilla : fila) {
                System.out.print(casilla.getEstado().toString().charAt(0) + " ");
            }
            System.out.println();
        }
    }

    public boolean actualizarCasilla(Coordenada coord, String resultado) {
        Casilla casilla = grilla.get(coord.getFila()).get(coord.getColumna());
        if (resultado.equals("impacto")) {
            casilla.cambiarEstado(Estado.IMPACTADA);
            return true;
        } else {
            casilla.cambiarEstado(Estado.FALLADA);
            return false;
        }
    }

    public boolean validarColocacion(Barco barco, List<Coordenada> posiciones) {
        if (posiciones.size() != barco.getLongitud()) {
            return false;
        }
        for (Coordenada coord : posiciones) {
            Casilla casilla = grilla.get(coord.getFila()).get(coord.getColumna());
            if (casilla.getEstado() != Estado.VACIA) {
                return false;
            }
        }
        return true;
    }

    public boolean estaDentroDelTablero(Coordenada coord) {
        return coord.getFila() >= 0 && coord.getFila() < grilla.size()
                && coord.getColumna() >= 0 && coord.getColumna() < grilla.get(0).size();
    }

    public boolean estaOcupada(Coordenada coord) {
        return grilla.get(coord.getFila()).get(coord.getColumna()).getEstado() == Estado.OCUPADA;
    }

    public void ocuparCasilla(Coordenada coord) {
        grilla.get(coord.getFila()).get(coord.getColumna()).cambiarEstado(Estado.OCUPADA);
    }

}

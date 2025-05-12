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
        return posiciones.size() == barco.getLongitud();
    }
}

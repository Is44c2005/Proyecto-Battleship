public class Misil {
    private String tipo;
    private int alcance;

    public Misil(String tipo, int alcance) {
        this.tipo = tipo;
        this.alcance = alcance;
    }

    public boolean lanzar(Coordenada coord, Tablero tablero) {
        return tablero.actualizarCasilla(coord, "impacto");
    }
}

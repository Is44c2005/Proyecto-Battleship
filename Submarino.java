public class Submarino extends Barco {
    public Submarino() { super(3); }

    @Override
    public boolean ataqueEspecial(Coordenada coord) {
        recibirImpacto(coord);
        recibirImpacto(new Coordenada(coord.getFila(), coord.getColumna() + 1));
        return true;
    }
}

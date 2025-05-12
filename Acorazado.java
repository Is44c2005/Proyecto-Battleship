public class Acorazado extends Barco {
    public Acorazado() { super(4); }

    @Override
    public boolean ataqueEspecial(Coordenada coord) {
        int f = coord.getFila();
        int c = coord.getColumna();
        recibirImpacto(new Coordenada(f, c));
        recibirImpacto(new Coordenada(f + 1, c));
        recibirImpacto(new Coordenada(f, c + 1));
        recibirImpacto(new Coordenada(f + 1, c + 1));
        return true;
    }
}

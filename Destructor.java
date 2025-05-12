public class Destructor extends Barco {
    public Destructor() { super(3); }

    @Override
    public boolean ataqueEspecial(Coordenada coord) {
        int f = coord.getFila();
        int c = coord.getColumna();
        recibirImpacto(new Coordenada(f, c));
        recibirImpacto(new Coordenada(f + 1, c));
        recibirImpacto(new Coordenada(f + 2, c));
        return true;
    }
}

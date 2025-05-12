import java.util.Random;

public class Portaviones extends Barco {
    public Portaviones() { super(5); }

    @Override
    public boolean ataqueEspecial(Coordenada coord) {
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            Coordenada aleatoria = new Coordenada(r.nextInt(10), r.nextInt(10));
            recibirImpacto(aleatoria);
        }
        return true;
    }
}

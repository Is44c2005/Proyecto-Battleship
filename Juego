import java.util.*;

public class Juego {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tablero tablero1 = new Tablero(10, 10);
        Tablero tablero2 = new Tablero(10, 10);

        Jugador jugador1 = new Jugador("Jugador1", tablero1, tablero2);
        Jugador jugador2 = new Jugador("Jugador2", tablero2, tablero1);

        // Barcos que se colocarán (puedes personalizar la lista)
        List<Barco> barcosJugador1 = Arrays.asList(new Crucero(), new Submarino());
        List<Barco> barcosJugador2 = Arrays.asList(new Crucero(), new Submarino());

        System.out.println("Colocación de barcos para Jugador 1:");
        for (Barco barco : barcosJugador1) {
            System.out.println("Coloca tu barco de longitud " + barco.getLongitud());
            List<Coordenada> posiciones = new ArrayList<>();
            for (int i = 0; i < barco.getLongitud(); i++) {
                System.out.print("Ingresa fila y columna para parte " + (i + 1) + ": ");
                int fila = scanner.nextInt();
                int columna = scanner.nextInt();
                posiciones.add(new Coordenada(fila, columna));
            }
            if (!jugador1.colocarBarco(barco, posiciones)) {
                System.out.println("Colocación inválida. Intenta nuevamente.");
                // Puedes retroceder i para repetir si quieres validar más profundamente
            }
        }

        System.out.println("Colocación de barcos para Jugador 2:");
        for (Barco barco : barcosJugador2) {
            System.out.println("Coloca tu barco de longitud " + barco.getLongitud());
            List<Coordenada> posiciones = new ArrayList<>();
            for (int i = 0; i < barco.getLongitud(); i++) {
                System.out.print("Ingresa fila y columna para parte " + (i + 1) + ": ");
                int fila = scanner.nextInt();
                int columna = scanner.nextInt();
                posiciones.add(new Coordenada(fila, columna));
            }
            if (!jugador2.colocarBarco(barco, posiciones)) {
                System.out.println("Colocación inválida. Intenta nuevamente.");
            }
        }


        // Bucle simple de ataque
        while (jugador1.tieneBarcosVivos() && jugador2.tieneBarcosVivos()) {
            System.out.println("Jugador 1, ingresa coordenada de ataque (fila y columna):");
            int f1 = scanner.nextInt();
            int c1 = scanner.nextInt();
            jugador1.atacar(new Coordenada(f1, c1));

            if (!jugador2.tieneBarcosVivos()) break;

            System.out.println("Jugador 2, ingresa coordenada de ataque (fila y columna):");
            int f2 = scanner.nextInt();
            int c2 = scanner.nextInt();
            jugador2.atacar(new Coordenada(f2, c2));
        }

        System.out.println("¡Juego terminado!");
        if (jugador1.tieneBarcosVivos()) {
            System.out.println("Jugador 1 gana!");
        } else {
            System.out.println("Jugador 2 gana!");
        }
    }
}

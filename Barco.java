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

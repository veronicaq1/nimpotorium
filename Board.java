public class Board {
    private static int pileSize;

    public static void setupPile() {
        pileSize = 10 + (int)(Math.random() * 41); // 10 to 50 inclusive
        System.out.println("\nNew pile has " + pileSize + " pieces.");
    }

    public static void updatePile(int piecesTaken) {
        pileSize -= piecesTaken;
    }

    public static int getPileSize() {
        return pileSize;
    }

    public static boolean isGameOver() {
        return pileSize <= 1;
    }
}

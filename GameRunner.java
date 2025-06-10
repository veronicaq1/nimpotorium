import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Game of Nim!");

        System.out.print("Enter name for Player 1: ");
        Player player1 = new Player(input.nextLine());

        System.out.print("Enter name for Player 2: ");
        Player player2 = new Player(input.nextLine());

        boolean playAgain;

        do {
            Board.setupPile();
            Player currentPlayer = Math.random() < 0.5 ? player1 : player2;
            Player otherPlayer = currentPlayer == player1 ? player2 : player1;
            System.out.println("\n" + currentPlayer.getName() + " goes first!");

            while (!Board.isGameOver()) {
                System.out.println("\nPile size: " + Board.getPileSize());
                int maxTake = Board.getPileSize() / 2;
                if (maxTake < 1) maxTake = 1;
                int taken = currentPlayer.makeMove(input, maxTake);
                Board.updatePile(taken);

                if (!Board.isGameOver()) {
                    Player temp = currentPlayer;
                    currentPlayer = otherPlayer;
                    otherPlayer = temp;
                }
            }

            System.out.println("\n" + currentPlayer.getName() + " took the last piece and loses!");
            System.out.println(otherPlayer.getName() + " wins!");

            System.out.print("\nPlay again? (yes/no): ");
            playAgain = input.nextLine().trim().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thanks for playing!");
        input.close();
    }
}

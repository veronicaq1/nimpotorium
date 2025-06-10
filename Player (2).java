import java.util.Scanner;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int makeMove(Scanner input, int maxTake) {
        int take;
        while (true) {
            System.out.print(name + ", how many pieces do you want to take (1 to " + maxTake + "): ");
            if (input.hasNextInt()) {
                take = input.nextInt();
                input.nextLine(); // clear newline
                if (take >= 1 && take <= maxTake) {
                    break;
                }
            } else {
                input.nextLine(); // clear invalid input
            }
            System.out.println("Invalid move. Try again.");
        }
        return take;
    }
}

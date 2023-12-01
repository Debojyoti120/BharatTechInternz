import java.util.Random;

public class snake_ladder_game {
    public static void main(String[] args) {
        int player1 = 0;
        int player2 = 0;

        Random random = new Random();

        while (player1 < 100 && player2 < 100) {
            // Player 1's turn
            int diceValue1 = rollDice(random);
            player1 = updatePlayerPosition(player1, diceValue1, "Player 1");

            if (player1 >= 100) {
                System.out.println("Player 1 wins!");
                break;
            }

            // Player 2's turn
            int diceValue2 = rollDice(random);
            player2 = updatePlayerPosition(player2, diceValue2, "Player 2");

            if (player2 >= 100) {
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }

    public static int rollDice(Random random) {
        return random.nextInt(6) + 1; // Roll a dice between 1 and 6
    }

    public static int updatePlayerPosition(int position, int diceValue, String playerName) {
        // Define snakes and ladders positions
        int[] snakes = {16, 47}; // Add more snake positions if necessary
        int[] snakeMoves = {6, 26}; // Define the moves after encountering snakes

        int[] ladders = {4, 9}; // Add more ladder positions if necessary
        int[] ladderMoves = {14, 31}; // Define the moves after encountering ladders

        int newPosition = position + diceValue;

        // Check if the new position is a snake position
        for (int i = 0; i < snakes.length; i++) {
            if (newPosition == snakes[i]) {
                System.out.println(playerName + " encountered a snake at position " + snakes[i] +
                        ". Going down to " + snakeMoves[i] + ".");
                return snakeMoves[i];
            }
        }

        // Check if the new position is a ladder position
        for (int i = 0; i < ladders.length; i++) {
            if (newPosition == ladders[i]) {
                System.out.println(playerName + " found a ladder at position " + ladders[i] +
                        ". Climbing up to " + ladderMoves[i] + ".");
                return ladderMoves[i];
            }
        }

        return newPosition;
    }
}
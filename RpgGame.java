import java.util.Scanner;

public class RpgGame {
    static void showAvailableFightingMoves() {
        System.out.print("SLASH (k)\nPARRY (p)\nDODGE (v)\n");
    }

    static void showAvailableWalkingMoves() {
        System.out.print("UP (w)\nLEFT (a)\nDOWN (s)\nRIGHT (d)\n");
    }

    static void showRules() {
        System.out.print("Collect all the four coins scattered around the map without dying to enemies\n");
    }

    public static void main(String args[]) {
        String[] playerWeapons = {"sword", "shield"};
        Map map = new Map();
        Player player = new Player("John", 100, 0, playerWeapons);
        Scanner input = new Scanner(System.in);

        System.out.println("Available walking moves:");
        showAvailableWalkingMoves();
        System.out.println();
        System.out.println("Available fighting moves:");
        showAvailableFightingMoves();
        System.out.println();
        System.out.println("Game goal:");
        showRules();
        System.out.println();

        map.show();
        map.showPlayerPosition();
        System.out.println();

        System.out.print("Where do you want to go?: ");
        char move = input.next().charAt(0);
        int moveCode = (int) move;
        while (moveCode != 97 && moveCode != 100 && moveCode != 115 && moveCode != 119) {
            System.out.print("Please, choose an option from those listed above: ");
            moveCode = (int) input.next().charAt(0);
        }
        map.updatePlayerPosition(player.move(moveCode));
        map.show();

        input.close();
    }
}

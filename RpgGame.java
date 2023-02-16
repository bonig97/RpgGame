import java.util.Scanner;

class Player {
    String name;
    int health = 100, gold = 0;
    String[] weapons = {};
    int[] position = {0, 0};

    Player(String name, int health, int gold, String[] weapons) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.weapons = weapons;
    }

    String move(int move) {
        switch (move) {
            case 97:
                return "LEFT";
            case 100:
                return "RIGHT";
            case 115:
                return "DOWN";
            case 119:
                return "UP";
        }
        return "";
    }
}

class Map {
    String[][] terrain;

    Map() {
        this.terrain = init();
    }

    String[][] init() {
        return new String[][] {
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", "O", " "},
            {"O", "O", "O", " ", "E", " ", " ", "G", "O", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", "O", " "},
            {" ", "G", " ", "P", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", "O", "O", "O", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", "E", " ", "O", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", "O", "G", " "},
            {" ", " ", " ", "G", " ", " ", " ", "O", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "}
        };
    }

    int[] getPlayerPosition() {
        int[] choords = new int[2];
        for (int i = 0; i < this.terrain.length; i++) {
            for (int j = 0; j < this.terrain[i].length; j++) {
                if (this.terrain[i][j] == "P") {
                    choords[0] = i;
                    choords[1] = j;
                }
            }
        }
        return choords;
    }

    void showPlayerPosition() {
        int[] choords = this.getPlayerPosition();
        System.out.print("Player choordinates:\n{" + (int)(choords[0] + 1) + "," + (int)(choords[1] + 1) + "}\n\n");
    }

    void updatePlayerPosition(String direction) {
        int[] actualChoords = this.getPlayerPosition();
        String[][] tempTerrain = this.terrain;
        for (int i = 0; i < this.terrain.length; i++) {
            for (int j = 0; j < this.terrain[i].length; j++) {
                if (i == actualChoords[0] && j == actualChoords[1]) {
                    if (direction == "LEFT") {
                        int[] newChoords = {i, j - 1};
                        tempTerrain[i][j - 1] = "P";
                        tempTerrain[i][j] = " ";
                        System.out.println("Player choordinates:\n{" + (int)(newChoords[0] + 1) + "," + (int)(newChoords[1] + 1) + "}\n\n");
                    }
                    if (direction == "RIGHT") {
                        int[] newChoords = {i, j + 1};
                        tempTerrain[i][j + 1] = "P";
                        tempTerrain[i][j] = " ";
                        System.out.println("Player choordinates:\n{" + (int)(newChoords[0] + 1) + "," + (int)(newChoords[1] + 1) + "}\n\n");
                    }
                    if (direction == "DOWN") {
                        int[] newChoords = {i + 1, j};
                        tempTerrain[i + 1][j] = "P";
                        tempTerrain[i][j] = " ";
                        System.out.println("Player choordinates:\n{" + (int)(newChoords[0] + 1) + "," + (int)(newChoords[1] + 1) + "}\n\n");
                    }
                    if (direction == "UP") {
                        int[] newChoords = {i - 1, j};
                        tempTerrain[i - 1][j] = "P";
                        tempTerrain[i][j] = " ";
                        System.out.println("Player choordinates:\n{" + (int)(newChoords[0] + 1) + "," + (int)(newChoords[1] + 1) + "}\n\n");
                    }
                }
            }
        }
        this.terrain = tempTerrain;
    }

    void show() {
        for (int i = 0; i < this.terrain.length; i++) {
            for (int j = 0; j < this.terrain[i].length; j++)
                System.out.print(this.terrain[i][j] + "|");
            System.out.println();
        }
    }
}

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

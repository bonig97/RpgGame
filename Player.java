public class Player {
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
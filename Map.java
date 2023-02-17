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
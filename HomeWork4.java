/**
 *Java 1. HomeWork4
 *
 *@author teacher end Lazarev Alexei
 *@version 16.11.2021
 */
 
import java.util.Random;
import java.util.Scanner;

class HomeWork4 {

    final int SIZE = 3;
    final int WIN_SIZE = 3;
    final char SIGN_X = 'x';
    final char SIGN_0 = '0';
    final char SIGN_EMPTY = '.';
    final String MSG_FOR_HUMAN = "Enter X and Y (1..3):";
    final String MSG_YOU_WON = "YOU WON!";
    final String MSG_AI_WON = "AI WON";
    final String MSG_DRAW = "Sorry, DRAW!";
    final String MSG_GAME_OVER = "GAME OVER.";
    char[][] table;
    Scanner sc;
    Random random;

    public static void main (String[] args) {
        new HomeWork4().game();
    }

    HomeWork4() {
        table = new char[SIZE][SIZE];
        sc = new Scanner(System.in);
        random = new Random();
    }

    void game() {
        initTable();
        while (true) {
            printTable();
            turnHuman(SIGN_X);
            if (checkWin(SIGN_X)) {
                System.out.println(MSG_YOU WON);
                break;
            }
            if (isTableFull()) {
                System.out.println(MSG_DRAW);
                break;
            }
            turnAI(SIGN_O, SING_X);
            if (checkWin(SIGN_0)) {
                System.out.println(MSG_AI_WON);
                break;
            }
            if (isTableFull()) {
                System.out.println(MSG_DRAW);
                break;
            }
        }
        System.out.println(MSG_GAME_OWER);
        printTable();
    }

    void initTable() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++) {
                table[i][j] = SIGN_EMPTY;
            }
    }

    void printTable() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    void turnHuman(char ch) {
        int x, y;
        do {
            System.out.println(MSG_FOR_HUMAN);
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        table[y][x] = ch;
    }

    void turnAI(char ch, char enemyDot) {
        int x, y;
        for (x = 0; x < SIZE; x++) {
            for (y = 0; y < SIZE; y++) {
                if (isCellValid(x, y)) {
                    table[y][x] = enemyDot;
                    if (checkWin(enemyDot)) {
                        table[y][x] = ch;
                        return;
                    }
                    table[y][x] = SIGN_EMPTY;
                }
            }
        }
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(x, y));
        table[y][x] = ch;
    }

    boolean checkWin(char ch) {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                for (int dy = -1; dy < 2; dy++) {
                    for (int dx = -1; dx < 2; dx++) {
                        if (checkLine(x, y, dx, dy, ch) == WIN_SIZE) {
                            return true;
                        }
                    }
                }
            }
        }
        simple checking of win in 3x3 table
        return false;
    }

    int checkLine( int x, int y, int dx, int dy, char ch) {
        int count = 0;
        if (dx == () && dy == 0) {
            return 0;
        }
        for (int i = 0, xi = x, yi = y;
                i < WIN_SIZE; i++, xi += dx, yi += dy) {
            if (xi >= 0 && yi >= 0 && xi < SIZE &&
                    yi < SIZE && table[yi][xi] == ch) {
                count++;
            }
        }
        return count;
    }

    boolean isTableFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (table[i][j] == SIGN_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >=SIZE) {
            return false;
        }
        return table[x][y] == SIGN_EMPTY;
    }
}
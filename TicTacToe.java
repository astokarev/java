package lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int SIZE = 3;

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final char HEADER_FIRST_SYMBOL = '♥';
    static final String EMPTY = " ";
    static int turnsCount;

    static final char[][] MAP = new char[SIZE][SIZE];
    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();

    public static void main(String[] args) {

        turnGame();
    }

    public static void turnGame() {
        initMap();

        printMap();

        playGame();
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        System.out.println();
        printHeaderMap();
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);
        for (int i = 0; i < SIZE; i++) {
            printMapNumbers(i);
        }
        System.out.println();
    }

    private static void printMapNumbers(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printBodyMap() {
        for (int i = 0; i < SIZE; i++) {
            printMapNumbers(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();

        }
    }


    private static void playGame() {

        turnsCount = 0;
        while (true) {
            humanTurn();
            printMap();
            checkEnd(DOT_HUMAN);

            aiTurn();
            printMap();
            checkEnd(DOT_AI);

        }
    }

    private static void humanTurn() {
        int rowNumber;
        int columnNumber;
        boolean isInputValid = true;

        System.out.println("\nХод человека! Введите номера строки и столбца");
        do {
            rowNumber = -1;
            columnNumber = -1;

            System.out.print("Строка = ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;

            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Столбик = ");
            if (in.hasNextInt()) {
                columnNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }
        } while (!(isInputValid && isHumanValidTurn(rowNumber, columnNumber)));

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
    }

    private static void processingIncorrectInput() {
        in.next();
        System.out.println("Введите число!");
    }

    private static boolean isHumanValidTurn(int rowNumber, int columnNumber) {

        if (!isNumbersValid(rowNumber, columnNumber)) {
            System.out.println("\nПроверьте значение строки и столбца");
            return false;
        } else if (!isCellOccupancy(rowNumber, columnNumber)) {
            System.out.println("\nВы выбрали занятую ячейку!");
            return false;
        }

        return true;
    }

    private static boolean isNumbersValid(int rowNumber, int columnNumber) {
        return !(rowNumber > SIZE || rowNumber < 0 || columnNumber > SIZE || columnNumber < 0);
    }

    private static boolean isCellOccupancy(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static void checkEnd(char symbol) {
        boolean isEnd = false;

        if (checkWin(symbol)) {
            isEnd = true;
            String winMessage;

            if (symbol == DOT_HUMAN) {
                winMessage = "Ура! Вы победили!";
            } else {
                winMessage = "Восстание близко. ИИ победил.";
            }

            System.out.println(winMessage);
        }

        if (!isEnd && isMapFullByTurnsCount()) {
            System.out.println("Ничья!");
            isEnd = true;
        }

        if (isEnd) {
            System.exit(0);
        }

    }

    private static boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((MAP[i][0] == symbol && MAP[i][1] == symbol &&
                    MAP[i][2] == symbol) ||
                    (MAP[0][i] == symbol && MAP[1][i] == symbol &&
                            MAP[2][i] == symbol))
                return true;
            if ((MAP[0][0] == symbol && MAP[1][1] == symbol &&
                    MAP[2][2] == symbol)||
                    (MAP[2][0] == symbol && MAP[1][1] == symbol &&
                            MAP[0][2] == symbol))
                return true;
        }
        return false;
    }

    private static boolean isMapFull() {

        for (char[] chars : MAP) {
            for (char symbol : chars) {
                if (symbol == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isMapFullByTurnsCount() {
        return ++turnsCount == SIZE * SIZE;
    }

    private static void aiTurn() {
        int rowNumber;
        int columnNumber;

        System.out.println("\nХод компьютера!");
        do {
            rowNumber = random.nextInt(SIZE);
            columnNumber = random.nextInt(SIZE);
        } while (!isCellOccupancy(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;

    }
}

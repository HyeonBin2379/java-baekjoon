import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private static class Tile {
        int white;
        int black;
        char lastColor = ' ';

        Tile(int white, int black) {
            this.white = white;
            this.black = black;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        char[] dir = new char[n];

        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
        }

        // Please write your code here.
        Tile[] array = new Tile[200004];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Tile(0, 0);
        }

        int curr = 100000;
        for (int i = 0; i < n; i++) {
            switch (dir[i]) {
                case 'L':   // 흰색 칠하기
                    while (x[i]-- > 0) {
                        array[curr].lastColor = 'W';
                        ++array[curr].white;
                        if (x[i] > 0) {
                            curr--;
                        }
                    }
                    break;
                case 'R':   // 검은색 칠하기
                    while (x[i]-- > 0) {
                        array[curr].lastColor = 'B';
                        ++array[curr].black;
                        if (x[i] > 0) {
                            curr++;
                        }
                    }
                    break;
            }
        }

        int white = 0, black = 0, gray = 0;
        for (int i = 0; i < array.length; i++) {
            int lastColor = array[i].lastColor;

            if (array[i].white >= 2 && array[i].black >= 2) {
                gray++;
                continue;
            }
            switch (lastColor) {
                case 'W':
                    white++;
                    break;
                case 'B':
                    black++;
                    break;
            }
        }
        System.out.printf("%d %d %d\n", white, black, gray);
    }
}

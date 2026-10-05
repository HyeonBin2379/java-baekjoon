import java.util.Scanner;
import java.util.Arrays;

public class Main {

    private static class Tile {
        int white;
        int black;
        char lastColor;

        Tile(int white, int black) {
            this.white = white;
            this.black = black;
            this.lastColor = ' ';
        }
    }

    public static void main(String[] args) {
        // 배열 초기화 및 입력
        Scanner sc = new Scanner(System.in);
        Tile[] array = new Tile[200001];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Tile(0, 0);
        }

        int n = sc.nextInt();
        int curr = 100000;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);

            // 타일 뒤집기
            switch (d) {
                case 'L':
                    while (x-- > 0) {
                        array[curr].lastColor = 'W';
                        array[curr].white++;
                        if (x > 0) {
                            curr--;
                        }
                    }
                    break;
                case 'R':
                    while (x-- > 0) {
                        array[curr].lastColor = 'B';
                        array[curr].black++;
                        if (x > 0) {
                            curr++;
                        }
                    }
                    break;
            }
        }

        // 결과 출력
        int white = 0, black = 0;
        for (int i = 0; i < array.length; i++) {
            switch (array[i].lastColor) {
                case 'W':
                    white++;
                    break;
                case 'B':
                    black++;
                    break;
            }
        }
        System.out.printf("%d %d\n", white, black);
    }
}
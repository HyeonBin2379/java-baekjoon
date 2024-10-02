package baekjoon.baekjoon30XXX;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise30678 {

    private static char[][] star;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("*");
            return;
        }

        int size = (int) Math.pow(5, n);
        star = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                recursive(i, j, size/5);
            }
        }
        IntStream.range(0, size).forEach(i -> System.out.println(new String(star[i])));
    }

    private static void recursive(int i, int j, int size) {
        if (((i / size) % 5 < 2 && (j / size) % 5 != 2)
                || ((i / size) % 5 == 3 && ((j / size) % 5 == 0 || (j / size) % 5 == 4))
                || ((i / size) % 5 == 4 && ((j / size) % 5) % 2 == 0)) {
            star[i][j] = ' ';
        } else {
            if (size / 5 == 0) {
                star[i][j] = '*';
            } else {
                recursive(i, j, size/5);
            }
        }
    }
}

package baekjoon.baekjoon02XXX;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise2447 {

    private static char[][] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        result = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                recursive(i, j, size);
            }
        }
        IntStream.range(0, size).forEach(i -> System.out.println(new String(result[i])));
    }

    private static void recursive(int i, int j, int size) {
        if ((i / size) % 3 == 1 && (j / size) % 3 == 1) {
            result[i][j] = ' ';
        } else {
            if (size / 3 == 0) {
                result[i][j] = '*';
            } else {
                recursive(i, j, size/3);
            }
        }
    }
}

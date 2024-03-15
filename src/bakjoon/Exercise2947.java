package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise2947 {
    private static int[] piece;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        piece = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while (!isSame()) {
            for (int i = 0; i < 4; i++) {
                if (piece[i] > piece[i + 1]) {
                    swap(i, i + 1);
                    Arrays.stream(piece).forEach(value -> System.out.print(value + " "));
                    System.out.println();
                }
            }
        }
    }

    public static void swap(int i, int j) {
        int temp = piece[i];
        piece[i] = piece[j];
        piece[j] = temp;
    }

    public static boolean isSame() {
        for (int i = 0; i < 5; i++) {
            if (piece[i] != i+1) {
                return false;
            }
        }
        return true;
    }
}

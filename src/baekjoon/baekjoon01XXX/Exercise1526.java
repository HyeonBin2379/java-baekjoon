package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise1526 {

    private static final int[] digit = {0, 1, 2, 3, 5, 6, 8, 9};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = num; i >= 4; i--) {
            if (isMatched(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean isMatched(int num) {
        for (int i : digit) {
            if (Integer.toString(num).contains(String.valueOf(i))) {
                return false;
            }
        }
        return true;
    }
}

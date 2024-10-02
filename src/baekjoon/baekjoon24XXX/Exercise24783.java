package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise24783 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < n; i++) {
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(num);
            System.out.println(canCalculate(num) ? "Possible" : "Impossible");
        }
    }

    public static boolean canCalculate(int[] num) {
        char[] operator = {'+', '-', '*', '/'};
        for (int i = 0; i < 4; i++) {
            switch (operator[i]) {
                case '+' -> {
                    if (num[0] + num[1] == num[2]) {
                        return true;
                    }
                }
                case '-' -> {
                    if (num[2] - num[1] == num[0] || num[2] - num[0] == num[1]) {
                        return true;
                    }
                }
                case '*' -> {
                    if (num[0] * num[1] == num[2]) {
                        return true;
                    }
                }
                case '/' -> {
                    if (num[0] / num[1] == num[2] || num[1] / num[0] == num[2]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

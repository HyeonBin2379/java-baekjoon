package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5618 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ", count)).mapToInt(Integer::parseInt).toArray();
        int gcd = switch (count) {
            case 2 -> getGCD(num[0], num[1]);
            case 3 -> getGCD(num[0], getGCD(num[1], num[2]));
            default -> 1;
        };
        for (int i = 1; i <= gcd; i++) {
            if (gcd % i == 0) {
                System.out.println(i);
            }
        }
    }

    private static int getGCD(int a, int b) {
        while (b > 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

package baekjoon.baekjoon30XXX;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise30281 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] candy = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            candy[i] = sc.nextInt();
            sum += candy[i];
        }

        Arrays.sort(candy);
        if (sum % 2 == 1) {
            int min = Arrays.stream(candy).filter(value -> value % 2 == 1).min().getAsInt();
            System.out.println((sum-min)/2);
        } else {
            System.out.println(sum/2);
        }
    }
}

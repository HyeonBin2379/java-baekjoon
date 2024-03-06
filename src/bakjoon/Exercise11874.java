package bakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise11874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = Integer.parseInt(sc.nextLine());
        int d = Integer.parseInt(sc.nextLine());
        int x = Integer.parseInt(sc.nextLine());

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = l; i <= d; i++) {
            int[] digit = Arrays.stream(Integer.toString(i).split("")).mapToInt(Integer::parseInt).toArray();
            int sum = Arrays.stream(digit).sum();
            if (sum == x) {
                min = Math.min(min, i);
                max = Math.max(max, i);
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}

package bakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise11648 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        while (num >= 10) {
            int[] digit = Arrays.stream(Integer.toString(num).split("")).mapToInt(Integer::parseInt).toArray();
            int newNum = 1;
            for (int j : digit) {
                newNum *= j;
            }
            num = newNum;
            count++;
        }
        System.out.println(count);
    }
}

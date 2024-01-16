package bakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise7318 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        long[] number = new long[count];
        for (int i = 0; i < count; i++) {
            number[i] = reverseNumber(sc.next());
        }

        Arrays.sort(number);
        StringBuilder sb = new StringBuilder();
        for (long num : number) {
            sb.append(num).append("\n");
        }
        System.out.print(sb);
    }

    public static long reverseNumber(String number) {
        StringBuilder sb = new StringBuilder(number);
        return Long.parseLong(sb.reverse().toString());
    }
}

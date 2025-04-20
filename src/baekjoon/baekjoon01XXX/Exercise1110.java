package baekjoon.baekjoon01XXX;

import java.util.Scanner;

public class Exercise1110 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 1;
        int now = n;
        while (true) {
            int next = getNewNum(now);
            if (next == n) {
                break;
            }
            now = next;
            count++;
        }
        System.out.println(count);
    }

    private static int getNewNum(int num) {
        int result = (num%10)*10;
        int total = 0;
        while (num > 0) {
            total += num%10;
            num /= 10;
        }
        return result + total%10;
    }
}

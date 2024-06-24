package bakjoon.bakjoon30XXX;

import java.util.Scanner;

public class Exercise30067 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            num[i] = sc.nextInt();
            sum += num[i];
        }
        for (int j : num) {
            if (j == sum - j) {
                System.out.println(j);
                break;
            }
        }
    }
}

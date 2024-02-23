package bakjoon;

import java.util.Scanner;

public class Exercise10480 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testCase; i++) {
            int num = sc.nextInt();
            if (num % 2 == 0) {
                sb.append(String.format("%d is even\n", num));
            } else {
                sb.append(String.format("%d is odd\n", num));
            }
        }
        System.out.print(sb);
        sc.close();
    }
}

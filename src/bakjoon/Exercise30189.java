package bakjoon;

import java.util.Scanner;

public class Exercise30189 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int count = 0;
        for (int k = 0; k <= n+m; k++) {
            for (int a = 0; a <= n; a++) {
                for (int b = 0; b <= m; b++) {
                    if (a+b == k) {
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

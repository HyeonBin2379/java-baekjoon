package bakjoon.bakjoon31XXX;

import java.util.Scanner;

public class Exercise31995 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i+1 < n && j+1 < m) {
                    count++;
                }
                if (i+1 < n && j-1 >= 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

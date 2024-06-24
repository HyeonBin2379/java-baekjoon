package bakjoon.bakjoon01XXX;

import java.util.Scanner;

public class Exercise1722 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int digits = sc.nextInt();

        boolean[] visited = new boolean[digits + 1];
        int[] sequential = new int[digits + 1];
        long[] factorial = new long[digits + 1];
        factorial[0] = 1;
        for (int i = 1; i < digits; i++) {
            factorial[i] = factorial[i-1]*i;
        }
        int menu = sc.nextInt();
        switch (menu) {
            case 1 -> {
                long K = sc.nextLong();
                for (int i = 1; i < digits + 1; i++) {
                    int count = 1;
                    for (int j = 1; j < digits + 1; j++) {
                        if (visited[j]) {
                            continue;
                        }
                        if (K <= factorial[digits - i] * count) {
                            sequential[i] = j;
                            visited[j] = true;
                            K -= factorial[digits - i] * (count - 1);
                            break;
                        }
                        count++;
                    }
                }
                for (int i = 1; i < digits + 1; i++) {
                    System.out.print(sequential[i] + " ");
                }
            }
            case 2 -> {
                for (int i = 1; i < digits + 1; i++) {
                    sequential[i] = sc.nextInt();
                }
                long k = 1;
                for (int i = 1; i < digits + 1; i++) {
                    int count = 0;
                    for (int j = 1; j < sequential[i]; j++) {
                        if (!visited[j]) {
                            count++;
                        }
                    }
                    k += count * factorial[digits - i];
                    visited[sequential[i]] = true;
                }
                System.out.println(k);
            }
        }
    }
}

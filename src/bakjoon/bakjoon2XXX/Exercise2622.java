package bakjoon.bakjoon2XXX;

import java.util.Scanner;

public class Exercise2622 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int k = n-i-j;
                if (j > k) {
                    break;
                } else if (k < i+j) {
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}

package bakjoon.bakjoon14XXX;

import java.util.Scanner;

public class Exercise14495 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] pseudoFib = new long[num+1];
        for (int i = 1; i <= num; i++) {
            if (i < 3) {
                pseudoFib[i] = 1;
            } else {
                pseudoFib[i] = pseudoFib[i-1] + pseudoFib[i-3];
            }
        }
        System.out.println(pseudoFib[num]);
    }
}

package bakjoon;

import java.util.Scanner;

public class Exercise17944 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int arm = 0;
        int inc = 1;
        for (int i = 1; i <= t; i++, arm += inc) {
             if (inc < 0 && arm == 1) {
                 inc = 1;
             } else if (inc > 0 && arm == 2*n) {
                 inc = -1;
             }
        }
        System.out.println(arm);
    }
}

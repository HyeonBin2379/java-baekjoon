package bakjoon.bakjoon20XXX;

import java.util.Scanner;

public class Exercise20473 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int min = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= num; j++) {
                if (2*i + 3*j == num) {
                    if (min > i+j) {
                        min = i+j;
                        ans1 = i;
                        ans2 = j;
                    }
                }
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}

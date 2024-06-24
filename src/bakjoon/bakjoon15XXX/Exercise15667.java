package bakjoon.bakjoon15XXX;

import java.util.Scanner;

public class Exercise15667 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = Integer.parseInt(sc.nextLine());
        int k = 0;
        while (true) {
            int result = 1 + k + k*k;
            if (result == sum) {
                break;
            }
            k++;
        }
        System.out.println(k);
    }
}

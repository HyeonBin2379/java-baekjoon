package bakjoon.bakjoon10XXX;

import java.util.Scanner;

public class Exercise10039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int num = sc.nextInt();
            sum += Math.max(num, 40);
        }
        System.out.println(sum / 5);
        sc.close();
    }
}

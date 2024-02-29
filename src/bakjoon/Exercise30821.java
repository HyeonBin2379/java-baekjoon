package bakjoon;

import java.util.Scanner;

public class Exercise30821 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        long result = 1;
        for (int i = 0; i < 5; i++) {
            result *= (num-i);
            result /= (i+1);
        }
        System.out.println(result);
    }
}

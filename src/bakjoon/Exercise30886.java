package bakjoon;

import java.util.Scanner;

public class Exercise30886 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        double r = Math.sqrt(a/Math.PI);
        System.out.printf("%.9f\n", Math.pow(r+1, 2)*4);
    }
}

package bakjoon;

import java.util.Scanner;

public class Exercise2097 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        if (count < 4) {
            System.out.println(4);
            return;
        }

        for (long i = 2; i < count; i++) {
            if (count <= i*i) {
                System.out.println((i-1)*4);
                break;
            } else if (count <= i*(i+1)) {
                System.out.println(4*i-2);
                break;
            }
        }
    }
}

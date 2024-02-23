package bakjoon;

import java.util.Scanner;

public class Exercise6887 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int square = sc.nextInt();
        System.out.printf("The largest square has side length %d.\n", (int) Math.sqrt(square));
    }
}

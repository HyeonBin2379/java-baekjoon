package bakjoon.bakjoon25XXX;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise25176 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a*b));
    }
}

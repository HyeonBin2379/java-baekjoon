package bakjoon.bakjoon30XXX;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise30167 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        System.out.println(IntStream.rangeClosed(left, right)
                .filter(value -> Integer.toString(value).length()
                        == Arrays.stream(Integer.toString(value).split(""))
                        .distinct()
                        .count())
                .findFirst()
                .orElse(-1));
    }
}

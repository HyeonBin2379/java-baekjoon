package bakjoon.bakjoon5XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise5585 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coin = {500, 100, 50, 10, 5, 1};
        int[] count = new int[6];
        int change = 1000 - sc.nextInt();
        for (int i = 0; i < 6; i++) {
            count[i] = change/coin[i];
            change %= coin[i];
        }
        System.out.println(Arrays.stream(count).sum());
    }
}

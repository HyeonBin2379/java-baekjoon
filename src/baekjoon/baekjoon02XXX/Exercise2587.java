package baekjoon.baekjoon02XXX;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2587 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        System.out.println(Arrays.stream(arr).sum()/5);
        System.out.println(arr[2]);
    }
}

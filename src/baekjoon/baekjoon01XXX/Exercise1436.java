package baekjoon.baekjoon01XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise1436 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 666; i <= 3000000; i++) {
            if (Integer.toString(i).contains("666")) {
                list.add(i);
            }
        }

        int n = sc.nextInt();
        System.out.println(list.get(n-1));
    }
}

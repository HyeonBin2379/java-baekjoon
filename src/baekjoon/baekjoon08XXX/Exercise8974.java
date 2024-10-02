package baekjoon.baekjoon08XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise8974 {

    private static final List<Integer> numList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt()-1;
        int b = sc.nextInt()-1;
        int sum = 0;

        setNumList();
        for (int i = a; i <= b; i++) {
            sum += numList.get(i);
        }
        System.out.println(sum);
    }

    private static void setNumList() {
        int count = 1;
        while (numList.size() <= 1000) {
            for (int i = 1; i <= count; i++) {
                numList.add(count);
            }
            count++;
        }
    }
}

package baekjoon.baekjoon21XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise21603 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int mod = i % 10;
            if (mod != (k % 10) && mod != (2*k % 10)) {
                answer.add(i);
            }
        }

        System.out.println(answer.size());
        if (!answer.isEmpty()) {
            for (Integer num : answer) {
                System.out.print(num + " ");
            }
        }
    }
}

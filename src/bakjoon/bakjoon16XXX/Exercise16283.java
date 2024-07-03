package bakjoon.bakjoon16XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise16283 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();

        List<String> answer = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (i*a + (n-i)*b == w) {
                answer.add(String.format("%d %d", i, n-i));
            }
        }
        System.out.println(answer.size() != 1 ? -1 : answer.get(0));
    }
}

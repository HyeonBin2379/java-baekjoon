package baekjoon.baekjoon06XXX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise6500 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }

            List<Integer> list = new ArrayList<>();
            list.add(n);
            do {
                n *= n;
                String s = String.format("%08d", n);
                n = Integer.parseInt(s.substring(2, 6));
                if (list.contains(n)) {
                    break;
                }
                list.add(n);
            } while (true);
            System.out.println(list.size());
        }
        sc.close();
    }
}

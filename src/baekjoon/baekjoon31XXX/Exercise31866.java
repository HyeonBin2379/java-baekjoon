package baekjoon.baekjoon31XXX;

import java.util.List;
import java.util.Scanner;

public class Exercise31866 {

    private static final List<Integer> valid = List.of(0, 2, 5);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int idx1 = valid.indexOf(a);
        int idx2 = valid.indexOf(b);
        if ((idx1 != -1 && (idx1+1) % 3 == idx2)
                || (idx2 == -1 && idx1*idx2 <= 0)) {
            System.out.println(">");
        } else if ((idx2 != -1 && (idx2+1) % 3 == idx1)
                || (idx1 == -1 && idx1*idx2 <= 0)) {
            System.out.println("<");
        } else {
            System.out.println("=");
        }
    }
}

package bakjoon.bakjoon25XXX;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise25370 {

    private static final Set<Integer> products = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        countProduct(1, n);
        System.out.println(products.size());
    }

    private static void countProduct(int current, int remained) {
        if (remained == 0) {
            products.add(current);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            countProduct(current*i, remained-1);
        }
    }
}

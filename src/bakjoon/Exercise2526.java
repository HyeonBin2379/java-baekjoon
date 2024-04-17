package bakjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise2526 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();

        List<Integer> remainders = new ArrayList<>();
        int remain = n;
        while (true) {
            remain = remain * n % p;
            if (remainders.contains(remain)) {
                System.out.println(remainders.size() - remainders.indexOf(remain));
                break;
            }
            remainders.add(remain);
        }
    }
}

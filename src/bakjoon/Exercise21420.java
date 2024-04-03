package bakjoon;

import java.util.Scanner;

public class Exercise21420 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(sc.nextLine()) == 1) {
                count++;
            }
        }
        System.out.println(Math.min(count, n-count));
    }
}

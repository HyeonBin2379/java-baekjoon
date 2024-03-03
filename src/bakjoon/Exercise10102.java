package bakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise10102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = Integer.parseInt(sc.nextLine());
        String[] result = sc.nextLine().split("");
        int a = (int) Arrays.stream(result).filter(s -> s.equals("A")).count();
        if (a > v-a) {
            System.out.println("A");
        } else if (a == v-a) {
            System.out.println("Tie");
        } else {
            System.out.println("B");
        }
    }
}

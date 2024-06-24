package bakjoon.bakjoon15XXX;

import java.util.Scanner;

public class Exercise15232 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        String line = "*".repeat(c) + "\n";
        sb.append(line.repeat(r));
        System.out.print(sb);
    }
}

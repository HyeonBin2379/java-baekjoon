package bakjoon.bakjoon10XXX;

import java.util.Scanner;

public class Exercise10419 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < testCase; i++) {
            int classTime = Integer.parseInt(sc.nextLine());
            int t = 0;
            while (t*t + t <= classTime) {
                t++;
            }
            sb.append(t-1).append("\n");
        }
        System.out.print(sb);
    }
}

package bakjoon.bakjoon8XXX;

import java.util.Scanner;

public class Exercise8815 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int z = Integer.parseInt(sc.nextLine());
        String cycle = "BCBCDCDADABA";
        for (int i = 0; i < z; i++) {
            int num = Integer.parseInt(sc.nextLine());
            sb.append((num == 1) ? "A" : cycle.charAt((num-2) % 12)).append("\n");
        }
        System.out.print(sb);
    }
}

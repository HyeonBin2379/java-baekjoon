package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise13773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int year = Integer.parseInt(br.readLine());
            if (year == 0) {
                break;
            }
            if (year % 4 == 0 && year >= 1896) {
                if (hasWar(year)) {
                    sb.append(year).append(" Games cancelled\n");
                } else if (year >= 2024) {
                    sb.append(year).append(" No city yet chosen\n");
                } else {
                    sb.append(year).append(" Summer Olympics\n");
                }
            } else {
                sb.append(year).append(" No summer games\n");
            }
        }
        System.out.print(sb);
    }

    public static boolean hasWar(int year) {
        return (year >= 1914 && year <= 1918) || (year >= 1939 && year <= 1945);
    }
}

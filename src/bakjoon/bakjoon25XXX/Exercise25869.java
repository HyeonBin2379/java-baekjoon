package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25869 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] usa = new int[3];
            int[] russia = new int[3];
            int total_US = 0, total_RU = 0;

            for (int j = 0; j < 6; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (j < 3) {
                    usa[j] = num;
                    total_US += usa[j];
                } else {
                    russia[j-3] = num;
                    total_RU += russia[j-3];
                }
                sb.append(num).append(" ");
            }
            sb.append("\n");

            if (total_US > total_RU) {
                sb.append(canWinUSAWithMedal(usa, russia) ? "both" : "count").append("\n");
            } else {
                sb.append(canWinUSAWithMedal(usa, russia) ? "color" : "none").append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static boolean canWinUSAWithMedal(int[] usa, int[] russia) {
        for (int i = 0; i < 3; i++) {
            if (usa[i] != russia[i]) {
                return usa[i] > russia[i];
            }
        }
        return false;
    }
}

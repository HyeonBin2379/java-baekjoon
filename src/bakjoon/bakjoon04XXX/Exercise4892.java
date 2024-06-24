package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4892 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            int[] n = new int[5];
            n[0] = Integer.parseInt(br.readLine());
            if (n[0] == 0) {
                break;
            }
            n[1] = n[0]*3;
            if (n[1] % 2 == 1) {
                sb.append(String.format("%d. odd ", ++count));
                n[2] = (n[1] + 1)/2;
            } else {
                sb.append(String.format("%d. even ", ++count));
                n[2] = n[1]/2;
            }
            n[3] = n[2]*3;
            n[4] = n[3]/9;
            sb.append(n[4]).append("\n");
        }
        System.out.print(sb);
    }
}

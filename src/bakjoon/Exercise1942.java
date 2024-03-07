package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = getClockInteger(st.nextToken());
            int end = getClockInteger(st.nextToken());
            if (start > end) {
                end += 240000;
            }

            int count = 0;
            for (int j = start; j <= end; j++) {
                if (j % 100 == 60) {
                    j += 40;
                }
                if (j % 10000 == 6000) {
                    j += 4000;
                }
                if ((j >= 240000 && (j-240000) % 3 == 0)
                        || (j < 240000 && j % 3 == 0)) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    public static int getClockInteger(String timeStr) {
        String[] token = timeStr.split(":");
        int time = 0;
        for (int i = 2; i >= 0; i--) {
            time += Integer.parseInt(token[2-i])*(int)Math.pow(100, i);
        }
        return time;
    }
}

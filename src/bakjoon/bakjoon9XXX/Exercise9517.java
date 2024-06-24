package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise9517 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int player = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int nowTime = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String answer = st.nextToken();
            if (nowTime + time > 210) {
                sb.append(player);
                break;
            }
            if (answer.equals("T")) {
                player = (player+1 > 8) ? 1 : player+1;
            }
            nowTime += time;
        }
        System.out.print(sb);
    }
}

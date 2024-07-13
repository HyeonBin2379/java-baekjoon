package bakjoon.bakjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise27161 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int currentTime = 0;
        int increse = 1;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cardType = st.nextToken();
            int timeValue = Integer.parseInt(st.nextToken());

            if (currentTime + increse > 12) {
                currentTime = (currentTime + increse) % 12;
            } else if (currentTime + increse == 0) {
                currentTime = 12;
            } else {
                currentTime += increse;
            }

            if (cardType.equals("HOURGLASS")) {
                if (currentTime == timeValue) {
                    sb.append(String.format("%d %s\n", currentTime, "NO"));
                    continue;
                }
                increse *= -1;
            }
            sb.append(currentTime).append(" ").append(currentTime == timeValue ? "YES\n" : "NO\n");
        }
        System.out.print(sb);
    }
}

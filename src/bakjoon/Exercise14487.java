package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise14487 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0, max = 0;
        while (st.hasMoreTokens()) {
            int dist = Integer.parseInt(st.nextToken());
            max = Math.max(dist, max);
            sum += dist;
        }
        System.out.println(sum - max);
    }
}

package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise5612 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        int inTunnel = Integer.parseInt(br.readLine());
        int max = inTunnel;
        for (int i = 0; i < time; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int in = Integer.parseInt(st.nextToken());
            int out = Integer.parseInt(st.nextToken());
            inTunnel += (in-out);
            if (inTunnel < 0) {
                max = 0;
                break;
            }
            max = Math.max(max, inTunnel);
        }
        System.out.println(max);
    }
}

package bakjoon.bakjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise4850 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            long n = Long.parseLong(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());

            long result = Long.parseLong(st.nextToken());
            long normal = (n-1)*n*w/2;
            long coin = (normal == result) ? n : (normal - result) / d;
            sb.append(coin).append("\n");
        }
        System.out.print(sb);
    }
}

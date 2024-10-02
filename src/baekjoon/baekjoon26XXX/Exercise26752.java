package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise26752 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = 1;
        for (int i = 2; i >= 0; i--) {
            time += Integer.parseInt(st.nextToken())*Math.pow(60, i);
        }
        time %= 86400;
        System.out.printf("%02d:%02d:%02d\n", time/3600, (time%3600)/60, time%60);
    }
}

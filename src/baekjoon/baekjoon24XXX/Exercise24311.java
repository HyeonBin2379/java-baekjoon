package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise24311 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startTime = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
        int regTime = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int moving = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int perStu = Integer.parseInt(br.readLine());

        int total = regTime + moving + (n+1)*perStu + 10;
        System.out.printf("%02d %02d\n", (startTime-total)/60, (startTime-total)%60);
    }
}

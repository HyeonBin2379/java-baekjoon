package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise28636 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), ":");
            int min = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            totalSum += 60*min + sec;
        }
        System.out.printf("%02d:%02d:%02d\n", totalSum/3600, (totalSum%3600)/60, totalSum%60);
    }
}

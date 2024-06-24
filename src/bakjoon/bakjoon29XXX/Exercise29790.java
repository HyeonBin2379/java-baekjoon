package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise29790 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        br.close();

        if (n < 1000) {
            System.out.println("Bad");
            return;
        }
        System.out.println((u >= 8000 || l >= 260) ? "Very Good" : "Good");
    }
}

package bakjoon.bakjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise8710 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        br.close();
        int count = 0;
        for (int i = k; i < w; i += m) {
            count++;
        }
        System.out.println(count);
    }
}

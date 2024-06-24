package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p; i++) {
            int punch = Integer.parseInt(st.nextToken());
            if (w <= punch && punch <= n) {
                count++;
            }
        }
        System.out.println(count);
    }
}

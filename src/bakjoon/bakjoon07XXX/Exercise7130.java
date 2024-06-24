package bakjoon.bakjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise7130 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int bee = Integer.parseInt(st.nextToken());
            sum += Math.max(cow*m, bee*h);
        }
        System.out.println(sum);
    }
}

package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise29918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] product = new int[6];
        int max = 0;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            product[i] = n+10*m;
            if (i > 0) {
                max = Math.max(product[i], max);
            }
        }
        System.out.println((max >= product[0]) ? max-product[0]+1 : 0);
    }
}

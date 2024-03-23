package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11176 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int j = 0; j < n; j++) {
                int use = Integer.parseInt(br.readLine());
                if (use > e) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}

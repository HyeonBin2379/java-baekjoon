package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise11170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int j = l; j <= r; j++) {
                int len = Integer.toString(j).length()-1;
                int num = j;
                for (int k = len; k >= 0; k--) {
                    int div = (int) Math.pow(10, k);
                    if (num / div == 0) {
                        count++;
                    }
                    num %= div;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }
}

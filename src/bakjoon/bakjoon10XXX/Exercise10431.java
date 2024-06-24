package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise10431 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] num = new int[20];
            int total = 0;

            for (int i = 0; i < 20; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < 19; i++) {
                for (int j = i+1; j < 20; j++) {
                    if (num[i] > num[j]) {
                        int temp = num[i];
                        num[i] = num[j];
                        num[j] = temp;
                        total++;
                    }
                }
            }
            sb.append(n).append(" ").append(total).append("\n");
        }
        System.out.print(sb);
    }
}

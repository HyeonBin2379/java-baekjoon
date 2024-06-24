package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise26350 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] num = new int[size];
            sb.append("Denominations:");
            for (int j = 0; j < size; j++) {
                num[j] = Integer.parseInt(st.nextToken());
                sb.append(" ").append(num[j]);
                if (j == size-1) {
                    sb.append("\n");
                }
            }
            sb.append(isGood(num) ? "Good coin denominations!\n\n" : "Bad coin denominations!\n\n");
        }
        System.out.print(sb);
    }

    public static boolean isGood(int[] num) {
        for (int i = 0; i < num.length-1; i++) {
            if ((num[i+1]/num[i]) < 2) {
                return false;
            }
        }
        return true;
    }
}

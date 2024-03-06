package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise25822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int coin = Math.min((int) (Double.parseDouble(br.readLine())/0.99), 2);
        int days = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sum = new int[days+1];
        int max = 0;
        for (int i = 1; i <= days; i++) {
            int solved = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + ((solved == 0) ? 1 : 0);
            max = Math.max(max, solved);
        }

        int start = 1, end = 1;
        int maxDays = 0;
        while (end <= days){
            int needed = sum[end] - sum[start-1];
            if (needed <= coin) {
                maxDays = Math.max(maxDays, end-start+1);
                end++;
            } else {
                start++;
            }
        }
        System.out.println(maxDays);
        System.out.println(max);
    }
}

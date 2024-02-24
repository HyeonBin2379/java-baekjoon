package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise25881 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int rate1 = Integer.parseInt(st.nextToken());
        int rate2 = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int used = Integer.parseInt(br.readLine());
            int fee = Math.min(used, 1000)*Math.min(rate1, rate2) + Math.max(used-1000, 0)*Math.max(rate1, rate2);
            bw.write(String.format("%d %d\n", used, fee));
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

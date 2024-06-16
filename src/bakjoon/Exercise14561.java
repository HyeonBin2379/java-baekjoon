package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise14561 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long num = Long.parseLong(st.nextToken());
            int base = Integer.parseInt(st.nextToken());

            char[] newNum = Long.toString(num, base).toCharArray();
            int answer = 1;
            for (int i = 0; i <= newNum.length/2; i++) {
                if (newNum[i] != newNum[newNum.length-1-i]) {
                    answer = 0;
                    break;
                }
            }
            bw.write(answer + "\n");
        }
        br.close();
        bw.close();
    }
}

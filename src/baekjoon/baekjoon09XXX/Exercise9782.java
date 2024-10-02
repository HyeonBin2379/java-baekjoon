package baekjoon.baekjoon09XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise9782 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCount = 0;
        while (true) {
            int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (num[0] == 0) {
                break;
            }
            int mid = num.length/2;
            double median = ((num.length-1) % 2 == 1) ? num[mid] : (num[mid] + num[mid+1])/2.0;
            bw.write(String.format("Case %d: %.1f\n", ++caseCount, median));
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

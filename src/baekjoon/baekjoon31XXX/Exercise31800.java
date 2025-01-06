package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Exercise31800 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long[] profit = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Long[] sorted = Arrays.stream(profit).boxed().sorted(Comparator.reverseOrder()).toArray(Long[]::new);
        for (int i = 0; i < n; i++) {
            long answer = sorted[0] == profit[i] ? profit[i] - sorted[1] : profit[i] - sorted[0];
            bw.write(answer + " ");
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();
        bw.flush();
        bw.close();
    }
}

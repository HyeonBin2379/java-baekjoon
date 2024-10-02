package baekjoon.baekjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Exercise30489 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Long[] downloaded = Arrays.stream(br.readLine().split(" ", n))
                .map(Long::parseLong)
                .sorted(Comparator.reverseOrder())
                .toArray(Long[]::new);

        long sum = Arrays.stream(downloaded).reduce(0L, Long::sum);
        long proceeded = Arrays.stream(downloaded, 0, Math.min(m+k, n)).reduce(0L, Long::sum);
        System.out.printf("%.4f\n", (double)(proceeded*100)/sum);
    }
}

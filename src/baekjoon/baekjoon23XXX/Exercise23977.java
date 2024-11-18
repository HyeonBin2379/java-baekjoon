package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise23977 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] num = Arrays.stream(br.readLine().split(" ", n)).mapToLong(Long::parseLong).toArray();

        long answer = 1L;
        // 유클리드 호제법을 이용하여 입력한 수들의 최소공배수를 구한 후
        for (int i = 0; i < n; i++) {
            answer = (answer*num[i]) / getGCD(answer, num[i]);
        }
        // 최종적으로 구한 최소공배수에서 k만큼을 뺀다.(어차피 빼게 되는 값은 k로 항상 동일하므로)
        System.out.println(answer-k);
    }

    private static long getGCD(long a, long b) {
        while (b > 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

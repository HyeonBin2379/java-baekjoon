package baekjoon.baekjoon24XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise24348 {
    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] num = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(num);
        makePerm(num, 0);
        System.out.println(answer);
    }

    public static void makePerm(long[] num, int depth) {
        if (depth == 3) {
            answer = Math.max(answer, num[0]+(num[1]*num[2]));
            answer = Math.max(answer, (num[0]*num[1])+num[2]);
            return;
        }

        for (int i = depth; i < 3; i++) {
            swap(num, depth, i);
            makePerm(num, depth+1);
            swap(num, depth, i);
        }
    }

    private static void swap(long[] num, int depth, int i) {
        long temp = num[depth];
        num[depth] = num[i];
        num[i] = temp;
    }
}

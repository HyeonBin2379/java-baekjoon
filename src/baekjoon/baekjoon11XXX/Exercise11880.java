package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise11880 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            long[] len = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long case1 = (len[0]+len[1])*(len[0]+len[1]) + len[2]*len[2];
            long case2 = (len[0]+len[2])*(len[0]+len[2]) + len[1]*len[1];
            long case3 = (len[1]+len[2])*(len[1]+len[2]) + len[0]*len[0];
            System.out.println(Math.min(Math.min(case1, case2), case3));
        }
    }
}

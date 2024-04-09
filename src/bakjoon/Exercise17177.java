package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise17177 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] len = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 실수형으로 인한 오차를 없애기 위해 대각선 길이의 제곱만 연산
        int d1 = len[0]*len[0] - len[1]*len[1];
        int d2 = len[0]*len[0] - len[2]*len[2];

        // 대각선 길이를 제곱한 값끼리 곱했으므로 여기서 제곱근을 구하면 대각선 길이의 곱
        int answer = ((int) Math.sqrt(d1*d2) - len[1]*len[2])/len[0];
        System.out.println(answer > 0 ? answer : -1);
    }
}

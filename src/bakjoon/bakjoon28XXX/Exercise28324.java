package bakjoon.bakjoon28XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise28324 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] speed = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long result = 1, prevSpeed = 1;
        for (int i = n-2; i >= 0; i--) {
            // 속력을 낮출 때는 이전 속력에서 1만큼 낮출 수 있음
            if (prevSpeed < speed[i]) {
                prevSpeed++;
            }
            // 속력을 높일 때는 이전 속력의 최대제한만큼 높일 수 있음
            else if (prevSpeed > speed[i]) {
                prevSpeed = speed[i];
            }
            result += prevSpeed;
        }
        System.out.println(result);
    }
}

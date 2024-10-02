package baekjoon.baekjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise22950 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            // 이진수 값이 0인 경우
            if (i == n) {
                break;
            }
            // 1의 자리부터 연속되는 0의 개수가 k개 미만
            if (input.charAt(n-1-i) == '1') {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}

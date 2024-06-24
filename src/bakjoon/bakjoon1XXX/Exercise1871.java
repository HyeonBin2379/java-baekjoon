package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise1871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), "-");
            char[] firstPart = st.nextToken().toCharArray();
            int num = Integer.parseInt(st.nextToken());

            int result = 0;
            for (int j = 0; j < 3; j++) {
                result += (int) Math.pow(26, 2 - j) * (firstPart[j] - 'A');
            }
            System.out.println(Math.abs(result-num) <= 100 ? "nice" : "not nice");
        }
    }
}

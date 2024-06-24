package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise26714 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String testResult = br.readLine();

        int groupSize = n/10;
        int answer = 0;
        for (int i = 0; i < n; i += groupSize) {
            if (testResult.substring(i, i+groupSize).contains("N")) {
                continue;
            }
            answer++;
        }
        System.out.println(answer);
    }
}

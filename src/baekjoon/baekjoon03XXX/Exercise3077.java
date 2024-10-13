package baekjoon.baekjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise3077 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> answer = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            answer.put(st.nextToken(), i);
        }

        String[] input = br.readLine().split(" ");
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (answer.get(input[i]) < answer.get(input[j])) {
                    count++;
                }
            }
        }
        System.out.printf("%d/%d\n", count, n*(n-1)/2);
    }
}

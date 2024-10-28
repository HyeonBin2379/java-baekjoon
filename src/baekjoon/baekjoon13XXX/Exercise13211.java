package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exercise13211 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> stolen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String id = br.readLine();
            stolen.add(id);
        }

        int m = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < m; i++) {
            String id = br.readLine();
            if (stolen.contains(id)) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}

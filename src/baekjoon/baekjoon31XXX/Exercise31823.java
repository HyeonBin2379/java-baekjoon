package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise31823 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> strick = new HashSet<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            int max = 0, count = 0;
            for (int j = 0; j < m; j++) {
                if (data[j].equals(".")) {
                    count++;
                    max = Math.max(count, max);
                } else {
                    count = 0;
                }
            }
            strick.add(max);
            result.add(max + " " + data[m]);
        }
        System.out.println(strick.size());
        result.forEach(System.out::println);
    }
}

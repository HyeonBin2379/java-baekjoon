package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise12018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> chosen = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Integer[] point = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .sorted(Comparator.reverseOrder())
                    .limit(l)
                    .toArray(Integer[]::new);
            chosen.add((p < l) ? 1 : point[l-1]);
        }

        int answer = 0;
        chosen.sort(null);
        for (Integer value : chosen) {
            if (m >= value) {
                m -= value;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

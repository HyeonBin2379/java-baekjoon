package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise6799 {

    private static class Com implements Comparable<Com>{
        String name;
        int score;

        public Com(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Com o) {
            return o.score != this.score ? Integer.compare(o.score, this.score) : this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Com> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            result.add(new Com(name, 2*r+3*s+d));
        }
        Collections.sort(result);
        result.stream()
                .limit(2)
                .forEach(com -> System.out.println(com.name));
    }
}

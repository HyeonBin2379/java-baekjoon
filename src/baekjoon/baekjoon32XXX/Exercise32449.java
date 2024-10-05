package baekjoon.baekjoon32XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise32449 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Long> other = new ArrayList<>();
        long maxPig = 0L;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String species = st.nextToken();
            long influence = Long.parseLong(st.nextToken());
            if (species.equals("pig")) {
                maxPig = Math.max(influence, maxPig);
            } else {
                other.add(influence);
            }
        }
        long finalMaxPig = maxPig;
        long total = other.stream().sorted().takeWhile(influence -> influence < finalMaxPig).reduce(0L, Long::sum);
        System.out.println(maxPig + total);
    }
}

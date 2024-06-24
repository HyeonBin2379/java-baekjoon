package bakjoon.bakjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise10471 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Set<Integer> size = new TreeSet<>();
        List<Integer> part = new ArrayList<>(List.of(0, w));
        for (int i = 1; i <= p; i++) {
            int now = Integer.parseInt(st.nextToken());
            for (int partition : part) {
                size.add(Math.abs(now-partition));
            }
            part.add(now);
        }
        size.forEach(value -> System.out.print(value + " "));
        System.out.println(w);
    }
}
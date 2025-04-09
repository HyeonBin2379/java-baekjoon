package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> notHeard = new HashSet<>();
        while (n-- > 0) {
            String name = br.readLine();
            notHeard.add(name);
        }

        Set<String> notSeen = new HashSet<>();
        while (m-- > 0) {
            String name = br.readLine();
            notSeen.add(name);
        }
        notHeard.retainAll(notSeen);

        System.out.println(notHeard.size());
        if (!notHeard.isEmpty()) {
            notHeard.stream().sorted().forEach(System.out::println);
        }
    }
}

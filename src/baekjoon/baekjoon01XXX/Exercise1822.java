package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Exercise1822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<Integer> a = Arrays.stream(br.readLine().split(" ", n))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
        HashSet<Integer> b = Arrays.stream(br.readLine().split(" ", m))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(HashSet::new));

        if (b.containsAll(a)) {
            System.out.println(0);
            return;
        }
        sb.append(a.stream().filter(integer -> !b.contains(integer)).count()).append("\n");
        a.stream().filter(integer -> !b.contains(integer)).forEach(integer -> sb.append(integer).append(" "));
        System.out.println(sb);
    }
}

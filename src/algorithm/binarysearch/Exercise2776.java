package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Exercise2776 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            TreeSet<Integer> set = Arrays.stream(br.readLine().split(" ", n)).map(Integer::parseInt)
                    .collect(Collectors.toCollection(TreeSet::new));

            int m = Integer.parseInt(br.readLine());
            Arrays.stream(br.readLine().split(" ", m)).map(Integer::parseInt).forEach(value -> {
                if (set.contains(value)) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            });
        }
        System.out.println(sb);
    }
}

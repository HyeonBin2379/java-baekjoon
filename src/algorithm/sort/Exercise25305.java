package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise25305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> awarded = Arrays.stream(br.readLine().split(" ", n))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .collect(Collectors.toList());
        System.out.println(awarded.get(k-1));
    }
}

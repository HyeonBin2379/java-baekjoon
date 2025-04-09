package algorithm.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> set1 = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toSet());
        set1.retainAll(set2);

        System.out.println(n+m-2*set1.size());
    }
}

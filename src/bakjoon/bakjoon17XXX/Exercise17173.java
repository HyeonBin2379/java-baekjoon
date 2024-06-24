package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise17173 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = Arrays.stream(br.readLine().split(" ", m)).mapToInt(Integer::parseInt).toArray();

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j % num[i] == 0) {
                    set.add(j);
                }
            }
        }
        int sum = 0;
        for (Integer number : set) {
            sum += number;
        }
        System.out.println(sum);
    }
}

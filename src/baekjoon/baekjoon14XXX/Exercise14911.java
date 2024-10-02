package baekjoon.baekjoon14XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Exercise14911 {

    private static final Set<String> result = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int sum = Integer.parseInt(br.readLine());

        for (int i = 0; i < num.length-1; i++) {
            for (int j = i+1; j < num.length; j++) {
                if (num[i]+num[j] == sum) {
                    result.add(num[i] + " " + num[j]);
                    break;
                }
            }
        }
        result.forEach(System.out::println);
        System.out.println(result.size());
    }
}

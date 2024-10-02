package baekjoon.baekjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise13116 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Set<Integer> set1 = getNumbers(Integer.parseInt(st.nextToken()));
            Set<Integer> set2 = getNumbers(Integer.parseInt(st.nextToken()));
            set1.retainAll(set2);
            int max = set1.stream().max(Comparator.comparingInt(value -> value)).get();
            System.out.println(max * 10);
        }
    }

    private static Set<Integer> getNumbers(int num) {
        Set<Integer> result = new TreeSet<>();
        while (num > 0) {
            result.add(num);
            num /= 2;
        }
        return result;
    }
}

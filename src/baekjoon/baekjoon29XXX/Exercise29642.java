package baekjoon.baekjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise29642 {

    private static final Set<Integer> brokenKeys = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] days = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).sorted().toArray();
        if (k > 0) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                brokenKeys.add(Integer.parseInt(st.nextToken()));
            }
        }

        long[] count = new long[days[n-1]+1];
        for (int i = 1; i < count.length; i++) {
            count[i] = needPencil(i) ? count[i-1]+1 : count[i-1];
        }
        System.out.println(Arrays.stream(days).mapToLong(d -> count[d]).sum());
    }

    private static boolean needPencil(int num) {
        while (num > 0) {
            int digit = num % 10;
            if (brokenKeys.contains(digit)) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}

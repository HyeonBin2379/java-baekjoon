package baekjoon.baekjoon04XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise4881 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 || b == 0) {
                break;
            }
            List<Integer> cycle1 = getCycle(a);
            List<Integer> cycle2 = getCycle(b);

            List<Integer> temp = new ArrayList<>(cycle1);
            temp.retainAll(cycle2);
            if (temp.isEmpty()) {
                System.out.printf("%d %d %d\n", a, b, 0);
                continue;
            }

            int minDist = Integer.MAX_VALUE;
            for (int num : temp) {
                int idx1 = cycle1.indexOf(num)+1;
                int idx2 = cycle2.indexOf(num)+1;
                minDist = Math.min(idx1+idx2, minDist);
            }
            System.out.printf("%d %d %d\n", a, b, minDist);
        }
    }

    private static List<Integer> getCycle(int start) {
        List<Integer> cycle = new ArrayList<>();
        int now = start;
        while (!cycle.contains(now)) {
            cycle.add(now);
            now = getSum(now);
        }
        return cycle;
    }
    private static int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            int d = num % 10;
            sum += d*d;
            num /= 10;
        }
        return sum;
    }
}

package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise26336 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalDist = Integer.parseInt(st.nextToken());
            int refueling = Integer.parseInt(st.nextToken());
            int eating = Integer.parseInt(st.nextToken());

            int gas = (totalDist-1) / refueling;
            int meal = (totalDist-1) / eating;
            int overlap = (totalDist-1) / lcm(refueling, eating);
            int total = (gas + meal) - overlap;

            System.out.printf("%d %d %d\n%d\n", totalDist, refueling, eating, total);
        }
    }

    private static int lcm(int a, int b) {
        return (a*b)/gcd(a, b);
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

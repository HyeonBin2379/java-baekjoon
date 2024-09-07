package bakjoon.bakjoon13XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise13366 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            int digitSum = br.readLine().chars().map(ch -> ch-'0').sum();
            System.out.println(digitSum % 9 == 0 ? "YES" : "NO");
        }
    }
}

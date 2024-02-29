package bakjoon;

import java.io.*;
import java.util.*;

public class Exercise30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] reserved = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int needT = 0;
        for (int j : reserved) {
            needT += (int) Math.ceil((double) j / t);
        }
        System.out.println(needT);
        System.out.println((n / p) + " " + (n % p));
    }
}

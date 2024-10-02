package baekjoon.baekjoon27XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise27939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] color = br.readLine().split(" ");

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean result = false;
        for (int i = 0; i < m; i++) {
            int[] plants = Arrays.stream(br.readLine().split(" ")).mapToInt(value -> Integer.parseInt(value)-1).toArray();
            boolean isPurple = Arrays.stream(plants).anyMatch(value -> color[value].equals("P"));
            if (!isPurple) {
                result = true;
            }
        }
        System.out.println(result ? "W" : "P");
    }
}

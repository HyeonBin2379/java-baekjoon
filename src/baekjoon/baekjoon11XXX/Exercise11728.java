package baekjoon.baekjoon11XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] length = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int[] result = new int[length[0]+length[1]];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length[0]; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length[1]; i++) {
            result[i+length[0]] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(result);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(result).forEach(value -> sb.append(value).append(" "));
        System.out.println(sb);
    }
}

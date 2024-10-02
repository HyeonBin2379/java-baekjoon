package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long unit = Integer.parseInt(st.nextToken());
        long area = Integer.parseInt(st.nextToken());
        long[] participant = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        br.close();

        long[] answer = new long[participant.length];
        long total = unit * area;
        for (int i = 0; i < participant.length; i++) {
            answer[i] = participant[i] - total;
        }
        Arrays.stream(answer).forEach(value -> System.out.print(value + " "));
    }
}

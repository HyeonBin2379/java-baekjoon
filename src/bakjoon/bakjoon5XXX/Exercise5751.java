package bakjoon.bakjoon5XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise5751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int count = Integer.parseInt(br.readLine());
            if (count == 0) {
                break;
            }
            int[] round = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int mary = (int) Arrays.stream(round).filter(value -> value == 0).count();
            sb.append(String.format("Mary won %d times and John won %d times\n", mary, count-mary));
        }
        System.out.print(sb);
    }
}

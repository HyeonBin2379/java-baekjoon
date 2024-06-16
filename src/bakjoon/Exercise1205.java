package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise1205 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n == 0) {
            System.out.println(1);
            return;
        }

        List<Integer> score = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
        int rank = 1;
        int count = 0;
        for (Integer s : score) {
            if (s < newScore) {
                break;
            } else if (s > newScore) {
                rank++;
            }
            count++;
        }
        System.out.println(count == p ? -1 : rank);
    }
}

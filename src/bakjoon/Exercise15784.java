package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise15784 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;

        int[][] charm = new int[size][size];
        for (int i = 0; i < size; i++) {
            charm[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < size; i++) {
            if (charm[i][c] > charm[r][c] || charm[r][i] > charm[r][c]) {
                System.out.println("ANGRY");
                return;
            }
        }
        System.out.println("HAPPY");
    }
}

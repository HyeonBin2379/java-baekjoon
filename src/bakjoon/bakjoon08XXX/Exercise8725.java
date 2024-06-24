package bakjoon.bakjoon08XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise8725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < size; i++) {
            int[] board = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(board);
            sum += Math.max(board[size-1], 0);
        }
        System.out.println(sum);
    }
}
